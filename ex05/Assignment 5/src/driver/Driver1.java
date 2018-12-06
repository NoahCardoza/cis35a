package driver;
import exception.StudentGradingException;
import log.Logger;
import models.*;
import util.FileIO;
import util.UI;

public class Driver1 {
	public static void main(String[] args) {
		Student students[] = new Student[40];
		Logger logger = new Logger(Logger.INFO, "program.log");
		StudentGradingException.setLogger(logger);
		// `test-data/scores/-1` has an invalid format
		// int studentsLength = FileIO.readFile("test-data/scores/-1", students);
		int studentsLength = FileIO.readFile(UI.askForFile(), students);

		for (int i = 0; i < studentsLength; i++)
			logger.info(students[i]);
		
		Statistics s = new Statistics();
		logger.info("Statistics::toString (before calculations)");
		logger.info(s.toString());
		s.calculate(students, studentsLength);
		logger.info("Statistics::toString (after calculations)");
		logger.info(s.toString());
		s.report();
		
		UI.cleanup();
	}
}
	