package test.main;

import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		//키보드로부터 입력받을 수 있는 기능을 가진 객체 생성
		Scanner scan = new Scanner(System.in); //system.in은 키보드와 연결
		System.out.print("문자열 한 줄 입력: ");
		//한 줄 입력받고
		String str = scan.nextLine();
		//입력받은 문자열을 콘솔에 출력
		System.out.println(str);
		//종료
		System.out.println("main 메소드가 종료 되었습니다.");
	}
}
