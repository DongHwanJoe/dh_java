package test.main;

import test.mypac.Cpu;
import test.mypac.HardDisk;
import test.mypac.MacBook;
import test.mypac.Memory;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * 1. MacBook 객체를 생성해서 참조값을 mac1 이라는 지역변수에 담아보세요.
		 * 단, MacBook 클래스를 절대 수정하지 마세요
		 */
		MacBook mac1 = new MacBook(new Cpu(), new Memory(), new HardDisk());
		//2. mac1 지역변수에 들어있는 참조값을 이용해서 .doGame() 이라는 메소드를 호출해 보세요.
		mac1.doGame();
		
		//Cpu, Memory, HardDisk를 각각 변수에 담아 해당 변수를 인자로 전달하여 생성자능
		Cpu c1 = new Cpu();
		Memory m1 = new Memory();
		HardDisk h1 = new HardDisk();
		
		MacBook mac2 = new MacBook(c1, m1, h1);
		mac2.doGame();
	}
}
