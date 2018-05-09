package yan.epam.task3.builder.impl.jaxb;

import yan.epam.task3.builder.BaseBuilder;
import yan.epam.task3.builder.impl.jaxb.generated.Papers;
import yan.epam.task3.exception.XmlBuilderException;
import yan.epam.task3.paper.BasePaper;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class JAXBBuilder extends BaseBuilder
{

    @Override
    public void buildPapersArr(String filePath) throws XmlBuilderException
    {
        try
        {
            JAXBContext jc = JAXBContext.newInstance(Papers.class);
            Unmarshaller unmarshaller=jc.createUnmarshaller();
            FileReader reader=new FileReader(filePath);
            unmarshaller.unmarshal(reader);
            for (BasePaper paper : papersArr)
            {
                System.out.println(paper.toString());
            }
        }
        catch (JAXBException ex)
        {
            throw new XmlBuilderException(""+ex);
        }
        catch (FileNotFoundException ex)
        {
            throw new XmlBuilderException("No file found "+ex);
        }
    }

}
