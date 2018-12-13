# Binary Conversion

```
Base 2 to base 10

Bit:     1 0 1 1 0 1 0 1
Index:   7 6 5 4 3 2 1 0
Formula: sum(bit * 2 ^ index)
------------------
(1 * 2^7) + (0 * 2^6) + (1 * 2^5) + (1 * 2^4) + (0 * 2^3) + (1 * 2^2) + (0 * 2^1) + (1 * 2^0)

= 181

Base 10 to base 2
Number: 77
------------------
     q  r  b
77/2 38 1  1
38/2 19 0  01
19/2 9  1  101
9 /2 4  1  1101
4 /2 2  0  01101
     1  0  001101
1 /2 0  1  01001101

= 0 1 0 0 1 1 0 1
```

# Compiled vs Interpreted

##### Process for Compiled Code

```
1. Text File      >*
2. Syntax Checker  |
3. Grammar Checker |
4. Linking Files   |
5. Binary File    <*
```

##### Process for Interpreted Code

```
1. Classpath            >*
2. Class Loader          |
3. Syntax Checker        |
4. Byte-code Verifier    |
5. Byte-code Interpreter |
<!-- 6. JIT             <* ?  -->
```

# Portability

Portability is SLOW!

1. HelloWorld.java  (text)
2. HelloWorld.class (binary)
3. JRE (Java Runtime Environment) / JVM (Java Virtual Machine)
4. converts .class file to native (line by line)

# Structure Of Memory

> An array of indices; Stores a byte of information in base 2.
> Using the index you an access the information.

+ Stack Memory (is used for)
  + expressions
  + local variables
  + function arguments
  + NOTE: (has a fixed size)
+ Heap Memory
  + Memory waiting to be dynamically allocated
+ Cache Memory
  + A buffer that acts for temp storage in runtime.
+ Registers Memory
  + Memory quickly accessible to a computer's CPU.
+ CS - Code Segment
+ DS - Data Segment

---

# Types/Literals/Sizes

|  Type   | Literal    | Size    |
|:-------:| ---------- | ------- |
| boolean | true/false | 1 bit   |
|  char   | 'a'        | 2 bytes |
|   int   | 0          | 4 bytes |
|  short  | N/A        | 4 bytes |
|  float  | 0.0f       | 4 bytes |
| double  | 0.0        | 8 bytes |
|  long   | 1L         | 8 bytes |
|  byte   | N/A        | 8 bytes |
| String  | "abc"      | N/A     |

### NOTE:

+ All primitive types are passed by value.
+ All objects are passed by reference.
+ Arrays are immutable **objects** and fixed in size.
  They are also stored in contiguous memory segments.

# Identifiers/Variables

Valid identifiers are made of
alphanumeric characters and underscores.

<br>
<br>
<br>

# Operators

| Operator | Name                   | OOO |
|:--------:| ---------------------- | --- |
|    =     | Assignment             | 0   |
|    <     | Less Than              | 0   |
|    >     | Greater Than           | 0   |
|    <=    | Less Than / Equal To   | 0   |
|    >=    | Greater Than /Equal To | 0   |
|    !=    | Not Equal To           | 0   |
|    ==    | Equal To               | 0   |
|    !     | Logical Negation       | 0   |
|   \|\|   | OR                     | 1   |
|    &&    | AND                    | 1   |
|    *     | Multiplication         | 1   |
|    /     | Division               | 1   |
|    %     | Modulo                 | 1   |
|    **    | Power                  | 1   |
|    +     | Addition               | 2   |
|    -     | Subtraction            | 2   |
|    ++    | Increment              | *   |
|   -\-    | Decrement              | *   |

#### \*NOTE

+ `x`(`++`/`--`) :: Preforms the increment/decrement AFTER the expressions uses the value
+ (`++`/`--`)`x` :: Preforms the increment/decrement BEFORE the expressions uses the value

---

# What is a process?

Processes are managed by in OS. They represent programs running on a machine.

1. Machine instruction get loaded
2. Instruction are interpreted by the CPU
3. Program Counter keeps track of which instruction was last executed
4. Memory is stores in 4 parts: Stack, Heap, CS, and DS.
5. Registers are used to cache data for computing

<br>
<br>
<br>
<br>

# Libraries

### Scanner

```java
import java.util.Scanner;

Scanner stdin = new Scanner(System.in);
stdin.next();                 // String
stdin.next<PrimitiveType>();  // PrimitiveType
stdin.nextLine();             // String
```

### Arrays

```java
import java.util.Arrays;

int array[] = { 5, 4, 3, 2, 1 };
Arrays.sort(x);                  // void
array                            // { 1, 2, 3, 4, 5 }
Arrays.binarySearch(array, 3);   // 2
```

### Random

```java
import java.util.Random;

Random.nextBoolean();
Random.nextInt();
Random.nextFloat();
```

### StringBuffer

Because Strings are immutable memory is allocated once
and characters cannot be added or modified.

StringBuffer is a peer class of String. While the String
class creates strings of fixed lengths, StringBuffer
class creates strings of flexible length that can be
modified in terms of both length and content. We can
insert characters and substring in the middle of the
string or append another string to the end.  Given
below are some of the methods used in String
manipulations:

| Method    | Description                                                                                                                                  |
| --------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| setCharAt | Modifies the nth character to x 's1.setCharAt(n, 'x');'                                                                                      |
| append    | Appends the string s2 to s1 at the end `s1.append(s2);`                                                                                      |
| insertAt  | Inserts the string s2 at the position n of the string s1 `s1.insert(n, s2);`                                                                 |
| setLength | Sets the length of the String s1 to n.  If n < s1.length( ), s1 is truncated.  If n > s1.length(), zeros are added to s1. `s1.setLength(n);` |

Given below is an example, which explains how the methods ofStringBuffer class are used to manipulate the strings:

```java
import java.util.StringBuffer;

class StringManipulation
{
    public static void main(String args[])
    {
        // str is an object of class StringBuffer
        StringBuffer str = new StringBuffer("Object language");
        System.out.println("Original String : "+str);
        System.out.println("Length of String is : "+ str.length());

        for(int i = 0; i < str.length(); i++)
        {
            int p = i + 1;
            // accessing characters in a string
            System.out.println("Character at position : " + p +" is : "
                                + str.charAt(i));
        }
        String aString = new String(str.toString());
        int pos = aString.indexOf("language");

        // inserting a string in the middle
        str.insert(pos, "Oriented");
        System.out.println("Modified string : " + str);

        // Modifying character at position 6
        str.setCharAt(6, '`');
        System.out.println("String now : " + str);

        // Appending a string at the end
        str.append("improves security : ");
        System.out.println("Append string : "+str);
    }
}
```

# Equality of Strings

Because Strings are objects:

```java
"Why?" != "Why?" // true
```

To check the equality of the characters contained
within the String you must use `.equals`:

```java
"Why?".equals("Why?") // true
```

# Printf

```java
System.out.printf(); // remember \n
```

Format: `%[minimum width][.precision][datatype]`

| Char | Datatype     |
|:----:| ------------ |
|  c   | char         |
|  f   | float/double |
|  s   | String       |
|  d   | integer      |


# Decision Making

### if/if else/else

```java
if () else if () else
```

### switch/case

```java
// NOTE: if break is omitted the
// next case is executed until the
// last case or a break is found
switch (value) {
  case 1: a1;
  case 2: a2; break;
  case 3: a3; a4;
  default: a6;
}
```

# Loops

```java
while () {}
for (int i = 0; i > 10; i++) {}
for (Type el : arrayOfType) {}
do {} while ();
```

# Comments

| Start | End | Notes       |
| ----- | --- | ----------- |
| //    | N/A | Single Line |
| /*    | */  | Multiline   |
| /**   | */  | Javadoc     |

# Working with Objects

A class is similar to the blueprint of a house and the built house
is similar to an instance of a class.

### Class Anatomy

+ Instance Variables
+ Static Variables
+ Constructors - methods that initialize an object - same name as class
+ Instance Methods
+ Static Methods
+ Getters/Setters

### Constructors

Constructor should always be public.

```java
public class A {
  A(){} // constructor
}
```

### Overriding vs. Overloading

**Overloading** occurs when two or more methods in one class have the same
method name but different parameters.

**Overriding** means having two methods with the same method name
and parameters (i.e., method signature). One of the methods is in the
parent class and the other is in the child class. Overriding allows a
child class to provide a specific implementation of a method that is already
provided its parent class.

**A constructor cannot be overridden** because the constructors have the
same name as their class and child classes cannot have the same name as
their parent.


### Java Coding Standards

+ Class name should start with an upper case letter.
+ They must include a default constructor.
+ **All** properties must be private
+ Every class must have a print method that can print the values of instance variables.
<!-- + All methods must be public. NOTE: email pending-->

### Static/Instance Variables/Methods

Static Variables/Methods can be accessed without an instance
of the class being initiated, where as an instance Variables/Methods
are tied to specific instances

```java
class A {
  static int sVar = 42;
  int iVar;

  A() {
    iVar = 24;
  }
}

A iA = new A();
A.sVar  // 42
iA.sVar // 42
A.iVar  // Error
iA.iVar // 24
```

##### Examples of Static Variables

notes I am typing, time, lab1, temp in a room, networkid, number of eyes in human, weather in a city, cityname, instructor, college

### Protection

| Class       | Package | Subclass (same pkg) | Subclass (diff pkg) | World |
| ----------- |:-------:|:-------------------:|:-------------------:|:-----:|
| public      |    +    |          +          |          +          |   +   |
| protected   |    +    |          +          |          +          |       |
| no modifier |    +    |          +          |          +          |       |
| private     |    +    |          +          |                     |       |

**+**    : accessible<br>
**blank** : not accessible

All properties and methods should be made private unless
explicitly needed otherwise. Public values can be changed
from anywhere which creates classes prone to stealth bugs.

### Inheritance

> Transferring the properties of parent to child

```java
class A {};
class B extends A {}; // inheritance
```

##### Types of Inheritance

| Type         | Definition                                                                                                             |
| ------------ | ---------------------------------------------------------------------------------------------------------------------- |
| single       | subclasses inherit the features of one superclass.                                                                     |
| multilevel   | a derived class will inherit an intermediate class along with a base class.                                            |
| hierarchical | one class serves as a superclass (base class) for more than one sub class.                                             |
| multiple     | one class can have more than one superclass and inherit features from all parent classes. **Java dose not have this!** |

### Wrapper Classes

Wrapper classes take a primitive datatypes and make objects out of them.

+ Float
+ Double
+ Character
+ Boolean
+ Integer
+ Short
+ Long
+ String

They also include type conversion methods.

+ `.toString()`
+ `.toInteger()`
+ `.toFloat()`

### Autoboxing

Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes

```java
Integer x1 = new Integer(10);
int x2 = 10;

x1 = x2; // the ability to assign a literal to a wrapper class.
```

### `super`

The `super` keyword refers to the parent. Adding `()`
is the equivalent of calling the parent's constructor.
You can access the parent's methods and  variable
(which should never be used - properties are private).


### NOTES

+ static methods - are shared methods - can be called without creating an object.
+ final methods - cannot be overridden by subclasses, they also allow for faster code when compiled with optimizations on 
+ instance methods - create an object to call instance methods.
+ instance (object) - data for an object (local or static)
+ unique memory location for each object, unique value for each object.
+ state of an object - for a given object printing values of all instance variables - object state.

---

# Algorithms

## `Math.sqrt`

```java
public class MyMath {
  // default accuracy
  public static double accuracy = 1E-6;

  public static int getLongLen(long n) {
    return ((int) (Math.log10(n))) + 1;
  }

  public static double sqrt(long n) {
    if (n < 0) return Double.NaN;
    if (n == 0) return 0.0;

    double lastGuess = 1;
    double nextGuess = (n / getLongLen(n) / 2) + 1;

    while (Math.abs(lastGuess - nextGuess) > accuracy) {
      lastGuess = nextGuess;
      nextGuess = (lastGuess + n / lastGuess) / 2;
    }

    return nextGuess;
  }
}
```

## Searching

#### Sequential Search

Array doesn't need to be sorted.

Loop though each index and test equality.

```java
static public int sequentialSearch(int[] array, int find) {
  for (int i = array.length - 1; i >= 0; i--) {
    if (array[i] == find) return i;
  }
  return -1;
}
```

#### Binary Search

First, you must assume an entire array is sorted.

Check if the center is greater, less than, or equal to the
number we are looking for.

| Sign          | What to do?                             |
| ------------- | --------------------------------------- |
| =             | return the index of the middle element  |
| find > middle | repeat with the right half of the array |
| find < middle | repeat with the left half of the array  |

```java
static public int binarySearch(int[] array, int find) {
  int low, mid, high;
  high = array.length - 1;
  low = 0;
  while (low <= high) {
    mid = (low + high) / 2;
    if (array[mid] < find)
      low = mid + 1;
    else if (array[mid] > find)
        high = mid - 1;
      else
        return mid;
    }

    return -1;
}
```

## Sorting

### Selection Sort

In every iteration of selection sort, the minimum
smallest element's value is swapped with the head
of the array.

```java
static public int[] selectionSort(int[] array) {
  int min_ind, len, temp;

  len = array.length;

  for (int loc = 0; loc < (len - 1); loc++) {
    min_ind = loc;
    for (int i = loc + 1; i < len; i++)
      if (array[i] < array[min_ind])
        min_ind = i;

    temp = array[loc];
    array[loc] = array[min_ind];
    array[min_ind] = temp;
  }
  return array;    
}
```

### Bubble Sort

This method transverses the array swapping elements,
repeating this behavior until no swaps are made in
a single iteration.

```java
static public int[] bubbleSort(int[] array) {
  int tail, temp;
  tail = array.length - 1;
  while (tail > 0) {
    for (int i = 0; i < tail; i++) {
      if (array[i] > array[i + 1]) {
        temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
      }
    }
    tail--;
  }
  return array;    
}
```

### Insertion Sort

This method takes elements and moves them as far to
the left by testing which is greater as possible
before resuming with the next element.

```java
static public int[] insertionSort(int[] array) {
  int len, temp, i, loc;

  len = array.length;

  for (loc = 1; loc < len; loc++) {
    i = loc;
    while  (i > 0 && array[i - 1] > array[i]) {
      temp = array[i - 1];
      array[i - 1] = array[i];
      array[i] = temp;
      i--;
    }
  }
  return array;
}
```

# Miscellaneous

### Counting Objects Created

In simple terms, count the number of `new` operators.
Arrays them selves are also counted as objects.

### Multidimensional Arrays

```java
int collegeScore[][][][] = new int[2][2000][50][8];
//1st - # of colleges - 2
//2nd - # of faculty - 2000
//3rd - avg num of students - 50
//4th - # of assignment - 8
collegeScore[0][0][0][0] = 10;
```

### When to use "this"?
`this` refers to instance variable - when local and instance variables are
named the same in overlapping scope then this is used to refer to instance
variable.

### Ragged Arrays

> An array of arrays with different lengths.

```java
int array[][] = new int[3][];
array[0] = new int[2];
array[1] = new int[1];
array[2] = new int[4];
```

### `null` Pointer Exception

```java
// assuming a class `Human` with a `setAge` method
Human cis35a[] = new Human[42];
cis35a[0].setAge(21); // null pointer exception
// FIX:
cis35a[0] = new Human();
cis35a[0].setAge(21);
```



### Debugger

> A tool that allows running the code step by step slowly in areas you
  think there might be issues

+ Insert a break point  - dbl click on left bar - across classes -
+ debug perspective - java perspective
+ step into (stepping into a function) and step over (jumps over a function)

### Example of Polymorphism

```java
class P { public void m() { } }
class C extends P { public void m() { } }

P a1 [] = new P[2];
a1[0] = new P();
a1[1] = new C();

for(int i = 0; i < a1.length; i++) a1[i].m(); //polymorphism.
```

### Can I override a static method?

It could conceptually be possible if you could call static methods from class
objects (like in languages like Smalltalk) but it's not the case in Java. You
can overload static method, that's ok. But you can not override a static method,
because class are no first-class object.

### How to crash the JVM

Constant pool has limited amount of memory, if it runs out of memory the JVM crashes.

```java
// assuming x{int} is a relatively long String
x1 = x2+x3+x1+x2+x3+x1+x2+x3+x1+x2+x3+x1+x2+x3+x1 ... x1+x2+x3+x1;
// The JVM would run out of memory trying to concatenate all the Strings
```

### Drawing Class Diagrams

### Acronyms

| Acronym | Expansion                                    |
| ------- | -------------------------------------------- |
| OOD     | Object Oriented Design                       |
| OOP     | Object Oriented Programming                  |
| Intel   | Machine Language                             |
| JVM     | Java Virtual Machine                         |
| JRE     | Java Runtime Environment                     |
| JNI     | Java Native Interface                        |
| JIT     | Just in time compiler (improves performance) |

<br>
<br>
<br>
<br>
<br>

### Vocabulary

| Term                       | Definition                                                                                                                                                                                                                                              |
| -------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Native                     | refers to matching the underlying architecture of hardware to the binary version of source code.                                                                                                                                                        |
| Classpath                  | set of directories where .class files live.                                                                                                                                                                                                             |
| Class Loader               | loads the class in memory. - creates a structure in memory (static memory) for the class for usage. - dynamic binding -                                                                                                                                 |
| Byte-code verifier         | portable instructions - verified.                                                                                                                                                                                                                       |
| Byte-code Interpreter      | converts .class -> native.                                                                                                                                                                                                                              |
| dimension                  | way of organizing data                                                                                                                                                                                                                                  |
| Exception                  | is a issue that occurs in runtime and is recoverable (for the most part).                                                                                                                                                                               |
| Debugger                   | a tool that allows running the code step by step slowly in areas you think there might be issues                                                                                                                                                        |
| Polymorphism               | can mean overloading or overriding. It is the ability of an object to take on many forms. When a parent class reference is used to refer to a child class object. Any Java object that can pass more than one IS-A test is considered to be polymorphic |
| Thread                     | a task                                                                                                                                                                                                                                                  |
| object state               | refers to all the attributes and their values at associated with an instance at a given point in time                                                                                                                                                   |
| overloading                | same method name - different signatures in same class or across parent / child.                                                                                                                                                                         |
| overriding                 | same method name and signature across parent and child.                                                                                                                                                                                                 |
| inheritance                | transferring the properties of parent to child                                                                                                                                                                                                          |
| Containment                | creating an instance of a class inside another class.                                                                                                                                                                                                   |
| Association                | passing objects by reference                                                                                                                                                                                                                            |
| encapsulation              | restricting access to properties via getter/setters                                                                                                                                                                                                     |
| overriding                 | same signature for method in parent and child                                                                                                                                                                                                           |
| immutable                  | an object whose state cannot be modified after it is created                                                                                                                                                                                            |
| instance                   | unique memory location for each object.                                                                                                                                                                                                                 |
| static                     | shared between instances of the same class (class variable) and class definition its self                                                                                                                                                               |
| `static` Methods/Variables | shared between objects - one memory location - when the value changes, applies to all objects. - cannot use instance variables static methods - are shared methods - can be called without creating an object. - loaded at the start of the program     |
| instance Methods/Variables | create an object to call instance methods -  unique memory location for each object, unique value for each object.                                                                                                                                      |
