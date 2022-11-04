package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass09 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name = "조동환";
		String addr = "오산시";	
		
		//추가 할 회원의 정보를 MemberDto 객체에 저장
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		insert(dto);
	}
	
	//회원 한 명의 정보를 추가하는 메소드를 만들기
	public static void insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			
			//실행할 sql 문
			String sql = "INSERT INTO member"
			+ " (num, name, addr)"
			+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// ? 에 값을 바인딩해서 미완성의 sql 문을 완성시킨다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
					  
			//sql 실행하기
			pstmt.executeUpdate();
			System.out.println("회원정보를 추가했습니다.");
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
