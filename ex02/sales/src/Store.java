import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Store {
	private int numberOfWeeks = 5;
	private float salesbyweek[][];

	private float[] totalSalesPerWeekCache;
	private float[] averageSalesPerWeekCache;
	private float totalSalesForAllWeeksCache = -1.0f;
	private float averageWeeklySalesCache = -1.0f;
	private int weekWithHighestSalesCache = -1;
	private int weekWithLowestSalesCache = -1;

	Store() {
		salesbyweek = new float[5][7];
	}

	// getter and setters

	public void setsaleforweekdayintersection(int week, int day, float sale) {
		salesbyweek[week][day] = sale;
	}

	public void printdata() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(salesbyweek[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private float sum(float[] array) {
		long sum = 0;
		for (float n : array) {
			sum += n;
		}
		return sum;
	}

	static private DoubleStream floatToDoubleStream(float[] array) {
		return IntStream.range(0, array.length).mapToDouble(i -> array[i]);
	}

	private List<Float> floatArrayToList(float[] array) {
		List<Float> list = new ArrayList<Float>();

		for (float f : array) {
			list.add(new Float(f));
		}

		return list;
	}

	private int weekWithPolarSales(String method) {
		float[] weeks = totalSalesPerWeek();

		try {
			return floatArrayToList(weeks).indexOf((float) ((OptionalDouble) DoubleStream.class
					.getDeclaredMethod(method).invoke(floatToDoubleStream(weeks))).getAsDouble());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// this will never be called since this is a private method
		// and I don't pass arguments which will throw errors
		return -1;
	}

	public float getSaleForWeekDayIntersection(int week, int day) {
		return salesbyweek[week][day];
	}

	public float[] getSalesForEntireWeek(int week) {
		return salesbyweek[week];
	}

	public float[] totalSalesPerWeek() {
		if (totalSalesPerWeekCache == null) {
//			System.out.println("Caching totalSalesPerWeekCache");
			totalSalesPerWeekCache = new float[numberOfWeeks];
			for (int week = 0; week < numberOfWeeks; week++) {
				totalSalesPerWeekCache[week] = sum(getSalesForEntireWeek(week));
			}
		}
		return totalSalesPerWeekCache;
	}

	public float[] averageSalesPerWeek() {
		if (averageSalesPerWeekCache == null) {
//			System.out.println("Caching averageSalesPerWeekCache");
			averageSalesPerWeekCache = totalSalesPerWeek();

			for (int week = 0; week < numberOfWeeks; week++) {
				// 5 days per week
				averageSalesPerWeekCache[week] = averageSalesPerWeekCache[week] / 5;
			}
		}

		return averageSalesPerWeekCache;
	}

	public float totalSalesForAllWeeks() {
		if (totalSalesForAllWeeksCache == -1.0f) {
//			System.out.println("Caching totalSalesForAllWeeksCache");
			totalSalesForAllWeeksCache = sum(totalSalesPerWeek());
		}
		return totalSalesForAllWeeksCache;
	}

	public float averageWeeklySales() {
		if (averageWeeklySalesCache == -1.0f) {
//			System.out.println("Caching averageWeeklySalesCache");
			averageWeeklySalesCache = (float) Arrays.stream(salesbyweek).flatMapToDouble(Store::floatToDoubleStream)
					.average().getAsDouble();
		}
		return averageWeeklySalesCache;
	}

	public int weekWithHighestSales() {
		if (weekWithHighestSalesCache == -1) {
//			System.out.println("Caching weekWithHighestSalesCache");
			weekWithHighestSalesCache = weekWithPolarSales("max");
		}
		return weekWithHighestSalesCache;
	}

	public int weekWithLowestSales() {
		if (weekWithLowestSalesCache == -1) {
//			System.out.println("Caching weekWithLowestSalesCache");
			weekWithLowestSalesCache = weekWithPolarSales("min");
		}
		return weekWithLowestSalesCache;
	}

	public void analyzeResults() {
		totalSalesPerWeek();
		averageSalesPerWeek();
		totalSalesForAllWeeks();
		averageWeeklySales();
		weekWithHighestSales();
		weekWithLowestSales();
	}
	

	private String formatArray(float[] arr){
		return "[" + floatToDoubleStream(arr)
			.mapToObj(f -> String.format("%.2f", f))
			.collect(Collectors.joining(", ")) + "]";
	}

	public void print() {
		System.out.printf("Store<totalSalesPerWeek=%s, averageSalesPerWeek=%s, totalSalesForAllWeeks=%.2f, averageWeeklySales=%.2f, weekWithHighestSales=%d, weekWithLowestSales=%d>\n",
			formatArray(totalSalesPerWeek()),
			formatArray(averageSalesPerWeek()),
			totalSalesForAllWeeks(),
			averageWeeklySales(),
			weekWithHighestSales(),
			weekWithLowestSales()
		);
	}

	// businessmethod
	// a. totalsalesforweek
	// b. avgsalesforweek
	// c. totalsalesforallweeks
	// d. averageweeklysales
	// e. weekwithhighestsaleamt
	// f. weekwithlowestsaleamt
	// analyzeresults //call a through f
	// print()
}
