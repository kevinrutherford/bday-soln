
public class Employee {

	private OurDate birthDate;
	private String lastName;
	private String firstName;
	private String email;

	public Employee(String firstName, String lastName, String birthDate, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = new OurDate(birthDate);
		this.email = email;
	}

	public boolean isBirthday(OurDate today) {
		return today.isSameDay(birthDate);
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}
}
