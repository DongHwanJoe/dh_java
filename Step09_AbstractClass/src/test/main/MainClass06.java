package test.main;

import test.mypac.Weapon;

public class MainClass06 {
	
	Weapon w1 = new Weapon() {
		@Override
		public void attack() {
			System.out.println("동생이랑 한다이 할래");
		}
	};
			
	public static void main(String[] args) {
		Weapon w2 = new Weapon() {
			@Override
			public void attack() {
				System.out.println("동생이랑 그건 좀 아닌거같고");
			}
		};
		
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("아니믄.. 끄지라 시발롬아");
			}
		});
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
