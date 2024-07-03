package ar.edu.utn.frba.dds;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EmailSenderAdapter implements InstantMessageSender {
  @Override
  public void sendMessage(InstantMessageApp provider, String email, String message) {
    if (provider == InstantMessageApp.EMAIL) {
      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com"); // Cambiar por el servidor SMTP adecuado
      props.put("mail.smtp.port", "587"); // Puerto SMTP adecuado
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");

      Session session = Session.getInstance(props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication("paolitalf2021@gmail.com", "ieno ssti stwe eaty");
          // Cambiar por el correo y contraseña válidos
        }
      });

      try {
        Message emailMessage = new MimeMessage(session);
        emailMessage.setFrom(new InternetAddress("your-email@example.com")); // Cambiar por el correo válido
        emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        emailMessage.setSubject("Subject: Alerta de Viandas");
        emailMessage.setText(message);

        Transport.send(emailMessage);

        System.out.println("Correo enviado a " + email + ": " + message);
      } catch (MessagingException e) {
        e.printStackTrace();
      }
    } else {
      throw new IllegalArgumentException("Provider no válido para Email");
    }
  }
}