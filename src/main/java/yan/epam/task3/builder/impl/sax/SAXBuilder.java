package yan.epam.task3.builder.impl.sax;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import yan.epam.task3.builder.BaseBuilder;
import yan.epam.task3.exception.XmlBuilderException;
import java.io.IOException;

public class SAXBuilder extends BaseBuilder
{

    private PaperHandler paperHandler;
    private XMLReader reader;

    public SAXBuilder() throws XmlBuilderException
    {
        paperHandler=new PaperHandler();
        try
        {
            reader= XMLReaderFactory.createXMLReader();
            reader.setContentHandler(paperHandler);
        }
        catch (SAXException ex)
        {
            throw new XmlBuilderException("Error in SAX parser: "+ex);
        }
    }

    @Override
    public void buildPapersArr(String filePath) throws XmlBuilderException
    {
        try
        {
            reader.parse(filePath);
            papersArr=paperHandler.getPapersArr();
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

}
