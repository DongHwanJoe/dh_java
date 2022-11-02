package frame05;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {
	//생성자
	public MyFrame(String title) {
		super(title);
		// this 예약어를 이용해서 MyFrame 객체의 다형성 확인
		MyFrame a = this;
		JFrame b = this;
		Component c = this;
		Object d = this;
		
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton sendBtn = new JButton("전송");
		add(sendBtn);
		
		//ActionListener 인터페이스 type의 참조값 얻어내기
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("전송 버튼을 눌렀네?");
				ActionListener f = this; //this의 위치에 따른 타입 구분하기
				
				Component g = MyFrame.this; //inner class 에서 outer class의 참조값 받아오기
				
				JOptionPane.showMessageDialog(MyFrame.this, "전송합니다");
				//                               |             ㄴ> String 문자열
				//                               ㄴ> Component type을 전달하기 위해 MyFrame의 참조값 전달
			}
		};
		
		//전송 버튼에 등록하기
		sendBtn.addActionListener(listener);
		
		/*
		 *  삭제 버튼도 프레임에 배치하고, 해당 버튼을 눌렀을 때 "삭제 버튼을 눌렀네?" 라는
		 *  메시지를 콘솔창에 출력되도록 하기
		 */
		
		/*
		JButton delBtn = new JButton("삭제");
		add(delBtn);
		
		ActionListener listener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("삭제 버튼을 눌렀네?");
			}
		};
		delBtn.addActionListener(listener2);
		*/
		
		JButton delBtn = new JButton("삭제");
		add(delBtn);
		
		delBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("삭제 버튼을 눌렀네?");
				JOptionPane.showMessageDialog(MyFrame.this, "삭제합니다");
			}
		});
		
	}
	
	public static void main(String[] args) {
		MyFrame f = new MyFrame("나의 프레임5");
		f.setVisible(true);
	}
}
