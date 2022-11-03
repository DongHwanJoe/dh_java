package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
 *   c:/acorn202210/myFolder/memo.txt 파일에 기록된 문자열을 읽어서
 *   콘솔창에 출력하기
 *   
 *   - hint
 *   FileReader 객체를 활용
 */

public class MainClass13 {
	public static void main(String[] args) {
		//파일 객체 생성
		File memoFile = new File("c:/acorn202210/myFolder/memo.txt");
		
		try {
			//파일에서 문자열을 읽어들일 수 있는 객체 생성
			FileReader fr = new FileReader(memoFile);
			BufferedReader br = new BufferedReader(fr);
			//반복문 돌면서
			while(true) {
				//개행 기호를 기준으로 한 줄씩 읽어오기 때문에 개행기호는 읽어오지 않는다.
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
}
