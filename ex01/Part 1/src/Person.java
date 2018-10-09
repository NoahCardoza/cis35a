// I thought I'd add some validation to getters for fun.

public class Person {
	private String name = "";
	private String address = "";
	private String phoneNumber = "";
	private int age = 0;

	Person() {}
	
	Person(String name, int age, String phoneNumber, String address) {
		this.setName(name);
		this.setAge(age);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
	}
	
	// Filters out all non-numeric characters 
	private static String filterInt(String s) {
		return s.codePoints().filter(Character::isDigit)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}
	
	public String print() {
		return String.format("Person<name=\"%s\", age=%d, phoneNumber=\"%s\", address=\"%s\">", this.name, this.age, this.phoneNumber, this.address);
	}

	public String getName() {
		return this.name;
	}

	public Person setName(String value) throws java.lang.RuntimeException {
		if (value.length() == 0) {
			throw new java.lang.RuntimeException("A name must be at least one character long");
		}
		this.name = value;
		return this;
	}

	public String getAddress() {
		return this.address;
	}

	public Person setAddress(String value) {
		this.address = value;
		return this;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public Person setPhoneNumber(String value) throws java.lang.RuntimeException {
		String cleanedPhoneNumber = String.valueOf(filterInt(value));
		// https://stackoverflow.com/questions/14894899/what-is-the-minimum-length-of-a-valid-international-phone-number
		if (5 > cleanedPhoneNumber.length() || cleanedPhoneNumber.length() > 15) {
			throw new java.lang.RuntimeException(value + " is an invalid phone number");
		}
		this.phoneNumber = cleanedPhoneNumber;
		return this;
	}

	public int getAge() {
		return this.age;
	}

	public Person setAge(int value) throws java.lang.RuntimeException {
		if (value <= 0) {
			throw new java.lang.RuntimeException("Age must be an integer greater than 0");
		}
		this.age = value;
		return this;
	}

}
