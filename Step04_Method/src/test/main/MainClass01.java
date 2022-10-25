package test.main;

import test.mypac.Car;
import test.mypac.MyObject;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * MyObject 객체를 하나만 생성해서 그 객체가 가지고 있는
		 * walk(), getNumber(), getGreeting() 메소드를 차례로 호출해보세요.
		 * 단, 메소드가 어떤 data를 리턴하면 해당 데이터를 지역변수에 담으세요.
		 */
		
		MyObject ob = new MyObject();
		ob.walk();
		int num = ob.getNumber();
		String str = ob.getGreeting();
		Car car = ob.getCar();
		// setNum(), setName(), useCar() 메소드도 호출해보세요.
		
		//메소드 호출하면서 인자로 전달할 데이터를 즉석에서 만들어 전달하기
		ob.setNum(10);
		ob.setName("김구라");
		ob.useCar(new Car());
		
		//메소드 호출하면서 인자로 전달할 값이 지역변수에 이미 존재하는 경우라고 가정하자
		int a = 999;
		String b = "누구게";
		Car c1 = new Car();
		
		//전달할 값이 들어있는 변수명으로 전달 할 수 있다.
		ob.setNum(a);
		ob.setName(b);
		ob.useCar(c1);
		
		// doSomething() 메소드를 호출해 보세요
		ob.doSomething(10, "김구라", new Car());
		ob.doSomething(a, b, c1);
	}
}
