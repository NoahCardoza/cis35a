# Question 1

1. ​class
2. state
3. new
4. constructors

# Question 2

```java
public class TangoDancer { private String name;
  // Properties
  private String name;
  private TangoDancer partner;

  // Constructor
  public TangoDancer(String name){
    this.name = name;
    partner = null;
  }

  // Methods
  public boolean hasAPartner() { return partner != null; }
  public boolean choosePartner(TangoDancer other){
    if (other == this) return false;
    if (partner != null) return false;
    if (other.hasAPartner()) return false;
    partner = other; other.setPartner(this);
    return true;
  }

  // Getters
  public String getName() {
    return name;
  }
  public TangoDancer getPartner() {
    return partner;
  }

  // Setters
  void setPartner(TangoDancer chooser){
    partner = chooser;
  }
}
```

# Question 3

1. >1
2. infinite
3. 1
4. 0
5. infinite

# Question 4

```java
class Summation {
  public static int[] sum(int[] one, int[] two) {
    if (one == null || two == null) return null;

    if (one.length != two.length) return null;

    int[] result = new int[one.length];

    for (int i = 0; i < one.length; i++)
      result[i] = one[i] + two[i];
    return result;
  }
}
```

# Question 5

| Statement        | Output    |
| ---------------- | --------- |
| `B b = new B();` | No Output |
| `A a = new B();` | No Output |
| `B c = new C();` | No Output |
| `a.method1();`   | C1        |
| `b.method21();`  | Error     |
| `b.method1();`   | C1        |
| `c.method2();`   | A2        |
| `c.method11();`  | Error     |
| `a.method2();`   | Error     |

# Question 6

1. `10`
2. `17`
3. `3.0`
4. `true`

# Question 7

```java
class Decimal {
  int decimalNo [] = {1000, 500, 100, 50, 10, 5, 1};
  String romanNo[] = {"M", "D", "C", "L", "X", "V", "I"};
  int decimalInp;

  Decimal(int decimalInp) {
    this.decimalInp = decimalInp;
  }

  public String convertDecimal() {
    String roman = "";
    for (int i = 0; i < romanNo.length; i++) {
      while (this.decimalInp >= decimalNo[i]) {
        this.decimalInp ­= decimalNo[i];
        roman +=romanNo[i];
      }
    }
    System.out.println("Decimal Input: " + this.decimalInp);
    System.out.println("Roman Output: " + roman); return roman;
  }
}

class Driver {
  public static void main (String[] args) {
    Decimal decimal = new Decimal(1456); decimal.convertDecimal();
  }
}
```

# Question 8

```java
public class NewtonsSquareRoot {
  private static final double EPSILON = .00001;
  private int myNumber;
  private double root;
  private double guess;

  public NewtonsSquareRoot(int number){
    myNumber = number;
  }

  public int getNumber(){
    return myNumber;
  }

  public double findSquareRoot(){
    guess = 1;
    root = Math.sqrt(myNumber);
    while (EPSILON < Math.abs(Math.pow(root, 2) ­ myNumber)) {
      guess++;
    }
    return root;
  }
  public void setNumber(int number){
    myNumber = number;
  }

  public String toString(){
    return "The square root of " + myNumber + " is " + root + ".";
  }
}
```
