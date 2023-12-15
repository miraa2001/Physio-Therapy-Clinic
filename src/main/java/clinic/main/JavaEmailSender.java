package clinic.main;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class JavaEmailSender {
	private static String myAccountEmail;
	private static String myP;
    public static void sendMail(String recipient,String number) throws MessagingException {
     
     //Create email sending properties
     Properties properties = new Properties();

     myAccountEmail="physiotherapyclinic2022@gmail.com";
     myP="lopswwsdrrwenvsy";
     properties.put("mail.smtp.auth", "true");
     properties.put("mail.smtp.starttls.enable", "true");
     properties.put("mail.smtp.host", "smtp.gmail.com");
     properties.put("mail.smtp.port", "587");
     
     
     Session session=Session.getInstance(properties,new Authenticator(){
         @Override
         protected PasswordAuthentication getPasswordAuthentication(){
             return new PasswordAuthentication(myAccountEmail,myP);
         }
     });
     
     Message message= prepareMessage(session,myAccountEmail,recipient,number);
     Transport.send(message);
    } 
     
    private static Message prepareMessage(Session session,String myAccountEmail,String recipient,String number){
        Message message = null;
        try{
        message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
        message.setSubject("Physio Clinic - Bill");
        message.setText(number);
        message.saveChanges();
        }
        catch(Exception ex)
        {
        }
        return message;
    } 
}
