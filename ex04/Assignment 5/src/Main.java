
import debug.Debugger;
import lab05.*;

public class Main {
	public static void main(String[] args) {
		Debugger debugger = new Debugger(Debugger.OFF);
		Student students[] = Util.readFile(UI.askForFile());		

		if (students == null) {
			System.out.println("An error occured loading the students scores.");
		} else {
			for (Student student : students)
				debugger.info(student.toString());
			
			Statistics s = new Statistics(students);
			debugger.info("Statistics::toString (before calculations)");
			debugger.info(s.toString());
			s.calculate();
			debugger.info("Statistics::toString (after calculations)");
			debugger.info(s.toString());
			s.report();
		}
	}
}
