
import java.util.ArrayList;
import java.util.List;

public class Part02 {
	
	static List<SpecialSavings> accounts;
	
	private static void calculateMonthlyInterest() {
		System.out.println("Calculating Monthly Interest:");
		accounts.forEach(SpecialSavings::calculateMonthlyInterest);
		print();
	}
	
	private static void modifyInterestRate(double rate) {
		System.out.printf("Set Interest Rate = %%%.2f:\n", rate * 100);
		SpecialSavings.modifyInterestRate(rate);
		print();
	}
	
	private static void withdraw(double ammount) {
		System.out.printf("Withdrawing $%.2f from all accounts:\n", ammount);
		accounts.forEach(a -> a.withdraw(ammount));
		print();
	}
	
	private static void deposit(double ammount) {
		System.out.printf("Depositing $%.2f from all accounts:\n", ammount);
		accounts.forEach(a -> a.deposit(ammount));
		print();
	}
	
	private static void print() {
		accounts.forEach(SpecialSavings::print);
	}

	public static void main(String[] args) {
		
		
		accounts = new ArrayList<SpecialSavings>();
		
		for (int n = 1; n < 6; n++) {
			accounts.add(new SpecialSavings());
			SpecialSavings acc = accounts.get(n - 1);
			acc.setName("Saver " + n);
			acc.deposit(n * 2000);
		}
		
		modifyInterestRate(0.12);
		calculateMonthlyInterest();
		withdraw(1000);
		modifyInterestRate(0.03);
		calculateMonthlyInterest();
		deposit(10000);
		calculateMonthlyInterest();
	}

}
