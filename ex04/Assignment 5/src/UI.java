import java.io.File;
import java.util.Scanner;

public class UI {
	public static String askForFile() {
		File file;
		Scanner stdin = new Scanner(System.in);
		
		System.out.print("Where is your file located: ");
		
		while (true) {
			file = new File(stdin.nextLine());
			if (file.exists()) break;
			System.out.println("That file dose not exist.");	
		}
		
		stdin.close();
		return file.getPath();
	}
}
