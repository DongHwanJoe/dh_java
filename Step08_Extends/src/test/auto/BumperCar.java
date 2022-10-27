package test.auto;

public class BumperCar extends Car{

	public BumperCar(Engine engine) {
		super(engine);
	}
	
	public void bump() { 
		System.out.println("충돌해요!");
	}
}
