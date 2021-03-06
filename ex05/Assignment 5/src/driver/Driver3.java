package driver;

import adapter.StudentApiOutline;
import adapter.StudentFileIOAPI;
import util.UI;

public class Driver3 {
	public static void main(String[] args) {
		String cwd;
		
		cwd = UI.askForStudentBinaryLocation();
		StudentApiOutline API = new StudentFileIOAPI(cwd);
		UI.divider();
		API.printClassStatistics();
		UI.divider();
		UI.studentLookup(cwd, API);
		UI.divider();
		System.out.println("Have a good day!");
	}
}
