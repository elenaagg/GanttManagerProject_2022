package reporter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.util.List;

import backend.ReportType;

final class ReportForTXT implements IReport {

	

	public ReportForTXT(List<String[]> sortedtable, String path, ReportType type) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(List<String[]> sortedtable, String [] columns,String path ,ReportType type)  {
				try {
					PrintWriter outputStream = new PrintWriter(new FileOutputStream(path)); 
					outputStream.println("TaskId\tTaskText\tMamaId\tStart\tEnd\tCost \n");
					for(String[] s: sortedtable){
						for	 (int i = 0; i <= s.length-1; i++) {
					          outputStream.print(s[i] + " ");
					    }
						outputStream.println(" ");

					}
					outputStream.close();
				} catch (FileNotFoundException e) {
					System.err.println("Problem opening file ");
					System.exit(0);
				}
				return;
	}

}
