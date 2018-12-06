package util;
import java.io.File;
import java.util.Scanner;

import adapter.StudentFileIOAPI;

public class UI {
	private static Scanner stdin;
	
	private static void initStdin() {
		if (stdin == null) 
			stdin = new Scanner(System.in);
	}
	
	// General Methods
	
	private static File askForPath(String message) {
		initStdin();
		
		System.out.print(message);
		return new File(stdin.nextLine());		
	}
	
	public static String askForFile() {		
		File file = askForPath("Where is your file located: ");
		if (file.isFile()) return file.getPath();
		System.out.println("That file dose not exist.");
		return UI.askForFile();
	}
	
	public static String askForDirectory() {		
		File file = askForPath("Where is your directory located: ");
		if (file.isDirectory()) return file.getPath();
		System.out.println("That directory dose not exist.");
		return UI.askForDirectory();
	}
	
	public static void cleanup() {
		if (stdin != null) stdin.close();
	}
	
	public static void divider() {
		System.out.println("\n------------------------------------------\n");
	}
	
	// Program Specific
	
	public static void studentLookup(String cwd, StudentFileIOAPI API) {
		int sid;
		System.out.println("Student Lookup");
		System.out.println("Enter a student ID to view their score's.");
		System.out.println("Leave the input blank to exit.");
		while ((sid = UI.askForStudentId(cwd)) != -1) {
			API.printScoresForStudent(sid);
		}
	}
	
	public static String askForStudentBinaryLocation() {		
		System.out.println("Where can the student binaries be found?");
		return UI.askForDirectory();
	}
	
	public static int askForStudentId(String directory) {
		String sid;
		File file = new File(directory);
		
		initStdin();
		System.out.print("Select a student by ID: ");
		sid = stdin.nextLine();
		if (sid.length() == 0) return -1;
		File filesFound[] = file.listFiles(helpers.FilenameFilterWrapper.filenameEquals("student." + sid + ".ser"));
		if (filesFound.length > 0) return Integer.parseInt(sid);
		System.out.println("A student with this ID could not be located");
		return askForStudentId(directory);
	}
}
