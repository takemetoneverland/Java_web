
public class Person {

	String name;
	int age;
	int tall;
	
	Person() {} //기본 생성자.

	Person(String pName, int pAge, int pTall) {
		name = pName;
		age = pAge;
		tall = pTall;
	}
	
	
	void info() {
		System.out.println(name);
		System.out.println(age + "세");
		System.out.println("키: " + tall + "cm");
	}
	
}
