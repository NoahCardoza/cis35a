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
	
	public void log(int level, Object out) {
		if (LEVEL >= level)
			System.out.println(out);
	}
	
	public void info(Object out) {
		log(INFO, "INFO: " + out.toString());
	}
	
	public void setLevel(int level) {
		LEVEL = level;
	}
	
	public int getLevel() {
		return LEVEL;
	}
}
