package exception.quiz;

import exception.myexception.DivideException;

public class AccountMain {

	public static void main(String[] args) {

		Account acc = null;

		try {
			acc = new Account(1000);
			acc.deposit(200);
			acc.withDraw(500);
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		System.out.println("계좌 잔액: " + acc.getBalance());
		
	}

}
