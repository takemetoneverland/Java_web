package generic.basic;

public class Box<T> { //제네릭 클래스로 선언. 글자 아무거나 써도 되는데 대문자로 쓰는 것이 관례이다.
	
	private T t;

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

}
