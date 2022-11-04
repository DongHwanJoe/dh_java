package test.main;

/*
 *  1. JTextField에 문자열을 입력하고 추가 버튼을 누르면
 *     입력한 문자열이 myFolder/memo.txt 파일에 append 되도록 해보세요.
 *     
 *  2. 불러오기 버튼을 누르면 myFolder/memo.txt 파일에 있는 모든 문자열을 
 *     JTextArea에 출력하도록 해보세요.
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Quiz extends JFrame implements ActionListener {
	JButton appendBtn;
	JButton readBtn;
	JTextField tf;
	JTextArea ta;
	File f;
	FileWriter fw;
	FileReader fr;
	BufferedReader br;
	
	public Quiz(String title) {
		super(title);
		
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		tf = new JTextField(10);
	    add(tf);
		
		appendBtn = new JButton("추가");
		add(appendBtn);
		
		readBtn = new JButton("불러오기");
		add(readBtn);
		
	    ta = new JTextArea();
	    add(ta);
	    
	    ta.setEditable(false);
		appendBtn.addActionListener(this);
		readBtn.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		Quiz f = new Quiz("Quiz 프레임");
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		f = new File("c:/acorn202210/myFolder/memo.txt");
		String command = e.getActionCommand();
		String msg = tf.getText();
		
		
		if(command.equals("추가")) {
			try {
				fw = new FileWriter(f, true);
				fw.write(msg+"\r\n");
				fw.flush();
				tf.setText("");
				JOptionPane.showMessageDialog(this, "문자열을 추가했습니다.");
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if(fw != null) {
						fw.close();
					}
				}catch(Exception e2) {}
			}
		}else if(command.equals("불러오기")) {
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				
				ta.setText("");
				
				while(true) {
					//개행 기호를 기준으로 한 줄씩 읽어오기 때문에 개행기호는 읽어오지 않는다.
					String line = br.readLine();
					if(line == null) {
						break;
					}
					ta.append(line+ "\r\n");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}finally {
				try {
					if(br != null) {
						br.close();
					}
					if(fr != null) {
						fr.close();
					}
				}catch(Exception e2) {}
			}
		}
		
	}
}
