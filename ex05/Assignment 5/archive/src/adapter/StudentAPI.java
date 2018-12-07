package adapter;

import java.io.File;

import exception.StudentGradingException;
import models.StudentGrade;
import util.FileIO;

public abstract class StudentAPI implements StudentApiOutline {

	String path;

	public void printClassStatistics() {
		File file = new File(path);

		// search for student files
		File files[] = file.listFiles(helpers.FilenameFilterWrapper.filenameWrappedBy("student.", ".ser"));

		if (files != null && files.length > 0) {
			StudentGrade grade = FileIO.deserializeStudentGrade(files[0].getPath());
			if (grade != null)
				grade.getStatistics().report();
		} else {
			StudentGradingException.GradesNotLoaded(path);
		}
	}

	public void printScoresForStudent(int sid)
	{
		File file = new File(path, "student." + sid + ".ser");
		StudentGrade grade = FileIO.deserializeStudentGrade(file.getPath());
		if (grade != null)
			System.out.println(grade.getStudent().toString());
	}
}
