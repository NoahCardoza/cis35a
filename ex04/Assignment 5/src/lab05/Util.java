package lab05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Util {
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

	public static int readStudents(BufferedReader buff, Student students[]) throws IOException {
		String line;
		int sIndex = 0;
		
		while (sIndex < 40 && (line = buff.readLine()) != null) {
			// could check for empty lines
			StringTokenizer tokens = new StringTokenizer(line);

			students[sIndex] = new Student(Integer.parseInt(tokens.nextToken())); // create student

			for (int tokensLeft = tokens.countTokens(); tokensLeft > 0; tokensLeft--) {
				students[sIndex].pushScore(Integer.parseInt(tokens.nextToken()));
			}
			sIndex++;
		}

		return sIndex;
	}

	public static int readFile(String filename, Student students[]) {
		File file = new File(filename);

		if (!file.exists()) {
			System.out.println("Caught Exception: The file (" + filename + ") does not exists.");
		} else {
			try {
				BufferedReader buff = new BufferedReader(new FileReader(filename));
				buff.readLine(); // ignore the first line
				int studentsLength = readStudents(buff, students);
				buff.close();
				return studentsLength;
			} catch (IOException e) {
				System.out.println("Caught Exception: " + e.toString());
			}
		}

		return 0;
	}
}
