package lambda.basic;

interface Calculator {
	int add(int n1, int n2);
}

public class MainClass {

	public static void main(String[] args) {

		Person p = new Person();
		
		p.greet(new Say01() { //람다식 없을 때 기존 익명 객체 사용 방법.
			
			@Override
			public void talking() {
				System.out.println("안녕하세요~");
			}
		});
		
		p.greet(new Say02() {
			
			@Override
			public String talking() {
				System.out.println("Hello");
				return "Hello";
			}
		});
		
		p.greet(new Say03() {
			
			@Override
			public String talking(String greet) {
				System.out.println(greet);
				return greet;
			}
		});
		
		System.out.println("---------------------------------------------");
		
		/*
		 # 익명객체 Say01이 구현해야 할 추상메서드를 람다식으로 표현.
		 
		 greet메서드의 매개변수의 타입 Say01 인터페이스는
		 추상메서드가 단 하나이기 때문에 이름을 명시하지 않아도
		 해당 추상메서드가 지목된다.
		 () 안에는 매개변수에 전달하고 싶은 값을 주고
		 -> {}안에는 오버라이딩 하는 메서드의 실행 내용을 적는다.
		 */
		
		p.greet(() -> {
			System.out.println("안녕하세요~");
		});
		
		p.greet((greet) -> {
			System.out.println(greet);
			return greet;
		});
		
		/*
		 Say04 인터페이스를 매개값으로 받은 greet()를
		 호출해보세요.
		 전달받은 문자열 매개변수를 전달받은 int의 값만큼 반복한 결과를
		 리턴하는 함수를 람다식으로 선언해 보세요.
		 */
		
		String str = p.greet((word, i) -> {
			String result ="";
			for(int j=0; j<=i; j++) {
				result += word;
			}
			return result;
		});
		
		System.out.println(str); //람다식 밑에 기존에 썼던 익명 객체 방식 작성해서 비교해보기.
		
		System.out.println("--------------------------------------");
		
		//계산기 인터페이스와 람다식
		Calculator sharp = new Calculator() { //람다식 사용하지 않은 익명 객체 문법
			
			@Override
			public int add(int n1, int n2) {
				System.out.println("샤프 계산기의 덧셈!");
				return n1 + n2;
			}
		};
		
		System.out.println(sharp.add(10, 15));
	
		Calculator casio = (x, y) -> {
			System.out.println("카시오 계산기의 덧셈!");
			return x + y; //메서드의 호출부로 리턴
		};
		
		System.out.println(casio.add(10, 15));
		
		//만약 오버라이딩하는 추상메서드에 작성할 코드가 한 줄이라면
		//괄호 생략이 가능하다.
		
		Calculator xiaomi = (x, y) -> x + y;

		System.out.println(xiaomi.add(30, 50));
		
	}

}











