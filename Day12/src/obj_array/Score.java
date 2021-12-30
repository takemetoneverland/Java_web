package obj_array;

import java.util.Scanner;

public class Score {
	
	/*
	 - 이름, 국어, 영어, 수학, 총점, 평균(double)을
	  담을 수 있는 객체를 디자인하세요.
	  
	 - 학생의 모든 정보를 한 눈에 확인할 수 있게
	  scoreInfo() 메서드를 선언해 주세요.
	  메서드 내부에는 출력문을 이용해서 모든 정보를 출력해 주세요.
	  
	 - 캡슐화를 구현해서 작성해 주세요. (생성자는 마음대로 하세요.)
	 */
	
	private String name;
	private int kor;
	private int eng; 
	private int math;
	private int total;
	private double avg;
	
	public Score() {} //기본 생성자

	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.avg = total / 3.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	void scoreInfo() {
		System.out.println("*** 학생의 정보 ***");
		System.out.println("# 이름: " + this.name);
		System.out.println("# 국어 점수: " + this.kor);
		System.out.println("# 영어 점수: " + this.eng);
		System.out.println("# 수학 점수: " + this.math);
		System.out.println("# 총점: " + this.total);
		System.out.println("# 평균: " + this.avg);
	}
	
	
}
