
public class BirthdayService {

	private Emailer messageSender;
	private EmployeeFile personnel;

	public BirthdayService(Emailer messageSender, EmployeeFile personnel) {
		this.messageSender = messageSender;
		this.personnel = personnel;
	}

	public void sendGreetings(OurDate ourDate) {
		EmployeeAction sendGreetings = new Greeter(messageSender, ourDate);
		personnel.eachEmployee(sendGreetings);
	}
}
