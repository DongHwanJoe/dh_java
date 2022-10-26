package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		// 0으로 초기화된 방 3개짜리 int[] 객체를 만들어서 참조값을 지역변수 nums에 담기
		int[] nums = {0, 0, 0};
		// 0번방에 10, 1번방에 20, 2번방에 30을 저장해 보세요.
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		// 0으로 초기화된 방 100개짜리 int[] 객체를 만들어서 참조값을 지역변수 nums2에 담기
		int[] nums2 = new int[100];
		nums2[0] = 100;
		nums2[1] = 200;
		nums2[2] = 300;
		nums2[100] = 400; //에러나서 아래문구 콘솔 출력 불가
		
		System.out.println("main 메소드가 정상 종료 됩니다.");
	}
}
