package org.javaeerecipes.chapter01.recipe01_07;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupShutdownListener implements ServletContextListener {

    private static int SMTP_PORT = 587;
	
	public StartupShutdownListener() {
        // TODO Auto-generated constructor stub
    }

    private boolean sendMail(String message) throws MessagingException {
    	boolean result = false;

    	String smtpHost = "smtp.gmail.com";
    	String username = "leonardobarauna@gmail.com";
    	String password = "leonarddo";
    	String from = "leonardobarauna@gmail.com";
    	String to = "leonardobarauna@hotmail.com";
    	int port = SMTP_PORT;
    	
    	Properties props = new Properties();
    	props.put("mail.smtp.host", smtpHost);
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls", "true");
    	
    	Session session = Session.getInstance(props);
    	
    	Message msg = new MimeMessage(session);
    	
    	InternetAddress addressFrom = new InternetAddress(from);
    	msg.setFrom(addressFrom);
    	
    	InternetAddress[] address = new InternetAddress[1];
    	address[0] = new InternetAddress(to);
    	msg.setRecipients(Message.RecipientType.TO, address);
    	msg.setSubject("Servlet Container listening");
    	msg.setContent(message, "text/plain");
    	
    	Transport transport = session.getTransport("smtp");
    	transport.connect(smtpHost, port, username, password);
    	
    	Transport.send(msg);
    	
    	result = true;
    	return result;
    	
    }
    
    public void contextInitialized(ServletContextEvent arg0) {
        try {
			sendMail("Servlet startup...");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }


	public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("Servlet shutdown...");
    }
	
}
