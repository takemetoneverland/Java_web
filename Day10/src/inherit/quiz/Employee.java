package inherit.quiz;

public class Employee extends Person {

	String depart;

	@Override
	String info() {
		return super.info() + ", 부서: " + depart;
	}

	
	
}
