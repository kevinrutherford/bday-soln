import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Emailer {
	private String smtpHost;
	private int smtpPort;

	public Emailer(String smtpHost, int smtpPort) {
		this.smtpHost = smtpHost;
		this.smtpPort = smtpPort;
	}

	public void sendMessage(String sender, String subject, String body, String recipient) {
		Session session = createSession();
		Message msg = constructMessage(sender, subject, body, recipient, session);
		sendMessage(msg);
	}

	private Message constructMessage(String sender, String subject,
			String body, String recipient, Session session) {
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(sender));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			msg.setSubject(subject);
			msg.setText(body);
		} catch (MessagingException e) {
			throw new MessageSenderException(e);
		}
		return msg;
	}

	private Session createSession() {
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", "" + smtpPort);
		Session session = Session.getDefaultInstance(props, null);
		return session;
	}

	// made protected for testing :-(
	protected void sendMessage(Message msg) {
		try {
			Transport.send(msg);
		} catch (MessagingException e) {
			throw new MessageSenderException(e);
		}
	}
}