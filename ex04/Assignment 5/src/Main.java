import lab05.*;
import debug.Debugger;

public class Main {
	public static void main(String[] args) {
		Student students[] = new Student[40];
		Debugger debugger = new Debugger(Debugger.OFF);
		int studentsLength = Util.readFile(UI.askForFile(), students);

			for (int i = 0; i < studentsLength; i++)
				debugger.info(students[i]);
			
			Statistics s = new Statistics(students, studentsLength);
			debugger.info("Statistics::toString (before calculations)");
			debugger.info(s.toString());
			s.calculate();
			debugger.info("Statistics::toString (after calculations)");
			debugger.info(s.toString());
			s.report();
	}
}
