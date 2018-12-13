

public class SavingsAccount {
	private static double annualInterestRate;
	private static double monthlyInterestRate;
	private double savingsBalance;
	private String name;

	SavingsAccount() {}
	
	SavingsAccount(String accountName, double startingBalance) {
		savingsBalance = startingBalance;
		name = accountName;
	}

	public static void modifyInterestRate(double value) {
		annualInterestRate = value;
		monthlyInterestRate = value / 12;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public double getBalance() {
		return savingsBalance;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	
	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void calculateMonthlyInterest() {
		deposit(savingsBalance * monthlyInterestRate);
	}
	
	public void deposit(double amount) {
		savingsBalance += amount;
	}
	
	public void withdraw(double amount) {
		savingsBalance -= amount;
	}
	
	public void print() {
		System.out.printf("SpecialSavings<owner=\"%s\", savingsBalance=%.2f, annualInterestRate=%.2f, monthlyInterestRate=%.4f>\n", name, savingsBalance, annualInterestRate, monthlyInterestRate);
	}
}
