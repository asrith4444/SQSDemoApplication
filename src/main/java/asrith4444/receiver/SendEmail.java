package asrith4444.receiver;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
	//Sending Email
    public  void sendMail(String to, String subject, String body) 
    {
    	//From Mail ID
        String from = Details.mailID;
        //Password of From MailID
        String password = Details.password;
        //Host = We are using Gmail so we need to Gmail host.
        String host = "smtp.gmail.com";
        
        Properties properties = System.getProperties();
        //We need to set some properties to send the mail.
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        //Create session with the properties
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            	//Authenticate with providing the From GmailID and the Password.
                return new PasswordAuthentication(from, password);
            }
        });
        try {
        	//Providing Session to MIME to send Mail
            MimeMessage message = new MimeMessage(session);
            //Set the from address
            message.setFrom(new InternetAddress(from));
            //Set the To address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //Set the Subject of Mail
            message.setSubject(subject);
            //Set the Body of the Mail
            message.setText(body);
            System.out.println("\nSending mail to "+to+".");
            Transport.send(message);//Sending Mail
            System.out.println("\nMail sent successfully to "+to+".");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
