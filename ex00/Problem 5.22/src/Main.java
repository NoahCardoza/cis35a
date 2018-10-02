import java.util.Scanner;
import java.util.function.Function;

public class Main {
	public static double getValidDouble(Scanner in, String message, Function<Double, Boolean> tester, String errorMessage) {
		double input;

		while (true) {
			System.out.print(message);
			input = in.nextDouble();

			if (tester.apply(input))
				break;
			else
				System.out.println(errorMessage);

		}
		return input;
	}
	
	public static double getPositiveDouble(Scanner in, String message) {
		double input;

		while (true) {
			System.out.print(message);
			input = in.nextDouble();

			if (input > 0)
				break;
			else
				System.out.println("This input must be positive");

		}
		return input;
	}
	
	

	public static int getPositiveInt(Scanner in, String message) {
		int input;

		while (true) {
			System.out.print(message);
			input = in.nextInt();

			if (input > 0)
				break;
			else
				System.out.println("This input must be positive");

		}
		return input;
	}

	public static void calulateLoan(double loanAmount, int years, double interest) {
		double interestPerMonth;
		double monthlyPayment;
		double principal;
		int numberOfMonths;

		numberOfMonths = years * 12;
		interestPerMonth = interest / 12.0;
		monthlyPayment = (loanAmount * interestPerMonth) / 1
				/ (1 - (1 / Math.pow(1 + interestPerMonth, numberOfMonths)));

		System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);
		System.out.printf("Total Payment: %.2f\n", monthlyPayment * numberOfMonths);

		System.out.println("\nPayment#\tInterest\t\tPrincipal\t\tBalance");

		for (int i = 1; i <= numberOfMonths; i++) {
			interest = (interestPerMonth * loanAmount);
			principal = (monthlyPayment - interest);
			loanAmount -= principal;

			if (i == numberOfMonths) {
				if (loanAmount >= 0) {
					principal += loanAmount;
				} else {
					loanAmount = 0;
				}
			}
			System.out.printf("%-5d\t\t%-10.2f\t\t%-10.2f\t\t%-10.2f\n", i, interest, principal, loanAmount);
		}

	}
	
	public static boolean loanAmountTester(double input) {
		return input >= 1;
	}

	public static void main(String[] args) {
		double loanAmount;
		double interest;
		int years;

		Scanner stdin = new Scanner(System.in);

		loanAmount = getValidDouble(stdin, "Loan Amount: ", Main::loanAmountTester, "This input must be equal or greater than 1");
		years = getPositiveInt(stdin, "Number of Years: ");
		interest = getPositiveDouble(stdin, "Annual Interest Rate: ") / 100.0;

		calulateLoan(loanAmount, years, interest);

		stdin.close();
	}

}
