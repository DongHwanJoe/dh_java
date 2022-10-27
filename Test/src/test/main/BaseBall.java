package test.main;

import java.util.Random;

public class BaseBall {
	public static void main(String[] args) {
		int[] answer = new int[3];
		
		Random ran = new Random();
		
		for(int i = 0; i < answer.length; i++) {
			int ranNum = ran.nextInt(10);
			answer[i] = ranNum;
			for(int j = 0; j < i; j++) {
				if(answer[i] == answer[j]) {
					--i;
					return;
				}
			}
			System.out.println(answer[i]);
		}
		
	}
}
