package reporter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Objects;

import backend.ReportType;


final class ReportForHTML implements IReport {
	     


		public ReportForHTML(List<String[]> sortedtable, String path, ReportType type) {
		// TODO Auto-generated constructor stub
	}


		// }
		/**
	 	 * Creates and saves the data in HTML format
	 	 * 
	 	 */
		private void rasterToHTML(String fileName, String[][] raster, int numRows, int numCols) {
			String header = new String("");
			header.concat("<!doctype html>");
			header.concat("\n");
			header.concat("<html>");
			header.concat("\n");
			header.concat("<head>");
			header.concat("\n");
			header.concat("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
			header.concat("\n");
			//header.concat(title);
			header.concat("\n");
			header.concat("</head>");
			header.concat("\n");
			header.concat("<body>");
			header.concat("\n");
			// Opening file to write, checking exception
			try {
				PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName)); 
				outputStream.println(header);

				outputStream.println("<table>");

				for(int i =0; i < numRows; i++){
					outputStream.println("<tr>");
					for(int j =0; j < numCols; j++){
						outputStream.print("<td>"+raster[i][j]+"</td>");
					}
					outputStream.println("\n</tr>");
				}
				outputStream.println("</table>");
				outputStream.println("</body>\n</html>");
				outputStream.close();
			} catch (FileNotFoundException e) {
				System.err.println("Problem opening file " + fileName);
				System.exit(0);
			}
			return;
		}// end visualize
		
		
		/**
	 	 * Saves the statistics for the employees
	 	 * 
	 	 * @param personnel: list of employees
	 	 * @return 0 if all goes well, a negative number if sth goes wrong
	 	 */
		@Override
		public void create(List<String[]> sortedtable, String [] columns,String path ,ReportType type)  {
			if(Objects.isNull(sortedtable)) {
				System.err.println("ReportGeneratorForHTML: null object in report for Emps");
				System.exit(0);			
			}
			DecimalFormat df = new DecimalFormat("###.##");
			DecimalFormatSymbols dfs=new DecimalFormatSymbols();			
			dfs.setDecimalSeparator('.');	
			df.setDecimalFormatSymbols(dfs);		
		
			int numCols = 6;
			int numRows = sortedtable.size() + 1;
					
			String [][]raster = new String[numRows][numCols];
			raster[0][0] = "TaskId"; raster[0] [1] = "TaskText"; raster[0][2] = "MamaId"; raster[0][3] = "Start";raster[0][4] = "End"; raster[0][5] = "Cost";
			int i = 1;
			for(String[] s: sortedtable){
				raster[i][0] = s[0];
				raster[i][1] =s[1]; 
				raster[i][2] = s[2]; 
				raster[i][3] = s[3];
				raster[i][4] = s[4];
				raster[i][5] = s[5];
				i++;			
			}
			rasterToHTML(path, raster, numRows, numCols);
			
		}
		
}
