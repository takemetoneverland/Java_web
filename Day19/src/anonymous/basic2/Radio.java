package anonymous.basic2;

public class Radio {

	private int sound;
	private RemoteController remote;
	
	public Radio() { //Radio 객체에서만 동작할 수 있는 remote
		remote = new RemoteController() { //익명 객체 생성
			
			@Override
			public void volumeUp() {
				sound++;
				System.out.println("라디오의 볼륨: " + sound);
			}
			
			@Override
			public void volumeDown() {
				sound--;
				System.out.println("라디오의 볼륨: " + sound);
			}
			
			@Override
			public void turnOn() {
				System.out.println("라디오를 켭니다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("라디오를 끕니다.");
			}
		};
	}
	
	public RemoteController getRemote() {
		return remote;
	}
	
	public void setRemote(RemoteController remote) {
		this.remote = remote;
	}
	
}
