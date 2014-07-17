import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class EmployeeFile {
	public String fileName;

	public EmployeeFile(String fileName) {
		this.fileName = fileName;
	}

	void eachEmployee(EmployeeAction sendGreetings) {
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(fileName));
			String str = "";
			str = in.readLine(); // skip header
			while ((str = in.readLine()) != null) {
				String[] employeeData = str.split(", ");
				Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
				sendGreetings.visit(employee);
			}
		} catch (IOException e) {
			throw new PersonnelException(e);
		}
	}
}