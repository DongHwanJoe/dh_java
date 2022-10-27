package test.main;

import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass06 {
	public static void main(String[] args) {
		
		//HandPhone type으로 객체 생성(인터넷 메소드 사용불가능)
		HandPhone p1 = new HandPhone();
		
		//인터넷 메소드를 사용하기위해 캐스팅
		
		//type을 SmartPhone 으로 캐스팅
		SmartPhone p2 = (SmartPhone)p1; 
		
		p2.doInternet(); // ClassCastException 발생
	}
}
