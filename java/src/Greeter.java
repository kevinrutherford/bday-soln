
public class Greeter implements EmployeeAction {

	private Emailer messageSender;
	private OurDate ourDate;

	public Greeter(Emailer messageSender, OurDate ourDate) {
		this.messageSender = messageSender;
		this.ourDate = ourDate;
	}

	@Override
	public void visit(Employee employee) {
		String recipient = employee.getEmail();
		if (employee.isBirthday(ourDate)) {
			String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
			String subject = "Happy Birthday!";
			messageSender.sendMessage("sender@here.com", subject, body, recipient);
		}
	}

}
