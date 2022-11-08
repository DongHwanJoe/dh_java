package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame 
				implements ActionListener, PropertyChangeListener{
	//필드
	JTextField inputName, inputAddr;
	DefaultTableModel model;
	JTable table;
	
	//생성자
	public MemberFrame() {
		//레이아웃 매니저 설정
		setLayout(new BorderLayout());
		  
		JLabel label1 = new JLabel("이름");
		inputName = new JTextField(10);
		  
		JLabel label2 = new JLabel("주소");
		inputAddr = new JTextField(10);
		  
		JButton saveBtn = new JButton("저장");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		
		//패널에 UI를 배치     
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		
		//패널째로 프레임의 북쪽에 배치
		add(panel, BorderLayout.NORTH);	
		
		//표형식으로 정보를 출력하기 위한 JTable
		table = new JTable();
		//컬럼명을 String[] 에 순서대로 준비
		String[] colNames = {"번호", "이름", "주소"};
		//테이블에 연결할 모델객체(테이블에 출력할 데이터를 가지고있는 객체)
		model = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// 0번째 칼럼(num)은 수정 불가능 하도록 false를 리턴
				if(column == 0) {
					return false;
				}else { //나머지 칼럼은 수정 가능하도록 true를 리턴
					return true;
				}
			}
		};
		
		//모델을 테이블에 연결
		table.setModel(model);
		//스크롤이 가능하도록 테이블을 JScrollPane 적용
		JScrollPane scroll = new JScrollPane(table);
		//JScrollPane 을 프레임의 가운대 배치
		add(scroll, BorderLayout.CENTER);
		
		displayMember();
		
		table.addPropertyChangeListener(this);
	}
	
	//테이블에 회원 목록을 출력하는 메소드
	public void displayMember() {
		/*
		//샘플 데이터
		Object[] row1 = {1, "김구라", "노량진"};
		Object[] row2 = {2, "해골", "행신동"};
		Object[] row3 = {3, "원숭이", "동물원"};
		
		//sample 데이터를 DefaultTableModel 객체에 추가
		model.addRow(row1);
		model.addRow(row2);
		model.addRow(row3);
		*/
		
		//MemberDao 객체의 .getList() 메소드가 리턴해주는 데이터를 활용해서 회원목록을 출력하기
		model.setRowCount(0); //테이블에 출력된 데이터 reset
		
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.getList();
		
		for(MemberDto tmp:list) {
			Object[] obj = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			model.addRow(obj);
		}
	}
	
	public static void main(String[] args) {
		MemberFrame f = new MemberFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		MemberDao dao = null;		
		MemberDto dto = null;
		boolean isSuccess = false;
		
		if(command.equals("save")) {
			String name = inputName.getText();
			String addr = inputAddr.getText();
			
			dto = new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			dao = new MemberDao();
			
			if(name.equals("") || addr.equals("")) {
				JOptionPane.showMessageDialog(this, "이름 또는 주소가 공백입니다");
				return;
			}else {
				isSuccess = dao.insert(dto);
			}
			
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, name+" 의 정보를 추가했습니다.");
				inputName.setText("");
		        inputAddr.setText("");
		        displayMember();
			}else {
				JOptionPane.showMessageDialog(this, "회원정보 추가 실패");
			}
		}else if(command.equals("delete")) {
			//1. JTable의 선택된 row의 인덱스를 읽어오기
			int rowNum = table.getSelectedRow();
			if(rowNum == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택하세요.");
				return;
			}
			
			int result = JOptionPane.showConfirmDialog(this, "선택된 row를 삭제 하시겠습니까?");
			//예를 눌렀을 때 삭제작업이 진행
			if(result == JOptionPane.YES_OPTION) {
				//2. DefaultTableModel에서 해당 인덱스의 table row에서 삭제할 회원의 번호을 읽어오기
				int num = (int)model.getValueAt(rowNum, 0);
				//3. MemberDao 객체를 이용해서 DB에서 삭제하고
				new MemberDao().delete(num);
				//4. JTable 새로고침
				displayMember();
			}
		}
	}

	//table에 특정 이벤트가 발생했을때 호출되는 메소드
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		/*
		int rowNum = table.getSelectedRow();
		
		if(!table.isEditing() && rowNum != -1) {
			int num = (int)model.getValueAt(rowNum, 0);
			String name = (String)model.getValueAt(rowNum, 1);
			String addr = (String)model.getValueAt(rowNum, 2);
			MemberDto dto = new MemberDto();
			dto.setNum(num);
			dto.setName(name);
			dto.setAddr(addr);
			new MemberDao().update(dto);
		}
		*/
		
		//풀이
		//만일 테이블의 수정 사항을 DB에 수정 반영 할 적당한 시점이 되면
		if(evt.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
			//현재 선택된 row의 정보를 DB에 수정 반영한다.
			//변화된 값을 읽어와서 DB에 반영한다.
			//수정된 칼럼에 있는 row 전체의 값을 읽어온다.
			int selectedIndex = table.getSelectedRow();
			int num = (int)model.getValueAt(selectedIndex, 0);
			String name = (String)model.getValueAt(selectedIndex, 1);
			String addr = (String)model.getValueAt(selectedIndex, 2);
			//수정할 회원의 정보를 MemberDto 객체에 담고
			MemberDto dto = new MemberDto(num, name, addr);
			//DB에 저장하기
			new MemberDao().update(dto);
			//선택된 row clear
			table.clearSelection();
		}
		
		/*
		System.out.println("property change!");
		System.out.println("property name:"+evt.getPropertyName());
		
		System.out.println("isEditing:"+table.isEditing());
		*/
	}
}