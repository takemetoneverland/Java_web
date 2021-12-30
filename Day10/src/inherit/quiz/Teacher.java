package inherit.quiz;

public class Teacher extends Person {
	
	String sub;

	@Override
	String info() {
		return super.info() + ", 담당과목: " + sub;
	}
	

}
