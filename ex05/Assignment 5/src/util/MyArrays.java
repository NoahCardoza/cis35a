package util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class MyArrays {

	public static String arrays2DToString(int[][] array) {
		StringBuffer str = new StringBuffer();
		str.append("[");
		for (int[] arr : array) {
			str.append("\n\t" + Arrays.toString(arr) + ",");
		}
		str.deleteCharAt(str.length() - 1); // remove trailing comma
		str.append("\n]");
		return str.toString();
	}

	public static String formatArray(int[] array) {
		return IntStream.of(array).mapToObj(Integer::toString).collect(Collectors.joining("\t"));
	}

	public static String formatArray(double[] array) {
		DecimalFormat df = new DecimalFormat("###.#");
		// doesn't round properly
		df.setRoundingMode(RoundingMode.HALF_UP);
		return DoubleStream.of(array).mapToObj(df::format).collect(Collectors.joining("\t"));
	}

}
