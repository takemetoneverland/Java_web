package inherit.quiz;

public class Student extends Person {
	
	String stuId;

	@Override
	String info() {
		return super.info() + ", 학번: " + stuId;
	}

	
	

}
