package inter.good;

public class Update implements IUserService {

	@Override
	public void execute() {
		System.out.println("수정 정보를 입력받아서 데이터베이스 수정 조치...");
	}

}
