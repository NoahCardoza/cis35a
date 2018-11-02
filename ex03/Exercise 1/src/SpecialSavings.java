
public class SpecialSavings extends SavingsAccount {
	SpecialSavings(String accountName, double startingBalance) {
		super(accountName, startingBalance);
	}

	public void calculateMonthlyInterest() {
		double balance = getBalance();
		if (balance > 10000)
			deposit(balance * .1);
		else
			super.calculateMonthlyInterest();

	}
}
