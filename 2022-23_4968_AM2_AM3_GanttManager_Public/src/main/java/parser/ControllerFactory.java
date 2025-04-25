package parser;

import java.util.Objects;


public final class ControllerFactory {
	/**
 	 * Creates a Controller object
 	 * 
 	 * 
	**/
	public IController readData(String className, String Path){
		if (Objects.isNull(Path) || Path.length() == 0) {
			System.err.println("ReadData: invalid path for file");
			return null;
		}
		
		
		if(className.equals("Controller"))
			return new Controller(Path,"\t");
		
		System.err.println("ReadData: you passed a wrong className argument to the ReadData Factory");
		return null;
	}

}
