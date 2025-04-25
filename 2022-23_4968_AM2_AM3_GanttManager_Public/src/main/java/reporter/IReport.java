package reporter;
import java.util.List;

import backend.ReportType;

/**
* <h1>IReportGenerator</h1>
* Interface which provides a contract to the clients
* regarding reports for tasks
*
* @version 1.0
* @since   2017-07-22
*/
public interface IReport {
	/**
	 * 
	 * 
	 */
	public void create(List<String[]> sortedtable, String [] columns,String path ,ReportType type) ;

	/**
	 * Makes the reports for the tasks
	 * 
	 * @param sortedtable: list of the sorted tasks
	 * @param columns:{"TaskId" , "TaskText", "MamaId","Start" , "End" , "Cost" }
	 * @param path The path for the filename that will be produced
	 * @param type a ReportType (@see backend.ReportType) with the types of reports that can be produced.
	 * @return 0 if all goes well, a negative number if sth goes wrong
	 */

}