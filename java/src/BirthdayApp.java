
public class BirthdayApp {
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