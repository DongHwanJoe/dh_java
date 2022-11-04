package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass10 {
	public static void main(String[] args) {
		//수정할 회원의 정보
		int num = 4;
		String name = "양감님";
		String addr = "서동";
		
		MemberDto dto = new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		update(dto);
	}
	
	//회원 한명의 정보를 수정하는 메소드
	public static void update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			
			//실행할 sql 문
			String sql = "UPDATE member"
					+" SET name = ?, addr = ?"
					+" WHERE num = ?";
					  
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// ? 에 값을 바인딩해서 미완성의 sql 문을 완성시킨다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
					  
			//sql 실행하기
			pstmt.executeUpdate();
			System.out.println("회원정보를 수정했습니다.");
	    } catch(Exception e) {
    		e.printStackTrace();
	    }finally {
	    	try {
	    		if(pstmt != null)pstmt.close();
	    		if(conn != null)conn.close();
	    	}catch(Exception e) {}
	    }
	}
}
