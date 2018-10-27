import java.io.*;
import java.util.*;

// this class parses store data from a file and
// returns a Franchise object.
public class FileIO {
	// stores the file name
	private String fname = null;
	// set to true for verbose step by step output to console and vice versa
	private boolean DEBUG = false;

	public FileIO(String fname) {
		this.fname = fname;
	}
	
	// populates the Franchise object with n stores and 7 days worth of sales for 5 weeks
	public Franchise readData() {
		// this will hold the Franchise object which is returned at the end of the function
		Franchise a1 = null;
		// keeps track of line numbers and run specific operations on different lines
		int counter = 0;
		// 
		try {
			// stream
			FileReader file = new FileReader(fname);
			BufferedReader buff = new BufferedReader(file);
			// stores lines of the file as the function reads
			String temp;
			// true when the end of the file is reached
			boolean eof = false;
			while (!eof) {
				// grabs the first line
				String line = buff.readLine();
				counter++;
				// terminates the loop at the end of the file
				if (line == null)
					eof = true;
				else {
					if (DEBUG) 
						System.out.println("Reading" + line);
					if (counter == 1) {
						// not needed, only for sake of example
						temp = line;
						a1 = new Franchise(Integer.parseInt(temp));
						if (DEBUG)
							System.out.println("d  " + a1.getNumberOfStores());
					}
					if (counter == 2)
						;
					if (counter > 2) {
							// counter - 3 : to set lines after 2 to index 0 for storing in the array of stores
						  	int x = buildStore(a1, (counter-3), line);
							if (DEBUG)
								System.out.println("Reading Store # "+(counter-2)+" Number of weeks read =  " +  x);
							if (DEBUG)
							{	
								System.out.println("Data read:");
								// gets the store created in buildStore and outputs it's sales data
								a1.getStores(counter-3).printdata();
							}
					}
				}
			}
			// closes the file
			buff.close();
		} catch (Exception e) {
			// report error
			System.out.println("Error -- " + e.toString());
		}
		// returns the constructed franchise
		return a1;
	}

	public int buildStore(Franchise a1, int counter, String temp) {
		Store tstore = new Store();
		String s1  =  "";
		float sale = 0.0f;
		int week = 0; 	// 0 -> 4
		int day = 0; 	// 0 -> 6
		// splits the line by whitespace
		StringTokenizer st = new StringTokenizer(temp);
	    while (st.hasMoreTokens()) {
	    	 // start a new week every 7 values
	         for(day=0;day<7;day++)
	         {
	        	 // grab the next number
		    	 s1 = st.nextToken();
		         sale = Float.parseFloat(s1);
		         // save the data in the store object
	        	 tstore.setsaleforweekdayintersection(week, day, sale);
	         }
	         // increment to the next week
	         week++;
	    }
	    // insert the store object into the Franchise
		a1.setStores(tstore, counter);
		// used for debugging in readData: lets to check if the number of
		// days are lacking
	    return week; 
	}
}
