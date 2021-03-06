package lab05;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Statistics {
	private int highs[] = new int[5];
	private int lows[] = new int[5];
	private double aves[] = new double[5];
	private int quizes[][/* scores */];

	public Statistics(Student students[], int studentsLength) {
		quizes = new int[5][studentsLength];
		
		int scores[] = Arrays.stream(students)
				.flatMapToInt(s -> 
					// filtering out the nulls while flattening the scores
					s != null 
						? Arrays.stream(s.getScores())
						: IntStream.empty()
				)
				.toArray();
		
		for (int i = 0; i < scores.length; i++) {
			quizes[i % 5][i / 5] = scores[i];
		}
	}

	public void calculate() {
		findlow();
		findhigh();
		findavg();
	}

	public void report() {
		System.out.printf("High Score:\t%s\n", Util.formatArray(highs));
		System.out.printf("Low Score :\t%s\n", Util.formatArray(lows));
		System.out.printf("Average   :\t%s\n", Util.formatArray(aves));
	}

	public void findlow() {
		for (int i = 0; i < lows.length; i++) {
			lows[i] = Arrays.stream(quizes[i]).min().getAsInt();
		}
	}

	public void findhigh() {
		for (int i = 0; i < highs.length; i++) {
			highs[i] = Arrays.stream(quizes[i]).max().getAsInt();
		}
	}

	public void findavg() {
		for (int i = 0; i < lows.length; i++) {
			aves[i] = Arrays.stream(quizes[i]).average().getAsDouble();
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
		return String.format("Statistics<highs=%s, lows=%s, aves=%s, quizes=%s>", Arrays.toString(highs),
				Arrays.toString(lows), Arrays.toString(aves), Util.arrays2DToString(quizes));
	}
}
