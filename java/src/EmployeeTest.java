import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testBirthday() throws Exception {
		Employee employee = new Employee("foo", "bar", "1990/01/31", "a@b.c");
		assertFalse("not his birthday", employee.isBirthday(new OurDate("2008/01/30")));
		assertTrue("his birthday", employee.isBirthday(new OurDate("2008/01/31")));
	}
}
