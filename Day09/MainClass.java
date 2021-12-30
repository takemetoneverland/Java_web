
public class MainClass {
	
	public static void main(String[] args) {

		/*
		 - 객체를 생성하지 않았을 때의 에시를 보고
		  빵 객체를 생성할 수 있는 클래스(설계도)를 작성해 보세요.
		  클래스 이름은 Bread로 통일하겠습니다.
		  
		 - MainClass에서 똑같이 피자빵, 초코케이크의 정보를
		  호출해 보세요. (생성자는 마음대로 작성)
		 */
		
		Bread b1 = new Bread();
		b1.info();
		
		System.out.println("----------------------------");
		
		Bread b2 = new Bread("초코케이크");
		b2.info();
		
	}

}
