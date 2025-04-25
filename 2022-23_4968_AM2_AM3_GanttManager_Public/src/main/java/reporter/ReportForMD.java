package reporter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import backend.ReportType;

final class ReportForMD implements IReport {

	public ReportForMD(List<String[]> sortedtable, String path, ReportType type) {
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void create(List<String[]> sortedtable, String [] columns,String path ,ReportType type)  {
		try {
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(path)); 
				outputStream.println("*"+ columns[0] + "*  \t"+ "*"+columns[1]+"*   \t" + "*"+ columns[2] + "* \t"+ "*"+columns[3] + "*  \t"  +"*"+columns[4] + "* \t"+ "*"+columns[5]+"* ");
			for(String[] s: sortedtable){
				if(Integer.parseInt(s[2])==0){
					for	 (int i = 0; i <= s.length-1; i++) {
						outputStream.print("**"+s[i]+"**"+" ");
					}
					outputStream.println(" ");

				
				}else {
					for	 (int i = 0; i <= s.length-1; i++) {
						outputStream.print(s[i] + "\t");
					}
					outputStream.println(" ");

				}
			}
					
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.err.println("Problem opening file ");
			System.exit(0);
		}
		return;

	}
}