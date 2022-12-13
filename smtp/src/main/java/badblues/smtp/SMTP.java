package badblues.smtp;

import java.util.Properties;

import javax.mail.*;

public class SMTP {
	
	public static void main(String[] args) {
		
	    System.out.println("SimpleEmail Start");
		
	    String smtpHostServer = "smtp.yandex.ru";
	    String emailID = "vshabunin25@yandex.ru";
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);

	    Session session = Session.getInstance(props, null);
	    
	    EmailUtil.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}

}