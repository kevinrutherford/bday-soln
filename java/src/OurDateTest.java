import static org.junit.Assert.*;

import org.junit.Test;

public class OurDateTest {
	@Test
	public void isSameDate() throws Exception {
		OurDate ourDate = new OurDate("1789/01/24");
		OurDate sameDay = new OurDate("2001/01/24");
		OurDate notSameDay = new OurDate("1789/01/25");
		OurDate notSameMonth = new OurDate("1789/02/25");
		
		assertTrue("same", ourDate.isSameDay(sameDay));
		assertFalse("not same day", ourDate.isSameDay(notSameDay));
		assertFalse("not same month", ourDate.isSameDay(notSameMonth));
	}
}
