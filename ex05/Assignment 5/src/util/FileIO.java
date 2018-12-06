package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;
import log.Logger;

import exception.StudentGradingException;
import models.Student;
import models.StudentGrade;

public class FileIO {
	
	public static void serializeStudentGrade(StudentGrade grade) {
		ObjectOutputStream out;
		String filename;
		Logger logger = Logger.getLogger();
		
		try {
			filename = "student." + grade.getStudent().getSID() + ".ser";
			out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(grade);
		    out.close();
		    logger.debug("Successfully wrote \"" + filename + "\" to the filesystem.");
		} catch (IOException e) {
			StudentGradingException.IOException(e);
		}
	    
	}
	
	public static StudentGrade deserializeStudentGrade(String filename) {
		ObjectInputStream in;

		try {
			in = new ObjectInputStream(new FileInputStream(filename));
			StudentGrade grade = (StudentGrade) in.readObject();
		    in.close();
		    return grade;
		} catch (FileNotFoundException e) {
			StudentGradingException.fileNotFound(filename);
		}
		catch (ClassNotFoundException | IOException e) {
			StudentGradingException.IOException(e);
		}
	    return null;
	}
	
	public static int readStudents(BufferedReader buff, Student students[]) throws StudentGradingException, IOException {
		String line;
		int sIndex = 0;
		
		try {
			while (sIndex < 40 && (line = buff.readLine()) != null) {
				// could check for empty lines
				StringTokenizer tokens = new StringTokenizer(line);

				students[sIndex] = new Student(Integer.parseInt(tokens.nextToken())); // create student

				for (int tokensLeft = tokens.countTokens(); tokensLeft > 0; tokensLeft--) {
					students[sIndex].pushScore(Integer.parseInt(tokens.nextToken()));
				}
				sIndex++;
			}
		}
		catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw new StudentGradingException(100, "The expected format was not followed on line " + sIndex + " of the student data file.");
		}

		return sIndex;
	}

	public static int readFile(String filename, Student students[]) {
		try {
			BufferedReader buff = new BufferedReader(new FileReader(filename));
			buff.readLine(); // ignore the first line
			int studentsLength = readStudents(buff, students);
			buff.close();
			return studentsLength;
		} catch (IOException e) {
			StudentGradingException.IOException(e);
		} catch (StudentGradingException e) {
			return readFile(e.fixFormatException(), students);
		}
		

		return 0;
	}
}
