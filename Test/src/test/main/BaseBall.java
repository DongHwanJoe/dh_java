package test.main;

import java.util.Random;
import java.util.Scanner;

public class BaseBall {
	public static void main(String[] args) {
		int[] answer = new int[3];
		int[] myAnswer = new int[3];
		int totalTry = 0;
				
		makeAnswer(answer, 0);

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		System.out.print("희망 시도 횟수 입력: ");
		int tryNum = scan.nextInt();
		
		while(true) {
			++totalTry;
			--tryNum;
			System.out.print("숫자 입력: ");
			String str = scan2.nextLine();
			
			for(int i = 0; i < myAnswer.length; i++) {
				myAnswer[i] = str.charAt(i) - '0';
			}
			
			if(checkAnswer(answer, myAnswer) == true) {
				System.out.println("총시도 횟수 : "+ totalTry+ "회");
				break;
			}
			if(tryNum == 0) {
				System.out.print("Game Over -정답 : ");
				for(int i = 0; i < answer.length; i++) {
					System.out.print(answer[i]);
				}
				break;
			}
		}
	}
	
	public static int[] makeAnswer (int[] a, int n) {
		if(n == a.length) {
			return a;
		}
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1, 10);
		boolean chk = false;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] == ranNum) {
				chk = true;
				return makeAnswer(a, n);
			}
		}
		if(!chk) {
			a[n] = ranNum;
			return makeAnswer(a, n+1);
		}
	
		return a;
	}
	
	public static boolean checkAnswer(int[] a, int[] b) {
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
			System.out.println(strike+"strike, "+ball+"ball");
		}
		
		return (strike == 3);
	}
}