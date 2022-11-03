package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainClass14 {
	public static void main(String[] args) {
		//파일 객체 생성
		File memoFile = new File("c:/acorn202210/myFolder/memo.txt");
		
		//필요한 객체를 담을 지역 변수를 미리 만들어준다.
		FileReader fr = null;
		BufferedReader br = null;
		try {
			//미리 만들어둔 지역 변수에 참조값 대입하기
			fr = new FileReader(memoFile);
			br = new BufferedReader(fr);
			//반복문 돌면서
			while(true) {
				//개행 기호를 기준으로 한 줄씩 읽어오기 때문에 개행기호는 읽어오지 않는다.
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//마무리 작업
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}catch(Exception e) {}
			
		}
	}
}
