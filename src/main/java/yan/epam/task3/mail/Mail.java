package yan.epam.task3.mail;

import yan.epam.task3.exception.EmailException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static yan.epam.task3.servlet.FrontController.LOGGER;

public class Mail
{
    private final String USERNAME = "velos98@gmail.com";
    private final String PASSWORD = "testpass2518";
    private final String MAIL_SUBJECT ="Test mail!";

    public void sendMail(String mailTo, String mailText) throws EmailException
    {
    try
    {
        Properties prop = new Properties();
        String propFileName = "mail.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });

        Message message = new MimeMessage(session);
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mailTo));
        message.setSubject(MAIL_SUBJECT);
        message.setContent(mailText, "text/html; charset=utf-8");
        Transport.send(message);
        LOGGER.info("E-mail sent to "+mailTo);
    }
    catch (IOException ex)
    {
        throw new EmailException("Message sent failed: "+ex);
    }
    catch (MessagingException ex)
    {
        throw new EmailException("Message sent failed: "+ex);
    }

    }
}
