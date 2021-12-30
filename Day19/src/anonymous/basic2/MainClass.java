package anonymous.basic2;

public class MainClass {

	public static void main(String[] args) {

		Tv tv = new Tv(); //오버라이딩 된 메서드들. 내가 의도하지 않은 로직으로 작동할 수도 있음.
		tv.turnOn();
		tv.turnOff();
		tv.volumeUp();
		tv.volumeDown();
		
		///////////////////////////////////////////////////////////
		
		Radio radio = new Radio();
		radio.getRemote().turnOn(); //getRemote객체에 접근 권한 부여 가능.
		radio.getRemote().turnOff();
		radio.getRemote().volumeUp();
		radio.getRemote().volumeUp();
		
	}

}



















