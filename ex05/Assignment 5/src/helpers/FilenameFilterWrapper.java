package helpers;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterWrapper {
	public static FilenameFilter filenameEquals(String filename) {
		// forgive me for this abomination
		return new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.equals(filename);
		    }
		};
	}
	
	public static FilenameFilter filenameWrappedBy(String start, String end) {
		// forgive me for this abomination
		return new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.startsWith(start) && name.endsWith(end);
		    }
		};
	}
}
