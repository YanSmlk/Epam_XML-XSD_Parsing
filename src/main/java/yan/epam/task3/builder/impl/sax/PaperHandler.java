package yan.epam.task3.builder.impl.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import yan.epam.task3.paper.BasePaper;
import yan.epam.task3.paper.impl.Booklet;
import yan.epam.task3.paper.impl.Journal;
import yan.epam.task3.paper.impl.Newspaper;
import java.util.ArrayList;

public class PaperHandler extends DefaultHandler
{
    private ArrayList<BasePaper> papersArr=new ArrayList<>();
    private BasePaper currentPaper;
    private String currentElement;

    public ArrayList<BasePaper> getPapersArr()
    {
        return papersArr;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs)
    {
        switch (localName)
        {
            case "newspaper":
                paperCreator("newspaper",attrs);
                break;
            case "journal":
                paperCreator("journal",attrs);
                break;
            case "booklet":
                paperCreator("booklet",attrs);
                break;
            case "title":
                currentElement="title";
                break;
            case "mounthly":
                currentElement="mounthly";
                break;
            case "colored":
                currentElement="colored";
                break;
            case "pages":
                currentElement="pages";
                break;
            case "glossy":
                currentElement="glossy";
                break;

        }
    }

    @Override
    public void characters(char[] ch,int start, int length)
    {
        String info=new String(ch,start,length);
        if (currentElement!=null)
        {
            switch (currentElement)
            {
                case "title":
                    currentPaper.setTitle(info);
                    break;
                case "mounthly":
                    currentPaper.setMounthly(Boolean.valueOf(info));
                    break;
                case "colored":
                    currentPaper.setColored(Boolean.valueOf(info));
                    break;
                case "pages":
                    currentPaper.setPages(Integer.parseInt(info));
                    break;
                case "glossy":
                    currentPaper.setGlossy(Boolean.valueOf(info));
                    break;
            }
        }
        currentElement=null;
    }

    @Override
    public void endElement(String uri,String localName, String qName)
    {
        if("newspaper".equals(localName)||"journal".equals(localName)||"booklet".equals(localName))
        {
            papersArr.add(currentPaper);
        }
    }


    private void paperCreator(String paperType,Attributes attrs)
    {
        final int INT_ID=0;
        final int INDEX_ID_=1;
        String[] attrArr=new String[2];
        for(int i=0;i<attrs.getLength();i++)
        {
            attrArr[i]=attrs.getValue(i);
        }
        switch (paperType)
        {
            case "newspaper":
                currentPaper=new Newspaper(attrArr[INT_ID],Integer.parseInt(attrArr[INDEX_ID_]));
                break;
            case "journal":
                currentPaper=new Journal(attrArr[INT_ID],Integer.parseInt(attrArr[INDEX_ID_]));
                break;
            case "booklet":
                currentPaper=new Booklet(attrArr[INT_ID]);
                break;
        }
    }


}
