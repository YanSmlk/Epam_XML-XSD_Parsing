package yan.epam.task3.builder;

import yan.epam.task3.builder.impl.dom.DOMBuilder;
import yan.epam.task3.builder.impl.jaxb.JAXBBuilder;
import yan.epam.task3.builder.impl.sax.SAXBuilder;
import yan.epam.task3.builder.impl.stax.StAXBuilder;
import yan.epam.task3.exception.XmlBuilderException;
import yan.epam.task3.paper.BasePaper;
import java.util.ArrayList;

public class Director
{
    public static ArrayList<BasePaper> createPapers(String parserType, String filePath) throws XmlBuilderException
    {
        ArrayList<BasePaper> papersArr;
        BaseBuilder builder;
            switch (parserType)
            {
                case "DOM":
                    builder = new DOMBuilder();
                   break;
                case "SAX":
                    builder = new SAXBuilder();
                   break;
                case "StAX":
                    builder = new StAXBuilder();
                    break;
                case "JAXB":
                    builder = new JAXBBuilder();
                    break;
                default:
                    throw new XmlBuilderException("Incorrect parser type");
            }
            builder.buildPapersArr(filePath);
            papersArr = builder.getPapersArr();
            return papersArr;
    }

    public static ArrayList<BasePaper> getNewspapers(ArrayList<BasePaper> papersArr)
    {
        ArrayList<BasePaper> newspapers=new ArrayList<>();
        for (BasePaper paper : papersArr)
        {
            String className=(paper.getClass().getSimpleName());
            if ("Newspaper".equals(className))
            {
                newspapers.add(paper);
            }
        }
        return newspapers;
    }

    public static ArrayList<BasePaper> getJournals(ArrayList<BasePaper> papersArr)
    {
        ArrayList<BasePaper> journals=new ArrayList<>();
        for (BasePaper paper : papersArr)
        {
            String className=(paper.getClass().getSimpleName());
            if ("Journal".equals(className))
            {
                journals.add(paper);
            }
        }
        return journals;
    }

    public static ArrayList<BasePaper> getBooklets(ArrayList<BasePaper> papersArr)
    {
        ArrayList<BasePaper> booklets=new ArrayList<>();
        for (BasePaper paper : papersArr)
        {
            String className=(paper.getClass().getSimpleName());
            if ("Booklet".equals(className))
            {
                booklets.add(paper);
            }
        }
        return booklets;
    }

}
