package frame05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import test.mypac.CountRunnable;

public class MyFrame extends JFrame implements ActionListener{

	//생성자
	public MyFrame(String title) {
		super(title);
		//프레임의 초기 설정 작업하기
		setBounds(100, 100, 500, 500);
		// MyFrame의 x 버튼(close 버튼) 을 눌렀을 때 프로세스도 같이 종료되도록 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 레이아웃 설정
		setLayout(new FlowLayout());
		
		JButton startBtn = new JButton("카운트 다운 시작");
		startBtn.addActionListener(this);
		
		add(startBtn);
		
		JTextField tf = new JTextField(10);
		add(tf);
		
		// 프레임을 화면상에 실제로 보이게하기(false 하면 화면에 보이지 않는다)
		this.setVisible(true);
	}
	//run 했을 때 실행의 흐름이 시작되는 특별한 메소드
	public static void main(String[] args) {
		//MyFrame 객체 생성하기
		new MyFrame("나의 프레임");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("카운트 다운을 시작합니다.");
		//내부 클래스로 객체 생성해서 스레드 시작
		new InnerCountThread().start();
		
	}
	
	
	// Thread를 상속받는 클래스 작성 시 내부클래스로 작성 시 해당 클래스의 필드값 등을 이용하기 편리하다.
	class InnerCountThread extends Thread{
		@Override
		public void run() {
			//카운트 값을 저장 할 지역 변수 만들고 초기 값 대입
			int count = 10;
			while(true) {
				System.out.println("현재 카운트: "+count);
				if(count == 0) {//count가 0이면 while문 탈출
					break;//반복문을 탈출하면 run() 메소드가 리턴되기 때문에 스레드가 종료된다.
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count--;
			}
		}
	}
}
