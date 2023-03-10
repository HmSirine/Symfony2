/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author mr.rhimi
 */
public class EmailSender {
    private String from;
    private String to;
    private String subject;
    private String body;

    public EmailSender(String from, String to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public void send() throws MessagingException {
        // Set SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        


        // Create a JavaMail Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("iyed.zidi@esprit.tn", "181JMT1037");
            }
        });

        // Create a MimeMessage object
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);

        // Send the message using the Transport class
        Transport.send(message);
    }

    public static void main(String[] args) {
        EmailSender sender = new EmailSender("iyed.zidi@esprit.tn", "fiddlerl@yahoo.com", "Test Email", "This is a test email.");
        try {
            sender.send();
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

