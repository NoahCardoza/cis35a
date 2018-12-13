<!--
Working with binary files -
Data Streams - (Filter object)
	DataInputStream and DataOutputStream
		text to binary
		binary to text

WritePrimes.java
ReadPrimes.java
-->

# Exceptions & Errors

+ Exception — an issue that is recoverable
+ Error     — program crashes (out of memory, out of disk space)

### JVM Architecture

If an exception occurs it is thrown,
(creates an instance of Exception object automatically in JVM).
(halts execution) --> steps into the handling exception mode.

### Checked and Unchecked exceptions

+ Checked   - Known to the JVM requires usage of try/catch
+ Unchecked - Unknown to the JVM, may be handled or not
  - ClassCastException
  - ArrayIndexOutOfBoundsException
  - ArithmeticException

#### Examples of Exceptions

+ IOException
+ NullPointerException
+ FileNotFoundException
+ ClassCastException
+ ArrayIndexOutOfBoundsException
+ ArithmeticException

### Custom Exception

```java
// `Exception` is a super class which all exceptions extend
public class MyException extends Exception {
  int errno = -1;
  String message = "";
  // ...
}
// ...
throw new MyException(403, "Access Forbidden");
```

### Handling Exceptions

```java
try {} catch (Exception e) {} finally {}
```

# StringTokenizer

```java
import java.util.StringTokenizer;
StringTokenizer st = new StringTokenizer("1 3.14 hello");
st.countTokens();                 // 3
Integer.parse(st.nextToken());    // 1
Double.parse(st.nextToken());     // 3.14
st.nextToken();                   // "hello"
st.hasMoreTokens()                // false
```

# File I/O

### Vocabulary

| Term         | Definition                                                                                                        |
| ------------ | ----------------------------------------------------------------------------------------------------------------- |
| File System  | DB of file information (part of the OS)                                                                           |
| File         | bytes stored in permanent location in the File System                                                             |
| Stream       | sequence of bytes (text or binary) for transferring information between two software components (file -> program) |
| Buffer       | small memory location allocated for temp storage - to make IO faster.                                             |
| filter       | data format conversion (language filter), text -> binary                                                          |
| object files | persists the state of an object of an object in memory to disk                                                    |

### Classes

+ Working with text files
  - File(Reader/Writer)
  - Buffered(Reader/Writer)
+ Working with binary files
  - File(Input/Output)Stream
  - Buffered(Input/Output)Stream
+ Filters
  - Data(Input/Output)Stream
+ Serialization
  - Object(Input/Output)Stream

### Steps

1. Open File
2. Create I/O Buffer
3. Read/Write Data

#### How is EOF determined?

Within the OS the File System acts like a database of file information.
The File System stores the file lengths and starting locations.

Assuming that file is stored contiguously on disk a theoretical equation would look like: `starting point + file length`

Java return value from read()
-1   for binary file
null for text file

<br><br><br><br><br>

###  Serialization

An object is created from a class.
Take an object in memory and persist (write) it to the disk.

```java
import java.io.*;

class WriteMe implements Serializable {
  public WriteMe() {}

  public void serializeMe() {
    try {
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
      out.writeObject(this);
      out.close();
    } catch(IOException e) {
      System.out.println(e.toString());
    }
  }

  public static WriteMe deserializeMe() {
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
      WriteMe me = (WriteMe) in.readObject();
      in.close();
      return me;
    } catch(IOException e) {
      System.out.println(e.toString());
    }
  }
}
```

### Reading From A Text File

```java
try {
  String line;
  BufferedReader buff = new BufferedReader(new FileReader(FILE_NAME));

  while ((line = buff.readLine()) != null) {
    System.out.println(line);
  }

  buff.close();
} catch (IOException e) {
  System.out.println(e.toString());
}
```

### Writing to A Text File

```java
try {
  BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
  writer.write("Hello");   
  writer.close();
} catch (IOException e) {
  System.out.println(e.toString());
}
```

<br><br><br>

### Buffered(Input/Output)Stream

```java
BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(FILE_NAME));
byte b[] = { 75, 76, 77, 78, 79, 80 };

for(int i = 65; i < 75; i++) out.write(i);

out.write(b);
out.flush();
out.close();
}

int ascii;
BufferedInputStream in = new BufferedInputStream(new FileInputStream(FILE_NAME));
while ((ascii = in.read()) != -1) System.out.print((char) ascii);
// ABCDEFGHIJKLMNOP
```

### Data(Input/Output)Stream

```java
DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_NAME));
out.writeInt(123);
out.writeFloat(123.45F);
out.writeLong(789);
out.close();

DataInputStream in = new DataInputStream(new FileInputStream(FILE_NAME));
in.readInt()    // 123
in.readFloat()  // 123.45F
in.readLong()   // 789
in.close();
```

# Packages - Code Organization

A logical container in which you can put classes that are similar in functionality.
Creates new package level scope for variables protected variables - do not use.
Importing a package does not import subpackages.

### Scope

Access to a variable or a method in a given class, package or parent/child class.

| Access Level | Restraints                                                                                                 |
| ------------ | ---------------------------------------------------------------------------------------------------------- |
| private      | can only be accessed inside a class.                                                                       |
| protected    | can be accessed inside a package and a classes in different packages that have a parent/child relationship |
| public       | can be accessed anywhere                                                                                   |
| default      | can be accessed in package level variable                                                                  |

### Syntax

Always lowercase.

`package packagename;`

# Abstract Classes

Abstract classes that cannot be instantiated.
The require implementation of an abstract method by child classes - "enforcing a contract"

### Reasons

+ reusability
+ enforcing a contact
+ same signature in child class as parent declaration
+ enable polymorphism (across classes in same family)

### Example

```java
public abstract class Shape {
  // Data Abstraction
  public int height;
	public int width;

  private String color;
  // cannot be instantiated!
  public Animal(String color) { setColor(color); }
  public String getColor() { return color; }
  public void setColor(String color) { this.color = color; }
  // abstract methods require implementation of the "how" in child class.
  public abstract int area();
  // if this is not defined, a syntax error will occur
  // method signature must match in child class.
}

public class Rectangle extends Shape {
  public Rectangle(String color) { super(color); }
  // matching signature in Shape
  public int area() { /***/ }
}
```

# Interfaces

- acts as glue between two disparate complex systems.
- enable polymorphism across classes in different families.
- way to create API - expose complex functionality in a simple way.

Interfaces act as an entry point to a complex system, driving simplicity for mutual understanding.

### Real Life Examples

  - phone - screen
  - computer - mouse, keyboard and screen
  - apps - user "interface"

<br><br><br><br>

# Example

Multiple interfaces can be implemented at once when only one (abstract) class can be extended per class definition.

```java
interface Act { void act(); }

class Actor1 implements Act {
  public void act() { System.out.println("To be, or not to be"); }
}

public class TryOut {
  public static void main(String args[]) {
    Actor1 hamlet = new Actor1();
    tryout(hamlet);
  }

  // NOTE: Act not Actor1
  private static void tryout(Act actor) {
    actor.act();
  }
}

```

# Vocabulary

| Term | Definition                                                                                                    |
| ---- | ------------------------------------------------------------------------------------------------------------- |
| API  | a programming interfaces - A set of classes providing access to complex functionality written by someone else |
