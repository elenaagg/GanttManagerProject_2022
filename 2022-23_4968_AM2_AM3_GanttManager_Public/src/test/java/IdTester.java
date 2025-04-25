import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.MainController;
import dom2app.SimpleTableModel;

public class IdTester {

	private SimpleTableModel IdData;

	public static MainController mainc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mainc = new MainController();
		mainc.load("./src/main/resources/input/EggsScrambled.tsv","\t");

	}

	@Test
	public final void test1getTaskByIdHappyDay() {
		IdData = mainc.getTaskById(200);
		String equal="Id search for 200	for	./src/main/resources/input/EggsScrambled.tsv\n"+
	        	   "TaskId	TaskText	MamaId	Start	End	Cost\t\n"+
	               "200	Prepare the bread	0	10	12	20.0\t\n";
	       assertEquals("test if file shows tasksbyid 200 ",equal,IdData.toString());
	}
	
	@Test
	public final void test2getTasksByIdHappyDay() {
		IdData = mainc.getTaskById(102);
		String equal="Id search for 102	for	./src/main/resources/input/EggsScrambled.tsv\n"+
	        	   "TaskId	TaskText	MamaId	Start	End	Cost\t\n"+
	               "102	Break eggs and pour into fry	100	2	4	10\t\n";
	       assertEquals("test if file shows tasksbyid 102 ",equal,IdData.toString());
	}
		
	@Test
	public final void test3getTasksByPrefixHappyDay() {
		IdData = mainc.getTaskById(301);
		String equal="Id search for 301	for	./src/main/resources/input/EggsScrambled.tsv\n"+
	        	   "TaskId	TaskText	MamaId	Start	End	Cost\t\n"+
	               "301	Put bread in plate	300	13	13	10\t\n";
	       assertEquals("test if file shows tasksbyid 301 ",equal,IdData.toString());
	}


}
