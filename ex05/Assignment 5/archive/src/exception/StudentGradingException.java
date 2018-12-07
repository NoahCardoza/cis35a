package exception;

import log.Logger;
import util.UI;

@SuppressWarnings("serial")
public class StudentGradingException extends Exception {
	static Logger logger;
	int errno = -1;
	String message = "";
	
	/*
	 * ERRNO TABLE
	 * 
	 * 0    Unknown Error
	 * 1    FileNotFound
	 * 2    IOException
	 * 3    GradesNotLoaded
	 * 100  FormatException
	 */
	
	public static void setLogger(Logger loggerInstance) {
		logger = loggerInstance;
	}
	
	public StudentGradingException(int errno, String message){
		super();
		this.errno = errno;
		this.message = message;
//		print();
		log();
	}
	
	public String toString() {
		return String.format("StudentGradingException[ errno=%d, message=\"%s\" ]", errno, message);
	}
	
	public void log() {
		if (logger == null) logger = Logger.getLogger();
		logger.warn(toString());
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	public static void fileNotFound(String filename) {
		new StudentGradingException(1, String.format("\"%s\" does not exists.", filename));
	}
	
	public static void IOException(Object e) {
		new StudentGradingException(2, e.toString());
	}

	public static void GradesNotLoaded(String path) {
		new StudentGradingException(3, String.format("Could not find any student.ser files in \"%s\"", path));
		System.out.println("This directory does not contain any student data.");
		System.out.println("Exiting...");
		System.exit(0);
	}
	
	public String fixFormatException() {
		System.out.println("The file read appears to be corrupt. Specify another path to continue.");
		return UI.askForFile();
	}
}
