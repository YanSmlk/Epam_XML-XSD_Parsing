package yan.epam.task3.builder.impl.dom;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import yan.epam.task3.builder.BaseBuilder;
import yan.epam.task3.exception.XmlBuilderException;
import yan.epam.task3.paper.impl.Booklet;
import yan.epam.task3.paper.impl.Journal;
import yan.epam.task3.paper.impl.Newspaper;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMBuilder extends BaseBuilder
{

    @Override
    public void buildPapersArr(String filePath) throws XmlBuilderException
    {
        try
        {
            File XmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(XmlFile);
            document.getDocumentElement().normalize();
            NodeList newspaperNodeList = document.getElementsByTagName(NEWSPAPER);
            fillPapersArr(newspaperNodeList,NEWSPAPER);
            NodeList journalNodeList = document.getElementsByTagName(JOURNAL);
            fillPapersArr(journalNodeList,JOURNAL);
            NodeList bookletNodeList = document.getElementsByTagName(BOOKLET);
            fillPapersArr(bookletNodeList,BOOKLET);
        }
        catch (ParserConfigurationException ex)
        {
            throw new XmlBuilderException(ex+" In file: ",filePath);
        }
        catch (SAXException ex)
        {
            throw new XmlBuilderException("Error in SAX parser: "+ex+" with file: ",filePath);
        }
        catch (IOException ex)
        {
            throw new XmlBuilderException("Error in I/O stream: "+ex+" with file: ", filePath);
        }
    }

    private void fillPapersArr(NodeList nodeList, String paperType)
    {
        for (int temp = 0; temp < nodeList.getLength(); temp++)
        {
            Node nNode = nodeList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) nNode;
                String id=eElement.getAttribute("id");
                String title=eElement.getElementsByTagName("title").item(0).getTextContent();
                String mouthly=eElement.getElementsByTagName("mounthly").item(0).getTextContent();
                String colored=eElement.getElementsByTagName("colored").item(0).getTextContent();
                String pages=eElement.getElementsByTagName("pages").item(0).getTextContent();
                String glossy=eElement.getElementsByTagName("glossy").item(0).getTextContent();

                switch (paperType)
                {
                    case NEWSPAPER:
                        String indexNews=eElement.getAttribute("index");
                        Newspaper newspaper=new Newspaper(id,Integer.parseInt(indexNews),title,Boolean.valueOf(mouthly),
                                Boolean.valueOf(colored),Integer.parseInt(pages),Boolean.valueOf(glossy));
                        papersArr.add(newspaper);
                        break;
                    case JOURNAL:
                        String indexJourn=eElement.getAttribute("index");
                        Journal journal=new Journal(id,Integer.parseInt(indexJourn),title,Boolean.valueOf(mouthly),
                                Boolean.valueOf(colored),Integer.parseInt(pages),Boolean.valueOf(glossy));
                        papersArr.add(journal);
                        break;
                    case BOOKLET:
                        Booklet booklet=new Booklet(id,title,Boolean.valueOf(mouthly),
                                Boolean.valueOf(colored),Integer.parseInt(pages),Boolean.valueOf(glossy));
                        papersArr.add(booklet);
                        break;
                }
            }
        }
    }

}