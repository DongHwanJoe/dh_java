package test.main;

import test.mypac.Chainsaw;
import test.mypac.Weapon;

public class MainClass02 {
	
	public static void main(String[] args) {
		test("Hello"); //동일 클래스 안에서 사용 시 MainClass02.test(); 에서 앞부분을 생략 가능
		
		//여러분이 직접 클래스를 만들고 객체 생성해서 아래의 useWeapon() 메소드를 호출해보세요.
		useWeapon(new Chainsaw());
	}
	
	public static void test(String msg) {
		System.out.println(msg);
	}
	
	//Weapon type을 인자로 전달 받아서 사용하는 static 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
