package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	
	//Anonymous Inner Class를 사용할 때 자동으로 interface 라면 implements, class라면 extends 된다.
	static Remocon r1 = new Remocon() {
		
		@Override
		public void up() {
			System.out.println("뭔가 올라가요");
		}
		
		@Override
		public void down() {
			System.out.println("뭔가 내려가요");
		}
	};
	
	public static void main(String[] args) {
		useRemocon(r1);
		
		//Anonymous Local Inner Class를 이용해서 interface type의 참조값을 얻어내기
		Remocon r2 = new Remocon() {
			@Override
			public void up() {
				System.out.println("올라간다아아ㅏ");
			}
			@Override
			public void down() {
				System.out.println("내려간다아아아");
			}
		};
		useRemocon(r2);
		
		//메소드 호출하면서 Remocon type을 즉석에서 얻어내서 전달하기
		useRemocon(new Remocon() {
			@Override
			public void up() {
				System.out.println("올랄라");
			}
			@Override
			public void down() {
				System.out.println("낼랄라");
			}
		});
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
