import java.util.Scanner;

public class CelToFahr {

	public static void main(String[] args) {
		
		/*
		 사용자에게 섭씨온도를 입력받아서
		 화씨온도로 변환하여 출력하는 로직을 작성하세요.
		 변환공식은 찾아서 적용해 주셔야 합니다.
		 화씨 온도는 소수점 첫째 자리까지 표현하세요.
		 # ㄹ 한자 7 (℃),  ㄹ 한자 다음장 4 -> (℉)
		 */
		
		//섭씨온도 * 1.8 + 32

		Scanner sc = new Scanner(System.in);
		
		System.out.print("섭씨 온도를 입력하세요(℃): " );
		int cel = sc.nextInt();
		
		double fahr = cel * 1.8 + 32;
		
		System.out.printf("입력한 섭씨: %d℃\n", cel);
		System.out.printf("변환된 화씨: %.1f℉\n", fahr);
		
		sc.close();
				
	}

}
