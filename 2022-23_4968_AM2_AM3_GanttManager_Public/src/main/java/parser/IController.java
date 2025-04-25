package parser;

import java.util.List;

public interface IController {
	/**
	 * 
	 * 
	 */
	public abstract List<String[]> readTasks(List<String[]> table);
	/**
	 * Reads the file 
	 * 
	 * @param table: list that will include the file lines
	 * @return the tasks of the file as a list
	 */
}
