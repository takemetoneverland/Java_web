import java.util.Scanner;

public class MethodQuiz03 {

	static int calcGcd(int n1, int n2) {
		
		//n1이 크다고 가정했기때문에, 만약 n2가 더 크다면 값을 서로 바꿔주는 if문.
		if(n1 < n2) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		
		/*
		while(n2 > 0) { //n2 == 0이 되면 false (나머지가 0이되면 끝나는 반복문)
			int temp = n1;
			n1 = n2;
			n2 = temp % n2;
		}
		return n1;
		*/
		
		while(n1 % n2 != 0) {
			int temp = n1 % n2;
			n1 = n2;
			n2 = temp;
		}
		return n2;
	}
		
	public static void main(String[] args) {

		/*
		 - 정수 2개를 입력받아서(main)
		  두 숫자의 최대 공약수를 구해주는 메서드
		  calcGCD()를 선언하세요.
		 - 최대공약수: 두 숫자의 공통된 약수 중 가장 큰 약수
		 ex) 12, 18의 최대공약수 -> 6

		 # 임의의 두 자연수 a, b가 주어졌을 때, 둘 중 큰 값이 a라고 가정.
		 a를 b로 나눈 나머지를 n이라고 했을 때 (a % b -> n)
		 n이 0이 된다면 b가 최대 공약수이다.
		 
		 # 만약 n이 0이 아니라면 (안 나누어 떨어진다면)
		 a의 자리에 b값을 다시 넣고
		 b의 자리에 n의 값을 대입한 후에 위의 행동을 반복.
		 */
	
		Scanner sc =  new Scanner(System.in);
		
		System.out.print("정수1: ");
		int num1 = sc.nextInt();
		System.out.print("정수2: ");
		int num2 = sc.nextInt();
		
		System.out.printf("%d와 %d의 최대공약수 : %d\n"
				, num1, num2, calcGcd(num1, num2));

		sc.close();
	
	}

}
