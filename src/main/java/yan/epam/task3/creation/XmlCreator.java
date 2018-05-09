package yan.epam.task3.creation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import static yan.epam.task3.servlet.FrontController.LOGGER;

public class XmlCreator
{

    public static void writeXmlFile(InputStream fileContent,String fileName)
    {
        try
        {
            File file = new File(fileName);
            Files.copy(fileContent, file.toPath());
            LOGGER.info("Xml file created");
        }
        catch (IOException ex)
        {
                LOGGER.info("An Xml file with this name already exists, the old file will be used");
        }
    }
}
