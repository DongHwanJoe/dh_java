package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * 현재 존재하거나 혹은 존재하지 않는 파일이나 폴더를 제어 할 수 있는 File 객체를 생성해서
		 * 참조값을 f라는 지역 변수에 담기
		 */
		File f = new File("c:/acorn202210/myFolder/memo.txt");
		
		// 실제 memo.txt 파일이 존재하지 않으면 파일을 만들고
		// 존재하면 memo.txt 파일을 삭제하도록 프로그래밍 하기
		
		try {
			if(f.exists()) {
				f.delete();
			}else {
				f.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
