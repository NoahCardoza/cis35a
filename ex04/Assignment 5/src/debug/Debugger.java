package debug;

// A very simple and incomplete Debugging class to practice the use of packages  
public class Debugger {
	private int LEVEL;
	
	public static int OFF = 0;
	public static int WARN = 300;
	public static int INFO = 400;
	public static int DEBUG = 600;
	public static int ALL = Integer.MAX_VALUE;
	
	public Debugger(int level){
		LEVEL = level;
	}
	
	public void log(int level, String message) {
		if (LEVEL >= level)
			System.out.println(message);
	}
	
	public void info(String message) {
		log(INFO, "INFO: " + message);
	}
	
	public void setLevel(int level) {
		LEVEL = level;
	}
	
	public int getLevel() {
		return LEVEL;
	}
}
