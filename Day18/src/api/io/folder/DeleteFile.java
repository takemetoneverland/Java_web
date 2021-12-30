package api.io.folder;

import java.io.File;

public class DeleteFile {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\D\\Desktop\\Java_Web_JDE\\file\\folder_test");
		
		if(file.exists()) {
			file.delete(); //delete 성공 시 true, 실패 시 false를 리턴한다.
			System.out.println("파일 삭제 성공!");
		} else {
			System.out.println("파일 삭제 실패 or 존재하지 않음!");
		}
		
	}

}
