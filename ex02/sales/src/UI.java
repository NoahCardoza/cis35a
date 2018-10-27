
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class UI {
	boolean DEBUG = false;
	
	public interface Helpers {
		void invoke(Store store);
	}
	
	Franchise franchise;
	int numberOfStores;
	
	// a few defaults
	static int weeksWorthOfData = 6;
	static boolean operationsLoop = true;
	static Scanner stdin = new Scanner(System.in);
	
	static Helpers[] operationsRef; // this will point to operations
	static Helpers[] operations = {
			(store) -> printByWeek("| Total sales per week ::", store.totalSalesPerWeek()),
			(store) -> printByWeek("| Average sales per week ::", store.averageSalesPerWeek()),
			(store) -> System.out.printf("| Total revenue: $%.2f\n", store.totalSalesForAllWeeks()),
			(store) -> System.out.printf("| Average revenue per week: $%.2f\n", store.averageWeeklySales()),
			(store) -> System.out.printf("| The week with the most sales was:\tWeek %02d\n", store.weekWithHighestSales() + 1),
			(store) -> System.out.printf("| The week with the lowest sales was:\tWeek %02d\n", store.weekWithLowestSales() + 1),
			//						 operationsRef is used because referencing operations throws a 
			//									   compiler error since it hasn't been created yet
			(store) -> Arrays.stream(operationsRef).limit(6).forEach(s -> s.invoke(store)),
			(store) -> {
				System.out.println("| Exited to main menu");
				operationsLoop = false; 
			}
		};
	
	// only allows the user to input integers and won't give up until an integer is inputed
	public static int askForInt(String q) {
		String input;
		while (true) {
			System.out.print(q + ":\n> ");
			input = stdin.nextLine();
			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.printf("\"%s\" is not a valid integer.\n", input);
			}

		}

	}
	
	// requires the user to input an integer within an inclusive range
	public static int askForIntBetween(String q, int min, int max) {
		int n;

		q += " " + String.format("[Integer <%d..%d>]", min, max);
		while (true) {
			n = askForInt(q);
			if (min <= n && n <= max)
				return n;
			System.out.printf("%d is not inclusively between %d and %d\n", n, min, max);
		}
	}
	
	// outputs data in a per-week format
	static void printByWeek(String message, float[] array) {
		System.out.println(message);
		System.out.print("| ");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("Week %02d - $%-10.2f", i + 1, array[i]);
			if (i != array.length - 1)
				System.out.print(" | ");
		}
		System.out.print("\n");
	}
	
	UI(Franchise f) {
		franchise = f;
		numberOfStores = franchise.getNumberOfStores();
		IntStream.range(0, numberOfStores).mapToObj(f::getStores).forEach(Store::analyzeResults);
		if (DEBUG)
			IntStream.range(0, numberOfStores).mapToObj(f::getStores).forEach(Store::print);
		System.out.println("Welcome to the Franchise Manager App");
		System.out.printf("We have data for %d stores for last %d weeks.\n", numberOfStores, weeksWorthOfData);
	}
	
	// a loop which will continue until the user quits the program
	public void loop() {
		operationsRef = operations;
		Store selectedStore;
		int selectedStoreIndex;
		int selectedFunction;
	
		while (true) {
			System.out.println("Which store would you like to analyze?");
			selectedStoreIndex = askForIntBetween(String.format("Select a store by number (1 through %d) or enter %d to terminate the program", numberOfStores, numberOfStores + 1), 1, numberOfStores + 1);
			if (selectedStoreIndex > numberOfStores)
				return;
			selectedStore = franchise.getStores(selectedStoreIndex - 1);
			System.out.printf("---------\nViewing store %d\n---------\n", selectedStoreIndex);

			while (operationsLoop) {
				System.out.println("Operations:\n" + 
					"1. Enter 1 for total sales for each week \r\n" + 
					"2. Enter 2 for average daily sales for each week\r\n" + 
					"3. Enter 3 for total sales for all weeks\r\n" + 
					"4. Enter 4 for average weekly sales\r\n" + 
					"5. Enter 5 for week with the highest amount in sales. \r\n" + 
					"6. Enter 6 for week with the lowest amount in sales. \r\n" + 
					"7. Enter 7 for all analytical data. (1 through 6)\n" +
					"8. Enter 8 to exit to the main menu.");
				selectedFunction = askForIntBetween("Select a operation by number", 1, 8);
				System.out.println("---------");
				// selectedFunction - 1 : because indexes start with 0
				operations[selectedFunction - 1].invoke(selectedStore);
				System.out.println("---------");
			}
			operationsLoop = true;
		}
	}
}
