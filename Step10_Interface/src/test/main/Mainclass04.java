package test.main;

import test.mypac.Drill;

public class Mainclass04 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 뚫어요");
			}
		});
		
		//인터페이스에서 오버라이드 할 메소드가 하나일 경우 줄여서 사용 가능
		useDrill(()->{
			System.out.println("천장에 구멍을 뚫어요");
		});
		
	}
	
	public static void useDrill(Drill d) {
		d.hole();
	}
}
