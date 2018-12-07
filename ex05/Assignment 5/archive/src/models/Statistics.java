package models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.IntStream;

import util.MyArrays;

public class Statistics implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7099922530707092881L;
	private int highs[] = new int[5];
	private int lows[] = new int[5];
	private double aves[] = new double[5];

	private static int[][] formatClassGrades(Student students[], int studentsLength) {
		int grades[][/* scores */] = new int[5][studentsLength];
		
		int scores[] = Arrays.stream(students)
				.flatMapToInt(s -> 
					// filtering out the nulls while flattening the scores
					s != null 
						? Arrays.stream(s.getScores())
						: IntStream.empty()
				)
				.toArray();
		
		for (int i = 0; i < scores.length; i++) {
			grades[i % 5][i / 5] = scores[i];
		}
		
		return grades;
	}

	public void calculate(Student students[], int studentsLength) {
		int grades[][] = formatClassGrades(students, studentsLength);
		findlow(grades);
		findhigh(grades);
		findavg(grades);
	}

	public void report() {
		System.out.printf("High Score:\t%s\n", MyArrays.formatArray(highs));
		System.out.printf("Low Score :\t%s\n", MyArrays.formatArray(lows));
		System.out.printf("Average   :\t%s\n", MyArrays.formatArray(aves));
	}

	public void findlow(int grades[][]) {
		for (int i = 0; i < lows.length; i++) {
			lows[i] = Arrays.stream(grades[i]).min().getAsInt();
		}
	}

	public void findhigh(int grades[][]) {
		for (int i = 0; i < highs.length; i++) {
			highs[i] = Arrays.stream(grades[i]).max().getAsInt();
		}
	}

	public void findavg(int grades[][]) {
		for (int i = 0; i < lows.length; i++) {
			aves[i] = Arrays.stream(grades[i]).average().getAsDouble();
		}
	}

	// I figure the you souldn't be setting lows/highs/aves since they should be
	// calculated by the class

	public int[] getLows() {
		return lows;
	}

	public int[] getHighs() {
		return highs;
	}

	public double[] getAves() {
		return aves;
	}

	public String toString() {
		return String.format("Statistics<highs=%s, lows=%s, aves=%s>", Arrays.toString(highs),
				Arrays.toString(lows), Arrays.toString(aves));
	}
}
