/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendemail;

import Propiedades.Propiedades;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Alfredo Mariño
 */
public class sendEmailSOF {
   
    private class SMTPAuthenticator extends Authenticator
{
    public PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication("ushcau@gmail.com", "kuscpclebdfilcxc");
    }
}
    
    public void sendEmaiSOP(){
        
        Propiedades ConfigEmail = new Propiedades("EmailsProperties.properties");   
        /*
        inputStream = getClass().getClassLoader().getResourceAsStream("/EmailsProperties.properties");
        if (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException ex) {
                Logger.getLogger(sendEmailSOF.class.getName()).log(Level.SEVERE, null, ex);
            }
	} else {
            try {
                throw new FileNotFoundException("property file not found in the classpath");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(sendEmailSOF.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
        */
        try {
            /* CONSTANTES ESCRITAS EN EL EMAIL PROPERTIES
            String  d_email = "ushcau@gmail.com";
            String      d_password = "kuscpclebdfilcxc";
            String      d_host = "smtp.gmail.com";
            String       d_port  = "465"; //465,587
            */
            String  d_email = ConfigEmail.getProperty("userEmail");
            String      d_password = ConfigEmail.getProperty("passEmail");
            String      d_host = ConfigEmail.getProperty("hostEmail");
            String       d_port  = ConfigEmail.getProperty("portEmail");
            
            String      m_to = "alfredoalejandro95@hotmail.com";
            String      m_subject = "Testing";
            String      m_text = "This is a test. marico el que lo lea";
            Properties props = new Properties();
            props.put("mail.smtp.user", d_email);
            props.put("mail.smtp.host", d_host);
            props.put("mail.smtp.port", d_port);
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.debug", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.port", d_port);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            SMTPAuthenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);
            MimeMessage msg = new MimeMessage(session);
            msg.setText(m_text);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            Transport.send(msg);
            //return true;
        } catch (MessagingException ex) {
            Logger.getLogger(sendEmailSOF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
     }


}
