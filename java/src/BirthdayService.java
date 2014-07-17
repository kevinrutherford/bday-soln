
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BirthdayService {

	private Emailer messageSender;
	private EmployeeFile personnel;

	public BirthdayService(Emailer messageSender, EmployeeFile personnel) {
		this.messageSender = messageSender;
		this.personnel = personnel;
	}

	public void sendGreetings(OurDate ourDate) {
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(personnel.fileName));
			String str = "";
			str = in.readLine(); // skip header
			while ((str = in.readLine()) != null) {
				String[] employeeData = str.split(", ");
				Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
				greet(ourDate, employee);
			}
		} catch (IOException e) {
			throw new PersonnelException(e);
		}
	}

	private void greet(OurDate ourDate, Employee employee) {
		String recipient = employee.getEmail();
		if (employee.isBirthday(ourDate)) {
			String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
			String subject = "Happy Birthday!";
			messageSender.sendMessage("sender@here.com", subject, body, recipient);
		}
	}

	public static void main(String[] args) {
		Emailer emailer = new Emailer("localhost", 25);
		EmployeeFile employeeFile = new EmployeeFile("employee_data.txt");
		BirthdayService service = new BirthdayService(emailer, employeeFile);
		try {
			service.sendGreetings(new OurDate("2008/10/08"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
