package test.mypac;

public class NaviRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("포커스를 위로 올려요");
	}

	@Override
	public void down() {
		System.out.println("포커스를 아래로 내려요");
	}

}
