package backend;

import dom2app.SimpleTableModel;

 
import dom.Tasks;
import dom.Filters;
import reporter.IReport;
import reporter.ReporterFactory;
import parser.ControllerFactory;
import parser.IController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainController implements IMainController {
	
	private List<String[]> table;
	private List<String[]> sortedtable;
	private List<String[]> table2;
	private List<String[]> top2;
	private List<String[]> pre;
	private List<String[]> idd;
	private String fileName;

	private String[] columns= {"TaskId" , "TaskText", "MamaId","Start" , "End" , "Cost"};
	
	public MainController() {
		 table = new ArrayList<String[]>(); 
		 sortedtable = new ArrayList<String[]>();  
		 table2 = new ArrayList<String[]>(); 
		 top2 = new ArrayList<String[]>();  
		 pre = new ArrayList<String[]>();  
	     idd = new ArrayList<String[]>();  
	
	}


	public MainController(String Path) throws NullPointerException{
		if(Objects.isNull(Path)) {
			throw new NullPointerException();
		}
		 this.fileName=Path;
		 table = new ArrayList<String[]>();  
		 sortedtable = new ArrayList<String[]>(); 
		 table2 = new ArrayList<String[]>();  
		 top2 = new ArrayList<String[]>();  
		 pre = new ArrayList<String[]>(); 
	     idd = new ArrayList<String[]>();  
		
	}

	public SimpleTableModel load(String fileName, String delimiter) {  //path, nameOfFile
		 ControllerFactory controlFactory = new ControllerFactory();
		 IController parse = controlFactory.readData("Controller",fileName);
		 this.fileName=fileName;
		 SimpleTableModel st  = new SimpleTableModel("Full Prj: "+fileName, fileName, columns, sortedtable);
		 Tasks tasks = new Tasks(sortedtable,table2);
	     tasks.sortTasks(parse.readTasks(table));
		 
         return st;    
 
		
	}
	
	
	public SimpleTableModel getTasksByPrefix(String prefix) { 
		 pre.clear();
   		 SimpleTableModel st  = new SimpleTableModel("Prefix search "+prefix,fileName , columns, pre);
		 Filters prefi = new Filters(top2,pre,idd);
		 prefi.getPrefix(sortedtable,prefix);
		 return st;								
		
	}
	public SimpleTableModel getTaskById(int id) {  
		idd.clear();
		SimpleTableModel st  = new SimpleTableModel("Id search for "+String.valueOf(id),fileName, columns, idd);
		Filters i = new Filters(top2,pre,idd);
		i.getId(sortedtable,id);
		return st; 											
		
	}
	public SimpleTableModel getTopLevelTasks() {
		 top2.clear();
		 SimpleTableModel st  = new SimpleTableModel("Top Tasks ",fileName , columns, top2);
		 Filters toplevel = new Filters(top2,pre,idd);
		 toplevel.getTop(sortedtable);
		 return st; 
	}
	public int createReport(String path, ReportType type) {
				ReporterFactory reporterFactory = new ReporterFactory();
				IReport reporter = reporterFactory.getReport(sortedtable,path,type);
				reporter.create(sortedtable,columns,path,type);
				reporter.create(sortedtable,columns,path,type);
				reporter.create(sortedtable,columns,path,type);
				return 0;
	}
	
	
	
}
