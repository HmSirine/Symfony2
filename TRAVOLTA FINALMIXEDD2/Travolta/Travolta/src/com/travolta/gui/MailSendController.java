/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.travolta.gui;




import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author 21695
 */
public class MailSendController implements Initializable {

    @FXML
    private TextField textTo;
    @FXML
    private TextArea TextC;
    @FXML
    private TextField textEmail;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {
        

    

        // Recipient's email address
        String to = "aghx01@gmail.com";
        
        // Sender's email address
        String from = "iyed.zidi@esprit.tn";
        
        // Sender's email password
        String password = "181JMT1037";
        
        // Setup properties for the SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        // Authenticate the sender's email account
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        
        // Create a new email session
        Session session = Session.getInstance(props, auth);
        
        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            
            // Set the recipient, sender, subject, and content of the message
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Test Email");
            message.setText("This is a test email.");
            
            // Send the email
            Transport.send(message);
            
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}

        
    
    
