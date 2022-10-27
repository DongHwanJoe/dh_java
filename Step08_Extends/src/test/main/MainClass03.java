package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass03 {
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 그 참조값을 p1이라는 이름의 HandPhone type 지역변수에 대입하기
		HandPhone p1 = new HandPhone();
		
		//p1안에 있는 참조값을 p2라는 Phone type 지역변수에 대입하기
		Phone p2 = p1;
		
		//p1안에 있는 참조값을 p3라는 Object type 지역변수에 대입하기
		Object p3 = p1;
		//자식 객체의 참조값은 부모 type변수나 필드에 자연스럽게 담긴다.
		//부모 type으로 생성한 객체는 부모클래스의 필드와 메소드만 사용 가능
		//하지만 오버라이드 한 메소드의 경우 부모type으로 선언해도 자식클래스에서 오버라이드 한 메소드로 실행됨
	}
}
