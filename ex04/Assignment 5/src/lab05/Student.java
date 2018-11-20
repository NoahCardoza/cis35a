package lab05;

import java.util.Arrays;

public class Student {
	private int SID;
	private int scores[] = new int[5];
	private int sIndex = 0; // keeps track of the next index of `scores` to set when calling pushScore

	public Student() {
	}

	public Student(int SID) {
		this.SID = SID;
	}

	public Student(int SID, int[] scores) {
		this.SID = SID;
		this.scores = scores;
	}

	public void pushScore(int score) {
		scores[sIndex++] = score;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int SID) {
		this.SID = SID;
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	public String toString() {
		return String.format("Student<SID=%d, scores=%s, sIndex=%d>", SID, Arrays.toString(scores), sIndex);
	}
}
