package test.main;

import java.io.File;
import java.io.FileReader;

/*
 *   c:/acorn202210/myFolder/memo.txt 파일에 기록된 문자열을 읽어서
 *   콘솔창에 출력하기
 *   
 *   - hint
 *   FileReader 객체를 활용
 */

public class MainClass12 {
	public static void main(String[] args) {
		//파일 객체 생성
		File memoFile = new File("c:/acorn202210/myFolder/memo.txt");
		try {
			//파일에서 문자열을 읽어들일 수 있는 객체 생성
			FileReader fr = new FileReader(memoFile);
			//반복문 돌면서
			while(true) {
				//한글자 씩 읽어들인다.
				int code = fr.read();
				//더 읽을 문자가 없으면
				if(code == -1) {
					break; //반복문 종료
				}
				//코드값을 문자로 변환해서
				char ch = (char)code;
				//개행기호 없이 읽은 내용만 출력
				System.out.print(ch);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
}
