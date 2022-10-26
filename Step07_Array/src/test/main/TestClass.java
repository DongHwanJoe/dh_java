package test.main;
/*
 *  1. run 했을 때 
 *     cherry, apple, banana, melon, 7
 *     5개의 문자열 중에서 1개가 랜덤하게 출력되게 해보세요.
 *     
 *  2. run 했을 때
 *     5개의 문자열 중에서 3개가 한 줄에 한 번에 랜덤하게 출력되게 해보세요.
 *     예) cherry | apple | cherry
 *           7   | apple | melon
 *           7   |   7   |   7
 *  -hint
 *   String[] items = {cherry, apple, banana, melon, 7};
 *   Random ran = new Random();
 *   int ranNum = ran.nexint(5);
 */
import java.util.Random;

public class TestClass {
	public static void main(String[] args) {
		String[] items = {"cherry", "apple", "banana", "melon", "7"};
	
		Random ran = new Random();
		
		System.out.println("1번 문제");
		System.out.println(items[ran.nextInt(5)]);
		
		System.out.println();
		System.out.println("2번 문제");
		String[] results = new String[3];
		for(int i = 0; i < 3; i++) {
			int ranNum = ran.nextInt(5);
			results[i] = items[ranNum];
			if(i < 2) {
				System.out.print(results[i]+" | ");
			}else {
				System.out.println(results[i]);
			}
		}
		
		if(results[0] == results[1] && results[1] == results[2]) {
			if(results[0] == items[4]) {
				System.out.println("!!!!!Jackpot!!!!!");
			}else {
				System.out.println(results[0]+" Triple!!!!!");
			}
		}
	}
}
