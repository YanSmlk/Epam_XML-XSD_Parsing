package yan.epam.task3.exception;


public class XmlBuilderException extends Exception
{

        public XmlBuilderException(String msg, String fileName)
        {
            super(msg+fileName);
        }

        public XmlBuilderException(String msg)
        {
            super(msg);
        }
}
