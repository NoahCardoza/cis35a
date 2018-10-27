
public class Driver {
	
	public static void main(String[] args) {
		FileIO file = new FileIO("/Users/noahcardoza/projects/java/cis35a/ex02/sales/src/Salesdat.txt");
		Franchise franchise = file.readData();

		// run the UI loop
		new UI(franchise).loop();
		
	}

}
