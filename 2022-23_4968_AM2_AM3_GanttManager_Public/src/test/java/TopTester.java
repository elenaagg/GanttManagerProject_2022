import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.MainController;
import dom2app.SimpleTableModel;

public class TopTester {
	
	private SimpleTableModel TopData;
	public static MainController mainc;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mainc = new MainController();
		assertNotNull(mainc.load("./src/main/resources/input/EggsScrambled.tsv","\t"));
		TopData= mainc.getTopLevelTasks();

	}
	@Test
	public final void testgetTopLevelTasksHappyDay() {
		String equal="Top Tasks 	for	./src/main/resources/input/EggsScrambled.tsv\n"
	        	   +"TaskId	TaskText	MamaId	Start	End	Cost\t\n"+
	               "100	Prepare Fry	0	1	12	60.0\t\n"+
	               "200	Prepare the bread	0	10	12	20.0\t\n"+
	               "300	Serve eggs	0	13	20	30.0\t\n";

	       assertEquals("test if file outputs the top level tasks ",equal,TopData.toString());
	       assertNotNull(TopData.toString());
	}	

}
