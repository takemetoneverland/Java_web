package user;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	//회원의 정보를 담아놓을 리스트 (DB 대용)
	private static List<User> userList = new ArrayList<>();

	//생성된 User 객체를 리스트에 추가하는 메서드
	public static void save(User user) {
		userList.add(user);
	}

	//회원 정보 저장 후 리스트 내부를 보여주는 메서드.
	public static void showUsers() {
		System.out.println("### 회원 정보 ###");

		for(User user : userList) {
			System.out.println("아이디: " + user.getAccount());
			System.out.println("비밀번호: " + user.getPassword());
			System.out.println("이름: " + user.getName());
			System.out.println("별명: " + user.getNickName());
			System.out.println("===============================");
		}
	}

	//매개값으로 id를 받아서 해당 id를 가진 객체가 userlist에 있는 지 탐색하는 메서드
	/*
	 2. 로그인을 시도하는 회원의 모든 정보를 얻어오세요. (getUser())
    getUser() -> 아이디를 전달받아 해당 아이디와 일치하는 객체가 있는지
    확인 후, 있다면 그 객체를 리턴.
    일치하는 객체가 없다면 null을 리턴.
	 */
	public static User getUser(String id) {
		for(User user : userList) {
			if(user.getAccount().equals(id)) {
				return user;
			}
		}
		return null; //모든 메서드는 return 값이 있어야 함.
	}

	/*
	 3. 
    회원탈퇴는 deleteUser(???)라는 이름으로 UserRepository에 메서드 선언.
    리스트에서 해당 아이디에 부합하는 User객체를 찾은 후 리스트 문법으로 해당 객체의
    주소값을 지워주시면 됩니다.
    그리고 세션 데이터도 삭제해 주세요.
	 */
	
	// 매개값으로 id를 받아서 해당 id를 가진 객체를 userList에서 삭제하는 메서드
	public static void deleteUser(String id) {
//		for(User user : userList) {
//			if(user.getAccount().equals(id)) {
//				userList.remove(user);
//				return;
//			}		
//		}
		
		userList.remove(getUser(id));

	}

}
