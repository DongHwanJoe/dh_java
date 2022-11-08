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

import test.dao.FriendDao;
import test.dto.FriendDto;

public class FriendFrame extends JFrame implements ActionListener, PropertyChangeListener {

	JTextField inputName, inputPhone, inputBirth;
	JTable table;
	DefaultTableModel model;
	
	public FriendFrame() {
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("이름");
		inputName = new JTextField(5);
		
		JLabel label2 = new JLabel("전화번호");
		inputPhone = new JTextField(15);
		
		JLabel label3 = new JLabel("생일");
		inputBirth = new JTextField(15);
		
		JButton saveBtn = new JButton("저장");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);
		
		JButton delBtn = new JButton("삭제");
		delBtn.setActionCommand("del");
		delBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputPhone);
		panel.add(label3);
		panel.add(inputBirth);
		panel.add(saveBtn);
		panel.add(delBtn);
		
		add(panel, BorderLayout.NORTH);
		
		table = new JTable();
		String[] colNames = {"번호", "이름", "전화번호", "생일(yyyy/mm/dd형식 입력)"};
		model = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return (column > 0) ? true : false;
			}
		};
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		table.addPropertyChangeListener(this);
		
		displayFriend();
	}
	
	public static void main(String[] args) {
		FriendFrame f = new FriendFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	
	public void displayFriend() {
		model.setRowCount(0);
		
		FriendDao dao = new FriendDao();
		List<FriendDto> list = dao.getlist();
		
		for(FriendDto tmp:list) {
			Object[] obj = {tmp.getNum(), tmp.getName(), tmp.getPhone(), tmp.getBirth()};
			model.addRow(obj);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
			int rowNum = table.getSelectedRow();
			int num = (int)model.getValueAt(rowNum, 0);
			String name = (String)model.getValueAt(rowNum, 1);
			String phone = (String)model.getValueAt(rowNum, 2);
			String birth = (String)model.getValueAt(rowNum, 3);
			
			FriendDto dto = new FriendDto(num, name, phone, birth);
			new FriendDao().update(dto);
			table.clearSelection();
			displayFriend();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		FriendDao dao = null;
		FriendDto dto = null;
		
		if(command.equals("save")) {
			String name = inputName.getText();
			String phone = inputPhone.getText();
			String birth = inputBirth.getText();
			boolean isSuccess = false;
			
			dao = new FriendDao();
			dto = new FriendDto();
			dto.setName(name);
			dto.setPhone(phone);
			dto.setBirth(birth);
			
			//입력란이 공백이면 그대로 넣을건지 확인
			if(name.equals("") || phone.equals("") || birth.equals("")) {
				int result = JOptionPane.showConfirmDialog(this, "입력하지 않은 내용이 있습니다. 이대로 추가하시겠습니까?");
				if(result == JOptionPane.YES_OPTION) {
					isSuccess = dao.insert(dto);
				}else {
					return;
				}
			}else {
				isSuccess = dao.insert(dto);
			}
			
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, name+" 의 정보를 추가했습니다.");
				//정보 추가 후 입력란 공백만들기
				inputName.setText("");
		        inputPhone.setText("");
		        inputBirth.setText("");
		        displayFriend();
			}else {
				JOptionPane.showMessageDialog(this, "회원정보 추가 실패");
			}
		} else if(command.equals("del")) {
			int rowNum = table.getSelectedRow();
			if(rowNum == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택하세요.");
				return;
			}
			
			int result = JOptionPane.showConfirmDialog(this, "선택한 row를 삭제하시겠습니까?");
			if(result == JOptionPane.YES_OPTION) {
				int num = (int)model.getValueAt(rowNum, 0);
				new FriendDao().delete(num);
				displayFriend();
			}
		}
	}
}
