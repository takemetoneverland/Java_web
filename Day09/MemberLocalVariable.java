
/*
 # 멤버 변수(field, class member variable)
 1. 클래스 블록에 선언된 변수를 의미합니다. (설계도에 작성된 변수)
 2. 메모리의 heap 영역에 저장되며, 값을 초기화하지 않아도
  각 데이터타입의 기본값으로 자동 초기화됩니다.
 3. 객체를 가르키고 있는 레퍼런스변수(참조변수)가 사라지거나
 주소값을 잃어버리게 되면, 메모리에서 가비지 컬렉터(gc)에 의해
 자동으로 제거됩니다. (메모리의 효율성을 위해)
 
 # 지역 변수 (local variable) //객체 배우기 전에 선언했던 모든 변수들은 지역 변수.
 1. 메서드나 생성자 블록 내부에서 선언된 변수를 의미합니다.
 2. 메모리의 stack영역에 저장되며, 선언된 블록을 벗어나면
  메모리에서 자동으로 소멸됩니다.
 3. 값을 초기화하지 않으면 변수를 사용할 수 없습니다.
 */

public class MemberLocalVariable {

	int a; //멤버 변수 : 값을 초기화하지 않아도 자동으로 초기화(기본값) 됨.

	void printNumber(int c) { //매개 변수(지역변수)
		int b = 1; //(메서드 내부에 있는) 지역변수 : 값을 초기화하지 않으면 사용할 수 없다.
		System.out.println("멤버변수: " + a);
		System.out.println("지역변수: " + b);
		System.out.println("매개변수: " + c);
	}
	
	public static void main(String[] args) {

		MemberLocalVariable m = new MemberLocalVariable(); //객체 생성
		m.printNumber(4);
	}

}












