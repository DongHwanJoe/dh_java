package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		//인터페이스도 data type 역할이 가능하다.
		Remocon r1 = null;
		
		//Remocon r2 = new Remocon(); //인터페이스 단독으로 객체 생성 불가(생성자 없음)
		
		Remocon r2 = new MyRemocon();
		r2.up();
		r2.down();
		//인터페이스의 필드 참조 (static final)
		String result = Remocon.COMPANY;

	}
}
