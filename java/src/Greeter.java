
public class Greeter {

	private Emailer messageSender;

	public Greeter(Emailer messageSender, OurDate ourDate) {
		this.messageSender = messageSender;
	}

	public void greet(OurDate ourDate, Employee employee) {
		String recipient = employee.getEmail();
		if (employee.isBirthday(ourDate)) {
			String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
			String subject = "Happy Birthday!";
			messageSender.sendMessage("sender@here.com", subject, body, recipient);
		}
	}

}
