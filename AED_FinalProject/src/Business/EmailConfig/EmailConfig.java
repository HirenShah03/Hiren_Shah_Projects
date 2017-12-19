package Business.EmailConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jigar
 */
public class EmailConfig {
    
	private File configFile = new File("smtp.properties"); 
	private Properties configProps;
	
	public Properties loadProperties() throws IOException {
		Properties defaultProps = new Properties();
		// sets default properties
		defaultProps.setProperty("mail.smtp.host", "smtp.gmail.com");
		defaultProps.setProperty("mail.smtp.port", "587");
		defaultProps.setProperty("mail.user", "hirenultimate@gmail.com");
		defaultProps.setProperty("mail.password", "hirenshah");
		defaultProps.setProperty("mail.smtp.starttls.enable", "true");
		defaultProps.setProperty("mail.smtp.auth", "true");
		
		configProps = new Properties(defaultProps);
		
		// loads properties from file
		if (configFile.exists()) {
			InputStream inputStream = new FileInputStream(configFile);
			configProps.load(inputStream);
			inputStream.close();
		}
		
		return configProps;
	}
	
	public void saveProperties(String host, String port, String user, String pass) throws IOException {
		configProps.setProperty("mail.smtp.host", host);
		configProps.setProperty("mail.smtp.port", port);
		configProps.setProperty("mail.user", user);
		configProps.setProperty("mail.password", pass);
		configProps.setProperty("mail.smtp.starttls.enable", "true");
		configProps.setProperty("mail.smtp.auth", "true");
		
		OutputStream outputStream = new FileOutputStream(configFile);
		configProps.store(outputStream, "host setttings");
		outputStream.close();
	}	
        
        public static void sendEmail(Properties smtpProperties, String toAddress,
			String subject, String message)
			throws AddressException, MessagingException, IOException {

		final String userName = smtpProperties.getProperty("mail.user");
		final String password = smtpProperties.getProperty("mail.password");
		
		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(smtpProperties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
//		if (attachFiles != null && attachFiles.length > 0) {
//			for (File aFile : attachFiles) {
//				MimeBodyPart attachPart = new MimeBodyPart();
//
//				try {
//					attachPart.attachFile(aFile);
//				} catch (IOException ex) {
//					throw ex;
//				}
//
//				multipart.addBodyPart(attachPart);
//			}
//		}

		// sets the multi-part as e-mail's content
		msg.setContent(multipart);

		// sends the e-mail
		Transport.send(msg);

	}
}
