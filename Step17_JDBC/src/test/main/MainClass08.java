package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import test.util.DBConnect;

public class MainClass08 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name = "원숭이";
		String addr = "상도동";	
		
		//추가 할 회원의 정보를 HashMap 객체에 Key : value 의 쌍으로 저장
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("addr", addr);
		
		insert(map);
	}
	
	//회원 한 명의 정보를 추가하는 메소드를 만들기
	public static void insert(Map<String, Object> m) {
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
			pstmt.setString(1, (String)m.get("name"));
			pstmt.setString(2, (String)m.get("addr"));
					  
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
