
public class Account {

	String name;
	int password;
	int balance;
	
	Account() {}
	
	Account(String aName, int aPassword, int aBalance) {
		name = aName;
		password = aPassword;
		balance = aBalance;
	}

	void deposit(int money) { //입금
		if(money <= 0) {
			System.out.println("입금액은 0원 이상이어야 합니다.");
			return;
		}
		balance += money;
	}
	
	void withDrwa(int money, int pw) { //출금
		if(pw == password) {
			if(money > balance) {
				System.out.println("잔액이 부족합니다.");
			}
			balance -= money;
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
	
	int getbalance() { //잔액조회
		return balance;
	}
	
}
