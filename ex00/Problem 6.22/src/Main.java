import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String input;
		boolean repl = true;
		Scanner stdin = new Scanner(System.in);
		MyMathTest tester = new MyMathTest();

		tester.initialize();
		tester.testSqrt();

		System.out.println("\nWelcome to the sqrt REPL!");
		System.out.println("Type any number to get it's square root");
		System.out.println(".help to see a list of commands");

		while (repl) {
			input = stdin.nextLine().trim();
			if (input.equals(".help")) {
				System.out.println(".help\t\t\t\tShows this table");
				System.out.println(".exit\t\t\t\tTerminates the REPL");
				System.out.println(".set ::");
				System.out.println("  accuracy [int] (default 6)\tSets the accuracy when estimating the square root");
			} else if (input.equals(".exit")) {
				repl = false;
			} else if (input.startsWith(".set ")) {
				input = input.substring(5);
				if (input.startsWith("accuracy ")) {
					try {
						MyMath.accuracy = Math.pow(10, -new Integer(input.substring(9)));
					} catch (java.lang.NumberFormatException e) {
						System.out.println("This is an invalid number");
					}

				} else {
					System.out.println("This is an invalid property to set");
				}
			} else {
				try {
					System.out.println(MyMath.sqrt(new Long(input)));
				} catch (java.lang.NumberFormatException e) {
					System.out.println("This is not a valid command or `sqrt(long n)` input (number)");
				}
			}
		}

		stdin.close();
	}
}
