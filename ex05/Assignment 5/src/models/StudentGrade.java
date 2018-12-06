package models;

import java.io.Serializable;

public class StudentGrade implements Serializable {
	/**
	 * What?
	 */
	private static final long serialVersionUID = 3205326189721309691L;

	Student student;

	Statistics statistics;


	public StudentGrade(Student student, Statistics statistics) {
		this.student = student;
		this.statistics = statistics;
	}
	
	public Statistics getStatistics() {
		return statistics;
	}
	
	public Student getStudent() {
		return student;
	}
}
