
public class Part01 {

	public static void main(String[] args) {		
		SavingsAccount 
			saver1 = new SavingsAccount("Bob", 2000.00),
			saver2 = new SavingsAccount("Json", 3000.00);
		
		System.out.println("Setting Interest Rate to 4%");
		SavingsAccount.modifyInterestRate(0.04);
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		saver1.print();
		saver2.print();
		
		System.out.println("Setting Interest Rate to 5%");
		SavingsAccount.modifyInterestRate(0.05);
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		saver1.print();
		saver2.print();
	}

}
