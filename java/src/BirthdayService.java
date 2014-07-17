
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
		Greeter sendGreetings = new Greeter(messageSender, ourDate);
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(personnel.fileName));
			String str = "";
			str = in.readLine(); // skip header
			while ((str = in.readLine()) != null) {
				String[] employeeData = str.split(", ");
				Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
				sendGreetings.greet(ourDate, employee);
			}
		} catch (IOException e) {
			throw new PersonnelException(e);
		}
	}
}
