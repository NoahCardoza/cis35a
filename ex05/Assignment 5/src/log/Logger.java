package log;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import exception.StudentGradingException;

// A very simple and incomplete Debugging class to practice the use of packages  
public class Logger {	
	private static Logger logger = null;

	public static int OFF = 0;
	public static int WARN = 300;
	public static int INFO = 400;
	public static int DEBUG = 600;
	public static int ALL = Integer.MAX_VALUE;
	
	private int LEVEL = ALL;
	private PrintStream stream;
	
	public Logger(){
		stream = System.out;
		if (logger == null)
			logger = this;
	}
	
	public Logger(int level){
		this();
		LEVEL = level;
	}
	
	public Logger(int level, PrintStream output){
		this(level);
		this.stream = output;
	}
	
	public Logger(int level, String filename) {
		this(level);
		try {
			this.stream = new PrintStream(filename);
		} catch (FileNotFoundException e) {
			StudentGradingException.fileNotFound(filename);
		}
		
	}
	
	public void log(int level, Object out) {
		if (LEVEL >= level)
			stream.println(out);
	}
	
	public void debug(Object out) {
		log(INFO, "DEBUG: " + out.toString());
	}
	
	public void info(Object out) {
		log(INFO, "INFO: " + out.toString());
	}
	
	public void warn(Object out) {
		log(WARN, "WARN: " + out.toString());
	}
	
	public void setLevel(int level) {
		LEVEL = level;
	}
	
	public int getLevel() {
		return LEVEL;
	}
	
	public static Logger getLogger() {
		if (logger == null) return new Logger(); 
		return logger;
	}
}
