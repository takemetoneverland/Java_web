
public class Bread {

	int price;
	String name;
	String ingredient;
	
	void info() {
		System.out.println("*** 빵 정보 ***");
		System.out.println("빵 이름: " + name);
		System.out.println("빵 가격: " + price + "원");
		System.out.println("주 재료: " + ingredient);
	}
	

	//Bread() {} 기본생성자 만들기
	
	//생성자 선언
	Bread() {
		name = "피자빵";
		price = 500;
		ingredient = "밀가루";
	}
	
	//생성자 오버로딩
	Bread(String bName) {
		name = bName;
		price = 1500;
		ingredient = "초콜렛";
		
	}
	
}
