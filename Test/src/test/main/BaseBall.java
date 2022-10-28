package test.main;

import java.util.Random;
import java.util.Scanner;

public class BaseBall {
	public static void main(String[] args) {
		int[] answer = new int[3];
		int[] myAnswer = new int[3];
		
		answer[0] = 3;
		answer[1] = 2;
		answer[2] = 8;				
		
		Scanner scan = new Scanner(System.in);
		
		//while(true) {
			//System.out.print("숫자 입력: ");
			//String str = scan.nextLine();
			
			//for(int i = 0; i < myAnswer.length; i++) {
			//	myAnswer[i] = str.charAt(i) - '0';
			//}
			
			//ac(answer, myAnswer);
			
		//}
	}
	
	public static void ac(int[] a, int[] b) {
		int ball = 0;
		int strike = 0;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				if(a[i] == b[j] && j == i) {
					strike++;
				}else if(a[i] == b[j] && j != i) {
					ball++;
				}
			}
		}
		
		if(strike == 3) {
			System.out.println("correct");
		}else {
			System.out.println(ball+"ball, "+strike+"strike");
		}
	}
}





















