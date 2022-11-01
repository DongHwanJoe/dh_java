package test.main;
/*
 *  while 문을 활용해서 원하는 횟수만큼 반복하기
 *  
 *  - 반복 횟수가 명확히 정해져 있으먄 for문이 유리
 *  - 반복 횟수가 명확히 정해지지 않은 경우 while문이 유리
 */
public class MainClass08 {
	public static void main(String[] args) {
		//카운트를 셀 변수를 미리 만들어서 0으로 초기화
		int count = 0;
		//무한 루프 돌다가
		while(true) {
			System.out.println("Oh, Hi!");
			count++;
			//특정 조건에서 무한루프 빠져나오기
			if(count == 5) {
				break;
			}
		}
		
		System.out.println("-----");
		count = 0; //count를 0으로 초기화
		
		while(count < 5) {
			System.out.println("Oh, Hi!");
			count++;
		}
	}
}
