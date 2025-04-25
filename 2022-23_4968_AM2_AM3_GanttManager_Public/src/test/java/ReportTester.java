import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import backend.MainController;
import backend.ReportType;

public class ReportTester {
	
	
		public static MainController mainc;


		@Before
		public void setUp() throws Exception {
				mainc = new MainController();
				mainc.load("./src/main/resources/input/EggsScrambled.tsv","\t");
				mainc.createReport("./src/main/resources/output/Eggs.html", ReportType.HTML);
				mainc.createReport("./src/main/resources/output/Eggs.md", ReportType.MD);
				mainc.createReport("./src/main/resources/output/shop.txt", ReportType.TEXT);
			
		}


	@Test
	public final void testEmployeeRecordsHappyDay() {
	    File ht = new File("./src/main/resources/output/Eggs.html");
	    File m = new File("./src/main/resources/output/Eggs.md");
	    File tx = new File("./src/main/resources/output/shop.txt");

		try {
			assertNotNull(ht.getCanonicalPath());
			assertNotNull(m.getCanonicalPath());
			assertNotNull(tx.getCanonicalPath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
