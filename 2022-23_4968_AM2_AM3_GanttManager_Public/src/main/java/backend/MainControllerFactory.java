package backend;

public class MainControllerFactory {
	/**
 	 * Creates a MainController object
 	 * 
 	 * 
	**/
	public IMainController createMainController() {
		return new MainController();
	}

}
