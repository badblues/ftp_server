package badblues.smtp;

import java.util.Properties;

import javax.mail.*;

public class SMTP {

	public static void main(String[] args) {
		final String fromEmail = "***@yandex.ru"; //requires valid gmail id
		final String password = args[0]; // correct password for gmail id
		final String toEmail = "***@gmail.com"; // can be any email id

		System.out.println("SSLEmail Start");
		Properties props = new Properties();


		//props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

		props.put("mail.smtp.host", "smtp.yandex.ru"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		//SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port

		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};


		MyMessage message = new MyMessage("TEST", "test message");
		MyMessage msgImage = new MyMessage("TEST IMAGE", "IMAGE", "/home/teenspirit/Documents/cat.png");
		MyMessage fileMessage = new MyMessage("TEST ATTACHMENT", "TEST", "/home/teenspirit/NSTU/ASVT/ded pey tabletki.odt");
		SMTP.printInfo(fromEmail,toEmail,message);
		//	EmailUtil.send(props,fromEmail,toEmail,message, auth);
		//EmailUtil.sendImageEmail(props,fromEmail,toEmail,msgImage, auth);
		EmailUtil.sendAttachmentEmail(props,fromEmail,toEmail,fileMessage, auth);

	}

	public  static void printInfo(String from, String to, MyMessage message) {
		System.out.println("\\---------------------------------------\\");
		System.out.println("\\\tMessage from: " + from);
		System.out.println("\\\tMessage to: " + to);
		System.out.println("\\\tSubject: " + message.subject);
		System.out.println("\\\tContent: " + message.content);
		System.out.println("\\----------------------------------------\\");
	}
}