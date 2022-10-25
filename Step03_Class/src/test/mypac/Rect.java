package test.mypac;

public class Rect {
	public double width;
	public double height;
	
	public void showArea() {
		double area = this.width*this.height;
		System.out.println("사각형의 넓이 : " + area);
	}
}
