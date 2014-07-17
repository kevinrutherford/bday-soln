import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TestDataFile {
	
	public void create(String path) throws FileNotFoundException, UnsupportedEncodingException {
		File f = new File(path);
		if (f.canRead()) return;
		PrintWriter writer = new PrintWriter(f, "UTF-8");
		writer.println("last_name, first_name, date_of_birth, email, anniversary");
		writer.println("Doe, John, 1982/10/08, john.doe@foobar.com, 2009/07/01");
		writer.println("Ann, Mary, 1975/03/11, mary.ann@foobar.com, 2009/08/01");
		writer.close();
	}

}
