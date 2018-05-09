package yan.epam.task3.servlet;

import org.apache.log4j.Logger;
import yan.epam.task3.builder.Director;
import yan.epam.task3.exception.EmailException;
import yan.epam.task3.exception.XmlBuilderException;
import yan.epam.task3.mail.Mail;
import yan.epam.task3.paper.BasePaper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import static yan.epam.task3.creation.XmlCreator.writeXmlFile;

@MultipartConfig

public class FrontController extends javax.servlet.http.HttpServlet
{
   public static final Logger LOGGER=Logger.getRootLogger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher;
        Part filePart = request.getPart("file");
        String filePath = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        System.out.println(filePath);

        String lang=request.getParameter("lang");////////Session creation for language
        HttpSession session=request.getSession(true);
        session.setAttribute("lang",lang);

        if (!filePath.isEmpty())
        {
            ArrayList<BasePaper> papersArr=new ArrayList<>();
            ArrayList<BasePaper> newspapers;
            ArrayList<BasePaper> journals;
            ArrayList<BasePaper> booklets;
            InputStream fileContent = filePart.getInputStream();
            writeXmlFile(fileContent, filePath);

            String action = request.getParameter("action");
            try
            {
                switch (action)
                {
                    case "dom":
                        LOGGER.info("DOM pares running...");
                        papersArr = Director.createPapers("DOM", filePath);
                        request.setAttribute("Parser","DOM");
                        break;
                    case "sax":
                        LOGGER.info("SAX pares running...");
                        papersArr = Director.createPapers("SAX", filePath);
                        request.setAttribute("Parser","SAX");
                        break;
                    case "stax":
                        LOGGER.info("StAX pares running...");
                        papersArr = Director.createPapers("StAX", filePath);
                        request.setAttribute("Parser","StAX");
                        break;
                    case "jaxb":
                        LOGGER.info("JAXB pares running...");
                        papersArr = Director.createPapers("JAXB", filePath);
                        request.setAttribute("Parser","JAXB");
                        break;
                }
                newspapers=Director.getNewspapers(papersArr);
                journals=Director.getJournals(papersArr);
                booklets=Director.getBooklets(papersArr);

                request.setAttribute("Newspapers",newspapers);
                request.setAttribute("Journals",journals);
                request.setAttribute("Booklets",booklets);

                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/table.jsp");
                dispatcher.forward(request, response);
            }
            catch (XmlBuilderException ex)
            {
                LOGGER.error(ex);
                request.setAttribute("Message","Thrown an exception: "+ex);
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/info.jsp");
                dispatcher.forward(request, response);
            }
        }
        else
        if ("sendMail".equals(request.getParameter("action")))
        {
            try
            {
                Mail mail = new Mail();
                mail.sendMail(request.getParameter("mailTo"), request.getParameter("mailText"));
                request.setAttribute("Message","E-mail sent to "+request.getParameter("mailTo"));
            }
            catch (EmailException ex)
            {
                LOGGER.error(ex);
                request.setAttribute("Message","Thrown an exception: "+ex);

            }
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/info.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            request.setAttribute("Message","File not selected");
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/info.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //
    }
}
