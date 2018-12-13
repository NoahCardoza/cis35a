public class Part01 {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(), saver2 = new SavingsAccount();

		saver1.setName("Jack");
		saver1.deposit(4000);

		saver2.setName("Jackie");
		saver2.deposit(30000);

		System.out.println("Setting Interest Rate to 10%");
		SavingsAccount.modifyInterestRate(0.10);

		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();

		saver1.print();
		saver2.print();

		System.out.println("Setting Interest Rate to 8%");
		SavingsAccount.modifyInterestRate(0.08);

		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();

		saver1.print();
		saver2.print();
	}

}
