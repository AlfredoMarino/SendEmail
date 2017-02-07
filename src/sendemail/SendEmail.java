/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendemail;

import DB.Estado;
import static DB.Estado_.codigoEstado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Alfredo Mariño
 */
public class SendEmail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        /* ENVIO DE CORREOS FUNCIONANDO
        sendEmailSOF despachador = new sendEmailSOF();
        //despachador.sendEmail();
        despachador.sendEmaiSOP();
        */
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sendEmailPU");
        EntityManager manager = factory.createEntityManager();
        
        //BUSQUEDA CON JPQL
        //Query query = manager.createQuery("SELECT c.descripcionEstado FROM Estado c");
        //List<String> lista = query.getResultList();
        //for(String codigo : lista){
        //    System.out.println(codigo);
        //}
        
        //BUSQUEDA CON FIND
        Short codi = 1;
        Estado estado = manager.find(Estado.class, codi);
        System.out.println(estado.getDescripcionEstado());
        
        codi = 3;
        //String query = "insert into Employee values(1,?)";

     
        estado.setCodigoEstado(codi);
        estado.setDescripcionEstado("desde java");
        EntityTransaction et = estado.getTransaction();
        et.begin();
        manager.createNativeQuery("insert into Estado ('codigoEstado', 'descripcionEstado') values(3, 'desde query java')").executeUpdate();
        et.commit();
        
        //String qry = "insert into Employee values(3,desde java)";
        //manager.createNativeQuery(qry).setParameter(3, "desde java").executeUpdate();
        
        /*try {
            //EmailSenderService despachador = new EmailSenderService();
            //despachador.sendEmail();
            
            // Paso 1 estableciendo las propiedades de conexión
            java.util.Properties mailServerProperties;
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
            mailServerProperties.put("mail.smtp.socketFactory.port", "465");
            mailServerProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.port", "465");
            
            javax.mail.Session getMailSession = Session.getDefaultInstance(
                    mailServerProperties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("alfredoalejandro05@gmail.com", "skatingislive");
                        }
                    }
            );
            
            javax.mail.internet.MimeMessage generateMailMessage;
            generateMailMessage = new MimeMessage(getMailSession);
            //Estableciendo el destino (TO)
            //generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("alfredoalejandro05@gmail.com"));
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("ushcau@gmail.com")); //kuscpclebdfilcxc
            
            //Estableciendo el destino de la copia (CC)
            generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("marco.m.andres96@gmail.com"));
            
            //Estableciendo el destino de la copia oculta (BCC)
            generateMailMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress("marcoandres96@outlook.com"));
            
            //Estableciendo el titulo del mensaje (subject)
            generateMailMessage.setSubject("titulo del mensaje a enviar");
            
            // Estableciendo el contenido del correo electronico enriquesido(HTML)
            String bodyEmail = "<h1>correo desde gmail</h1><p>Enviado de forma exitosa</p>";
            generateMailMessage.setContent(bodyEmail, "text/html");
            
            //Finalmente  enviamos el correo
            javax.mail.Transport.send(generateMailMessage);
        } catch (AddressException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void probarConexion(){
        
        
    }
    
}
