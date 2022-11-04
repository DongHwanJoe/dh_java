package test.main;

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

/*
 *  1. JTextField에 문자열을 입력하고 추가 버튼을 누르면
 *  입력한 문자열이 myFolder/memo.txt파일에 append 되도록 해보세요.
 * 
 *  2. 불러오기 버튼을 누르면 myFolder/memo.txt 파일에 있는 모든 문자열을
 *  JTextArea에 출력하도록 해보세요.
 */
public class QuizMain extends JFrame implements ActionListener {
   JTextField inputMsg;
   JTextArea ta;

   public QuizMain(String title) {
      super(title);
      setBounds(100, 100, 500, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new FlowLayout(FlowLayout.CENTER));

      inputMsg = new JTextField(10);
      ta = new JTextArea();
      JButton addBtn = new JButton("추가");
      JButton callBtn = new JButton("불러오기");

      add(inputMsg);
      add(addBtn);
      add(callBtn);
      add(ta);

      addBtn.addActionListener(this);
      callBtn.addActionListener(this);
      
      ta.setEditable(false);
      setVisible(true);
   }

   public static void main(String[] args) {
      new QuizMain("QuizMain");
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String msg = inputMsg.getText();
      File memoFile = new File("c:/acorn202210/myFolder/memo.txt");
      FileReader fr = null;
      BufferedReader br = null;
      try {
         String command = e.getActionCommand();
         if(command.equals("추가")) {
            FileWriter pw = new FileWriter(memoFile, true);
            pw.write(msg+"\r\n");
            pw.flush();
              pw.close();
         } else if(command.equals("불러오기")) {
            fr = new FileReader(memoFile);
            br = new BufferedReader(fr);
            while (true) {
               String line = br.readLine();
               if (line == null) {
                  break;
               }
               ta.append(line+"\r\n");
               
            }
         }
      } catch (Exception e1) {
         e1.printStackTrace();
      } finally {
         // exception이 발생하건 안하건 실행할 수 있는 공간에서 마무리작업을 해준다.
         try {
            // 혹시 모를 null 로 넘어오는 상황을 위해 대비
            // 닫는 작업은 열린 순서의 역순으로 하면 좋다.
            if(br != null) br.close();
            if(fr != null) fr.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
   }
}