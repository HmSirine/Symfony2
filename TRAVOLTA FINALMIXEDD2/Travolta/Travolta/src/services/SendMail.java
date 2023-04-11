package services;

// Import the necessary packages for sending emails
import models.Reclamation;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendMail {

    public static void sendReclamationNotification(String adminEmailAddress, Reclamation reclamation) throws MessagingException {
        
        // Set up the email session properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Authenticate with the email server using your email and password
        String email = "travolta.voyage@gmail.com";
        String password = "tfhbrfhzjionkvds";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        // Construct message body
    String messageBody = "<html><body><h1>Nouvelle réclamation</h1><p>Objet : " + reclamation.getObjet() + "</p><p>Message : " + reclamation.getMSG() + "</p></body></html>";

       // Create a new message
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress("your.email@gmail.com"));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adminEmailAddress));
    message.setSubject("Nouvelle réclamation");
    message.setContent(messageBody, "text/html");
        // Send the message
        Transport.send(message);
    }
}
