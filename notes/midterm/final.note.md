
FileIO.java
Exceptions -
	Two types of issue
	errors - no recovery
	exceptions - recovery
		two types of exceptions -
		i know about - fix - checked exception required to use try { }
		mistakes i will make in the future - that I do not know about - want to learn so I don't make those mistakes again - unchecked

file io -
3 things - opening a file and buffer, reading data and processing data - fileio.java - write comments
exception handling - try/catch



types - single, multiple, multilevel, hierarchical

Coding standards (new ones added)
When manipulating Strings please use StringBuffers.
Starting Lab 4 pl. start using packages.
constructor should always be public.

Packages -
-is a box that contains .java files of similar type - code organization.
-new scope for variables - package level variables - do not use - protected variables

packages -

package p1;

public class Cat extends Animal{
Cat() {
jungle = "Fancy Kalamazoo";
}
}


package p1;

public class Dog {
private Animal a1;
Dog() {
a1 = new Animal();
a1.jungle = "Fancy African Safari";
}
}
package driver;

import p1.*;
import p1.sp1.*;

public class Driver {

public static void main(String[] args) {
Animal cow = new Animal();
Cat garfield = new Cat();
Bird cuckoo = new Bird();

}

}
package p1.sp1;

public class Bird {

}
package p1;

public class Animal {
protected String jungle;
}

Strings and Stringbuffers -
String literals -
	String x = "abc"; //immutable
	x = "cde"; //memory for abc is GC and memory for cde is allocated.

	String x2 = "cde";
	//two strings with same value.

	cde is stored in a memory area called constant pool - and reference to the memory containig cde is stored in x and x2.

	x2 = "893"; if value of x2 changes does that change the value of x? - No.
	//"893" new string is created for x2.

	String x = x2 + x2 + x2 + x2 +x2 + x2 .... ;
	try for fun - but not a good coding practice.

	String x = new String("abc");
	 - String objects are immutable.

	StringBuffer a2 = new StringBuffer(); //grow or shrink the size of a string.
	//memory is reusable.

  FileIO -
   - Basics of OS, JVM and working with Files
   - Working with text files - 4 classes (FileReader, FileWriter, BufferedReader and BufferedWriter
   - Working with binary files - 4 classes (FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream)
   - Filters - DataInputStream and DataOutputStream
   - Serialization - ObjectInputStream and ObjectOutputStream.

  File IO Basics
  	- File (bytes stored in perm. location in FileSystem)
  	- FileSystem - DB of file information (part of the OS)
  	- Stream - sequence of bytes (text or binary) for transferring infomation between two software components (file and a program)
  	- Buffer - small memory location allocated for temp storage - to make IO faster.
  	Moving Truck - People - 3 bedroom house.
  	- filter - data format conversion (language filter) - text to binary
  	- object files - persists an object in memory to disk.
  			Store.java - make an object - write to disk.
  			Object persistence - Serialization

  		state of an object - properties of an object - values at a given time. - persisting an object state.

  import java.io.*; - to use the functionality for IO.

  Exceptions -
  	Problems that occur in software in runtime.

  	time of code writing - use an if statement - to prevent an issue.

  Two types of exception -
  	known to JVM - checked - try/catch clause.
  		try {

  		}
  		catch (Exception e)
  		{

  		}
  		catch (Exceptioname2 e)
  		{

  		}
  		catch (Exceptioname3 e)
  		{

  		}
  		finally {
  			//reset
  		}

  catch block --> used for documenting and fixing the issue.

  	new to JVM - unchecked

  File IO API - A programming Interface -
  A set of classes providing access to complex functionality written by someone else.

  import java.io.*;
  Working with text files
  - ReadSource.java
  import java.io.*;

  public class ReadSource {
      public static void main(String[] arguments) {
          try {
              FileReader file = new
                  FileReader("ReadSource.java");
              BufferedReader buff = new
                  BufferedReader(file);
              boolean eof = false;
              while (!eof) {
                  String line = buff.readLine();
                  if (line == null)
                     eof = true;
                  else
                      System.out.println(line);
              }
              buff.close();
          } catch (IOException e) {
              System.out.println("Error -- " + e.toString());
          }
      }
  }

  //readLine returns null if eof otherwise return the String read.

  How does readLine know about EOF?
  	How does a function reading data determine eof?

  	 - is it the content of a file? - null or -1

  	hint - its information in the filesystem and location at which data is being read.

  Fully qualified path  - z:\dirname\subdirname\filename

  /dirname/subdirname/filename

  Working with binary files -

  How is EOF determined?
  	text or binary -
  	OS --> File System --> db of file info.
  	FS - store the file length - starting location

  	Assuming that file is stored contiguously on disk
  	Theoretical equation
  		File marker > starting point + file length
  				101 + 50

  	*File marker - location of byte being read in the file.

  	return value from the read()
  	-1   binary file
  	null text file

  Data Streams - (Filter object)
  	DataInputStream and DataOutputStream
  		text to binary
  		binary to text

  WritePrimes.java
  ReadPrimes.java

  Serialization -
  	An object is created from a class.
  	Take an object in memory and persist (write) to disk.

  PerInfoClass - 400 properties.
   -
  	a1.writeObject(p1); //write one object per writeObject call.


  import java.io.*;
  import corejava.*;

  class ObjectFileTest
  {  public static void main(String[] args)
     {  try
        {  Employee[] staff = new Employee[3];

           staff[0] = new Employee("Harry Hacker", 35000, new Day(1989,10,1));
           staff[1] = new Manager("Carl Cracker", 75000, new Day(1987,12,15));
           staff[2] = new Employee("Tony Tester", 38000, new Day(1990,3,15));

        	 ObjectOutputStream out = new ObjectOutputStream(new
              FileOutputStream("employee.dat"));
           out.writeObject(staff);
           out.close();

  	ObjectInputStream in =  new ObjectInputStream(new FileInputStream("employee.dat"));
  	Employee[] newStaff = (Employee[]) in.readObject();

           int i;
           for (i = 0; i < newStaff.length; i++)
              newStaff[i].raiseSalary(100);
           for (i = 0; i < newStaff.length; i++)
              newStaff[i].print();
        }
        catch(Exception e)
        {  System.out.print("Error: " + e);
           System.exit(1);
        }
     }
  }

  class Employee implements Serializable
  {  public Employee(String n, double s, Day d)
     {  name = n;
        salary = s;
        hireDay = d;
     }

     public Employee() {}

     public void print()
     {  System.out.println(name + " " + salary
           + " " + hireYear());
     }

     public void raiseSalary(double byPercent)
     {  salary *= 1 + byPercent / 100;
     }

     public int hireYear()
     {  return hireDay.getYear();
     }

     private String name;
     private double salary;
     private Day hireDay;
  }

  class Manager extends Employee
  {  public Manager(String n, double s, Day d)
     {  super(n, s, d);
        secretaryName = "";
     }

     public Manager() {}

     public void raiseSalary(double byPercent)
     {  // add 1/2% bonus for every year of service
        Day today = new Day();
        double bonus = 0.5 * (today.getYear() - hireYear());
        super.raiseSalary(byPercent + bonus);
     }

     public void setSecretaryName(String n)
     {  secretaryName = n;
     }

     public String getSecretaryName()
     {  return secretaryName;
     }

     private String secretaryName;
  }
