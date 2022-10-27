package test.main;

import test.auto.ElectricCar;
import test.auto.Engine;

public class MainClass07 {
	public static void main(String[] args) {
		
		ElectricCar car1 = new ElectricCar(new Engine());
		car1.drive();
		car1.charge();
	}
}
