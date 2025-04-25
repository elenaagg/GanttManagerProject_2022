import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.MainController;
import dom2app.SimpleTableModel;

public class PrefixTester {
	
	private SimpleTableModel PrefixData;
	private SimpleTableModel PrefixData1;
	private SimpleTableModel PrefixData2;

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
	public final void test1getTasksByPrefixHappyDay() {
		PrefixData = mainc.getTasksByPrefix("Put");
		String equal="Prefix search Put	for	./src/main/resources/input/EggsScrambled.tsv\n"+
	        	   "TaskId	TaskText	MamaId	Start	End	Cost\t\n"+
	               "301	Put bread in plate	300	13	13	10\t\n"+
	               "302	Put eggs on bread	300	14	14	10\t\n";
	       assertEquals("if file shows tasksbyprefix Put ",equal,PrefixData.toString());
	} 
	
	@Test
	public final void test2getTasksByPrefixHappyDay() {
		PrefixData1 = mainc.getTasksByPrefix("P");
		String equal="Prefix search P	for	./src/main/resources/input/EggsScrambled.tsv\n"+
	        	   "TaskId	TaskText	MamaId	Start	End	Cost\t\n"+
	               "100	Prepare Fry	0	1	12	60.0\t\n"+
	               "200	Prepare the bread	0	10	12	20.0\t\n"+
	               "301	Put bread in plate	300	13	13	10\t\n"+
	               "302	Put eggs on bread	300	14	14	10\t\n";
	       assertEquals("if file shows tasksbyprefix P ",equal,PrefixData1.toString());
	}
	@Test
	public final void test3getTasksByPrefixHappyDay() {
		PrefixData2 = mainc.getTasksByPrefix("H");
		String equal="Prefix search H	for	./src/main/resources/input/EggsScrambled.tsv\n"+
	        	   "TaskId	TaskText	MamaId	Start	End	Cost\t\n"+
	               "201	Heat bread in toaster	200	10	12	10\t\n";
	       assertEquals("if file shows tasksbyprefix H ",equal,PrefixData2.toString());
	}
	

}
