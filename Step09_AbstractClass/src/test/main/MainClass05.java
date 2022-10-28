package test.main;

import java.util.Scanner;

import test.mypac.Weapon;

public class MainClass05 {
	//필드를 선언하면서 값 얻어내서 대입하는 코드
	int num = 999;
	String name = "Kim";
	Scanner scan = new Scanner(System.in);
	//필드는 선언만 하면 기본값이 들어간다.
	int weight; //0
	boolean isRun; //false
	String msg; //null
	Scanner scan2; //null
	//static 영역에 올리고 싶은 필드는 static 예약어를 이용해서 만든다.
	static String greet = "Hello";
	
	//이름이 없는 익명의 클래스(Anonymous inner Class)를 new Weapon() 으로 호출
	static Weapon w1 = new Weapon() {
		@Override
		public void attack() {
			System.out.println("걍 다 죽여");
		}
		
	};
	
	public static void main(String[] args) {
		useWeapon(w1);
		//Anonymous Local inner Class를 이용해서 Weapon type의 참조값 얻어내기
		Weapon w2 = new Weapon() {
			@Override
			public void attack() {
				System.out.println("빡구야 내가 잘못했어");
			}
		};
		useWeapon(w2);
		
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("이제 그만좀 때려");
			}
		});
		
	}
	
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
