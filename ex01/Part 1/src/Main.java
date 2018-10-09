import java.util.Scanner;
import java.util.stream.*;

public class Main {
	public static Scanner stdin = new Scanner(System.in);
	
	// Asks the user a question and returns their
	// response as a String 
	public static String ask(String q) {
		System.out.print(q + ": ");
		return stdin.nextLine();
	}
	
	// Asks the user to enter in the information
	// stored inside a Person instance 
	public static Person personFromScanner() {
		return new Person()
		    .setName(ask("Name"))
		    .setAge(Integer.parseInt(ask("Age")))
		    .setPhoneNumber(ask("Phone Number"))
		    .setAddress(ask("Address"));
	}
	
	public static void main(String[] args) {
		IntStream.range(0,3)
			.mapToObj((int x) -> Main.personFromScanner())
			.map(Person::print)
			.forEach(System.out::println);
		stdin.close();
	}
}