package reporter;

import java.util.List;

import backend.ReportType;


/**
* <h1>ReporterFactory</h1>
* Factory class responsible for creating the different types of 
* reporting objects.
*
* @version 1.0
* @since   2017-07-22
*/
public final class ReporterFactory {
	
	/**
 	 * Creates different types of reporting objects
 	 * 
 	 *  @param sortedtable: list of the tasks
 	 *  @param path The path for the filename that will be produced
	 *  @param type a ReportType (@see backend.ReportType) with the types of reports that can be produced.
 	 *  @return an object responsible for generating a report
 	 * 
 	 */
	public IReport getReport(List<String[]> sortedtable,String path, ReportType type){
		if (type.equals(ReportType.HTML)){
			return new ReportForHTML(sortedtable,path,type);
		}
		else if(type.equals(ReportType.MD)){
			return new ReportForMD(sortedtable,path,type);
		}
		else if(type.equals(ReportType.TEXT)) {
			return new ReportForTXT(sortedtable,path,type);
		}
		System.out.println("If the code got up to here, you passed a wrong argument to the ReporterFactory Factory");
		return null;
	}
}