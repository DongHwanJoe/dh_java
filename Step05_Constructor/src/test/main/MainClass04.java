package test.main;

import java.util.Random;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 *  0~9 사이의 랜덤한 정수를 얻어내서 콘솔창에 출력하고 싶다.
		 *  
		 *  hint) Random 클래스를 import 해서 사용해 보세요.
		 */
		
		Random ran = new Random();
		
		System.out.println(ran.nextInt(10));
		
		// 1~45 사이의 랜덤한 정수 하나를 얻어내서 ranNum2 라는 지역변수에 담아보세요.
		int ranNum2 = ran.nextInt(1, 46);
		System.out.println(ranNum2);
		//true or false 중에 랜덤한 boolean 값을 얻어내서 isRun 이라는 지역변수에 담아보세요.
		boolean isRun = ran.nextBoolean();
		System.out.println(isRun);
	}
}
