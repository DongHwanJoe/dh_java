package test.mypac;

public class SmartPhone extends HandPhone{
	//생성자
	public SmartPhone() {
		System.out.println("SmartPhone 생성자 호출됨");
	}
	
	//메소드
	public void doInternet() {
		System.out.println("인터넷을 해요");
	}
	
	@Override
	public void takePicture() {
		//부모객체의 메소드도 함께 출력 하고자 한다면 super.takePicture();
		System.out.println("1000만 화소의 사진을 찍어요!");
	}
}
