# Java Midterm :­ Summer 2012

### Question 1:

Complete statements (1) and (2), and answer questions (3) and (4):

1. An object is an instance of a
2. The collection of an object's instance variables is known as its
3. In Java, objects are created with what operator?
4. In Java, a class may have instance variables and methods.
   It may also have named blocks of code, at most one of which is executed when
   an object is created. What are these named blocks of code called?

### Question 2:

A TangoDancer has a name and may have a partner who is also a TangoDancer. If
TangoDancer A chooses TangoDancer B to be a partner, the operation succeeds if
neither A nor B already has a partner, and A is not B. On the next page, write
the choosePartner method and additional methods as desired so that the
following DrJava interactions work:

`> TangoDancer rita = new TangoDancer("senorita rita");`

```
> TangoDancer tony = new TangoDancer("mr tony");
> rita.getName()
"senorita rita"
> rita.hasAPartner()
false
> tony.hasAPartner()
false
> rita.choosePartner(tony)
true
> rita.hasAPartner()
true
> rita.getPartner().getName()
"mr tony"
> tony.hasAPartner()
true
> tony.getPartner().getName()
"senorita rita"
> tony.choosePartner(rita)
false
> TangoDancer elana = new TangoDancer("ms elana");
> elana.choosePartner(elana)
false
```

### Question 3

For each code segment below, determine how many times the body of the loop is executed. Write one of the following answers after each: 0, 1, infinite, or > 1. Note that "> 1" means more than once but not infinite.

1.  ```java
    for(int x=1; x<10; x++){
      System.out.println(x);
    }
    ```
2.  ```java
    int x = 1;
    while(x < 10){
      System.out.println(x);
    }
    ```
3.  ```java
    int x = 1;
    do{
      x = x * 2;
    } while(x >= 8);
    ```
4.  ```java
    int x = 10;
    while(x < 10){
      System.out.println(x);
      x = x­ - 1;
    }
    ```
5.  ```java
    int x = 1;
    while(x! = 10){
      x = x * 2;
    }
    ```

### Question 4

Complete the method sum that takes two arrays of integers as
arguments. It returns null if either argument is null or if the
arrays are not the same length. Otherwise it returns a new array,
each of whose elements equals the sum of the corresponding
elements in the input arrays. The input arrays should not be
changed by the method.

### Question 5

Assuming that the following classes have been defined:

```java
public class A {
  public static void method1() {
    System.out.println("C1");
  }
}

public class B extends A {
  public static void method2() {
    System.out.println("A2");
  }
}

public class C extends B {
  public static void method1() {
    System.out.println("B3");
  }
}
```

In the table below, indicate in the right­hand column the output
produced by the statement in the left­hand column. If the
statement causes an error, fill in the right­hand column with
either the phrase "compiler error" or "runtime error" to
indicate when the error would be detected.

| Statement        | Output             |
| ---------------- | ------------------ |
| `B b = new B();` | __________________ |
| `A a = new B();` | __________________ |
| `B c = new C();` | __________________ |
| `a.method1();`   | __________________ |
| `b.method21();`  | __________________ |
| `b.method1();`   | __________________ |
| `c.method2();`   | __________________ |
| `c.method11();`  | __________________ |
| `a.method2();`   | __________________ |

### Question 6

For each of the following program fragments, what is the value of
the variable x after the statements execute? Treat each
expressions as separate code block.

1.  ```java
    int y = 10;
    int x = y;
    y = x * 3;
    ```
2.  ```java
    int x = 10;
    x = x / 2;
    x = x + 3 * x - ­3;
    ```
3.  ```java
    double x = 7 / 2;
    ```
4. ```java
    boolean x = ( 2 < 3 ) || (5 < 4);
    ```

### Question 7

Write a class that accepts an ordinary number and outputs
its equivalent Roman numeral. The ordinary numbers and their
equivalent Roman Numerals are given below:

| Numbers | Roman Numeral |
| ------- | ------------- |
| 1       | I             |
| 5       | V             |
| 10      | X             |
| 50      | L             |
| 100     | C             |
| 500     | D             |
| 1000    | M             |

Your class should declare properties and methods to handle
conversion of an ordinary number to roman numerals. It
does not have to handle input and output methods.

### Question 8

Write a function to compute the square root of a number to a precision of 4.
