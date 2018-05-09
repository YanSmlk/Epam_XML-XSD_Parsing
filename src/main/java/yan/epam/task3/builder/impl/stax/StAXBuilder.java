package yan.epam.task3.builder.impl.stax;

import yan.epam.task3.builder.BaseBuilder;
import yan.epam.task3.exception.XmlBuilderException;
import yan.epam.task3.paper.BasePaper;
import yan.epam.task3.paper.impl.Booklet;
import yan.epam.task3.paper.impl.Journal;
import yan.epam.task3.paper.impl.Newspaper;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StAXBuilder extends BaseBuilder
{
    private XMLInputFactory inputFactory;

    public  StAXBuilder()
    {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildPapersArr(String filePath) throws XmlBuilderException
    {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        BasePaper paper;
        try
        {
            inputStream = new FileInputStream(new File(filePath));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext())
            {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT)
                {
                    name = reader.getLocalName();
                    switch (name)
                    {
                        case NEWSPAPER:
                           paper=fillPapersArr(reader, "newspaper");
                           papersArr.add(paper);
                            break;
                        case JOURNAL:
                            paper=fillPapersArr(reader, "journal");
                            papersArr.add(paper);
                            break;
                        case BOOKLET:
                             paper=fillPapersArr(reader, "booklet");
                            papersArr.add(paper);
                            break;
                    }
                }
            }
        }
        catch (XMLStreamException ex)
        {
            throw new XmlBuilderException("StAX parsing error: "+ex);
        }
        catch (FileNotFoundException ex)
        {
            throw new XmlBuilderException("File " + filePath + " not found "+ex);
        }
        finally
        {
            try
            {
                if (inputStream != null)
                {
                    inputStream.close();
                }
            }
            catch (IOException ex)
            {
                throw new XmlBuilderException("Impossible to close file:  " + filePath+". "+ex);
            }
        }
    }


    private BasePaper fillPapersArr(XMLStreamReader reader, String paperType) throws XmlBuilderException
    {
        String id=reader.getAttributeValue(null, "id");
        String index=reader.getAttributeValue(null, "index");
        BasePaper paper;
        switch (paperType)
        {
            case NEWSPAPER:
                paper=new Newspaper(id,Integer.parseInt(index));
                break;
            case JOURNAL:
                paper=new Journal(id,Integer.parseInt(index));
                break;
            default:
                paper=new Booklet(id);
                break;
        }
        String name;
        try
        {
            while (reader.hasNext())
            {
                int type = reader.next();
                switch (type)
                {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (name)
                        {
                            case "title":
                                paper.setTitle(getXMLText(reader));
                                break;
                            case "mounthly":
                                paper.setMounthly(Boolean.valueOf(getXMLText(reader)));
                                break;
                            case "colored":
                                paper.setColored(Boolean.valueOf(getXMLText(reader)));
                                break;
                            case "pages":
                                paper.setPages(Integer.parseInt(getXMLText(reader)));
                                break;
                            case "glossy":
                                paper.setGlossy(Boolean.valueOf(getXMLText(reader)));
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if(NEWSPAPER.equals(name)||JOURNAL.equals(name)||BOOKLET.equals(name))
                        {
                            return paper;
                        }
                        break;
                }
            }
        }
        catch (XMLStreamException ex)
        {
            throw new XmlBuilderException(""+ex);
        }
        throw new XmlBuilderException("Unknown element in tag");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException
    {
        String text=null;
        if (reader.hasNext())
        {
            reader.next();
            text=reader.getText();
        }
        return text;
    }


}
