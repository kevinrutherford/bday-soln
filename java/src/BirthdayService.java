
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BirthdayService {

	public void sendGreetings(String fileName, OurDate ourDate, Emailer messageSender) {
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(fileName));
			String str = "";
			str = in.readLine(); // skip header
			while ((str = in.readLine()) != null) {
				String[] employeeData = str.split(", ");
				Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
				String recipient = employee.getEmail();
				if (employee.isBirthday(ourDate)) {
					String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
					String subject = "Happy Birthday!";
					messageSender.sendMessage("sender@here.com", subject, body, recipient);
				}
			}
		} catch (IOException e) {
			throw new PersonnelException(e);
		}
	}

	public static void main(String[] args) {
		BirthdayService service = new BirthdayService();
		try {
			service.sendGreetings("employee_data.txt", new OurDate("2008/10/08"), new Emailer("localhost", 25));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
