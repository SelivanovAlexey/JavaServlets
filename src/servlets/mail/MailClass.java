package servlets.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

public class MailClass {

    private String login;
    private String password;
    private String email;
    private String subject;
    private String cc;
    private String text;

    public void getParameters(HttpServletRequest req){
        login = req.getParameter("login");
        password = req.getParameter("password");

        email = req.getParameter("email");
        subject = req.getParameter("subject");
        cc = req.getParameter("cc");
        text = req.getParameter("text");
    }

    public void sendEmail(HttpServletResponse response) throws IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(login,password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(login));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(subject);
            message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(cc));
            message.setText(text);
            Transport.send(message);

            System.out.println("Done");

            response.getWriter().println("<script type='text/javascript'>alert('E-mail sent successfully');location='/message.html'</script>");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
