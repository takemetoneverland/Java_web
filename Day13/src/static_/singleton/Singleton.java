package static_.singleton;

public class Singleton {

	/*
	 # 싱글톤 디자인 패턴: 클래스의 객체를 단 1개로 제한하기 위한 코드 디자인 패턴.
	 
	 1. 외부에서 이 클래스의 객체를 생성하지 못하게 생성자를 단 한개만
	  선언한 후에 private 접근 제한을 붙임.
	 */
	
	private Singleton() {
		System.out.println("객체가 생성됨!");
	}
	
	//2. 생성자를 호출할 수 있는 영역은 같은 클래스 내부 뿐이므로
	//자신의 클래스 내부에서 스스로의 객체를 단 1개만 생성한다.
	private static Singleton s = new Singleton();

	//3. 외부에서 이 클래스의 객체를 요구할 시, 2번에서 미리 만들어 놓은
	//단 하나의 객체의 주소값을 공개된 메서드를 통해서 리턴한다.
	public static Singleton getInstance() {
		return s;
	}
	//////////////////////////////////////////////////
	
	public void method1() {
		System.out.println("여러 군데에서 쓰이는 중요한 메서드");
	}
	
	public void method2() {
		System.out.println("꼭 사용해야 하는 아주 중요한 메서드");
	}
	
}
