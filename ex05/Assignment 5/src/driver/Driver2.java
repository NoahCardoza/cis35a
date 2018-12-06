package driver;

import java.util.stream.IntStream;

import log.Logger;
import models.*;
import util.FileIO;
import util.UI;

public class Driver2 {
	public static void main(String[] args) {
		Student students[] = new Student[40];
		Logger debugger = new Logger(Logger.INFO, "program.log");

		int studentsLength = FileIO.readFile(UI.askForFile(), students);

		for (int i = 0; i < studentsLength; i++)
			debugger.info(students[i]);
		
		Statistics s = new Statistics();
		debugger.info("Statistics::toString (before calculations)");
		debugger.info(s.toString());
		s.calculate(students, studentsLength);
		debugger.info("Statistics::toString (after calculations)");
		debugger.info(s.toString());
		
		s.report();
		
		System.out.println("Saving grading information to hard disk...");
		
		IntStream.range(0, studentsLength)
			.mapToObj(i -> new StudentGrade(students[i], s))
			.forEach(FileIO::serializeStudentGrade);
		
		System.out.println("Serialization complete.");
	}
}
	