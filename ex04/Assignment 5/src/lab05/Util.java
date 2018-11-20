package lab05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
		DecimalFormat df = new DecimalFormat("#.#");

		return DoubleStream.of(array).mapToObj(df::format).collect(Collectors.joining("\t"));
	}

	public static int countLines(FileReader file) throws IOException {
		int lines = 0;

		BufferedReader reader = new BufferedReader(file);
		while (reader.readLine() != null)
			lines++;
		reader.close();
		return lines;
	}

	public static Student[] readStudents(BufferedReader buff, int studentCount) throws IOException {
		Student students[] = new Student[studentCount];

		for (int sIndex = 0; sIndex < studentCount; sIndex++) {
			StringTokenizer tokens = new StringTokenizer(buff.readLine());

			students[sIndex] = new Student(Integer.parseInt(tokens.nextToken())); // create student

			for (int tokensLeft = tokens.countTokens(); tokensLeft > 0; tokensLeft--) {
				students[sIndex].pushScore(Integer.parseInt(tokens.nextToken()));
			}
		}

		return students;
	}

	public static Student[] readFile(String filename) {
		File file = new File(filename);

		if (!file.exists()) {
			System.out.println("Caught Exception: The file (" + filename + ") does not exists.");
		} else {
			try {
				FileReader fileReader = new FileReader(filename);
				int studentCount = countLines(new FileReader(filename)) - 1;
				BufferedReader buff = new BufferedReader(fileReader);
				buff.readLine(); // ignore the first line
				Student students[] = readStudents(buff, studentCount);
				buff.close();
				return students;
			} catch (IOException e) {
				System.out.println("Caught Exception: " + e.toString());
			}
		}

		return null;
	}
}
