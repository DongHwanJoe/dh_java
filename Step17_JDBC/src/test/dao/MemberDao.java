package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 *  Data Access Object 만들어 보기
 *  
 *  - DB 에 insert, update, delete, select 작업을 대신 해주는 객체를 생성할 클래스 설계하기
 */
public class MemberDao {
	
	//회원 한 명의 정보를 저장하고 작업의 성공 여부를 리턴해주는 메소드
	public boolean insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//수정된 row의 개수를 담을 지역 변수를 미리 만들고 초기값 0 대입하기
		int rowCount = 0;
		
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			
			//실행할 sql 문
			String sql = "INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
					  
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩하기
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			
			//sql 실행 후 변화(추가, 수정, 삭제)된 row의 개수를 리턴받기
			rowCount = pstmt.executeUpdate();
	    } catch(Exception e) {
    		e.printStackTrace();
	    }finally {
	    	try {
	    		if(pstmt != null)pstmt.close();
	    		if(conn != null)conn.close();
	    	}catch(Exception e) {}
	    }
		
		//변화된 rowCount 값을 확인해서 작업의 성공 여부를 리턴
		if(rowCount > 0) {
			return true;
		}else {
			return false;
		}
		//return rowCount > 0 ? true:false; 로 작성해도 OK
	}
	
	//회원 한 명의 정보를 수정하고 작업의 성공 여부를 리턴해주는 메소드
	public boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//수정된 row의 개수를 담을 지역 변수를 미리 만들고 초기값 0 대입하기
		int rowCount = 0;
		
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			
			//실행할 sql 문
			String sql = "UPDATE member"
					+" SET name = ?, addr = ?"
					+" WHERE num = ?";
					  
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩하기
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			
			//sql 실행 후 변화(추가, 수정, 삭제)된 row의 개수를 리턴받기
			rowCount = pstmt.executeUpdate();
	    } catch(Exception e) {
    		e.printStackTrace();
	    }finally {
	    	try {
	    		if(pstmt != null)pstmt.close();
	    		if(conn != null)conn.close();
	    	}catch(Exception e) {}
	    }
		//변화된 rowCount 값을 확인해서 작업의 성공 여부를 리턴
		if(rowCount > 0) {
			return true;
		}else {
			return false;
		}
		//return rowCount > 0 ? true:false; 로 작성해도 OK
	}
	
	//회원 한 명의 정보를 삭제하고 작업의 성공 여부를 리턴해주는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//수정된 row의 개수를 담을 지역 변수를 미리 만들고 초기값 0 대입하기
		int rowCount = 0;
		
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			
			//실행할 sql 문
			String sql = "DELETE FROM member"
					+" WHERE num = ?";
					  
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩하기
			pstmt.setInt(1, num);
			
			//sql 실행 후 변화(추가, 수정, 삭제)된 row의 개수를 리턴받기
			rowCount = pstmt.executeUpdate();
	    } catch(Exception e) {
    		e.printStackTrace();
	    }finally {
	    	try {
	    		if(pstmt != null)pstmt.close();
	    		if(conn != null)conn.close();
	    	}catch(Exception e) {}
	    }
		//변화된 rowCount 값을 확인해서 작업의 성공 여부를 리턴
		if(rowCount > 0) {
			return true;
		}else {
			return false;
		}
		//return rowCount > 0 ? true:false; 로 작성해도 OK
	}
	
	public List<MemberDto> getList(){
		//회원 전체 목록을 담을 ArrayList 객체를 생성해서 참조값을 List 인터페이스 type으로 담기
		List<MemberDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			
			//실행할 sql 문
			String sql = "SELECT num, name, addr"
					+" FROM member"
					+" ORDER BY num ASC";
					  
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
					  
			while(rs.next()) {
				//커서가 위치한 곳의 회원 정보를 MemberDto 객체에 담기
				MemberDto dto = new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				
				//회원 한명의 정보가 담긴 MemberDto 객체의 참조갑슬 ArrayList 객체에 누적시키기
				list.add(dto);
			}
	    } catch(Exception e) {
    		e.printStackTrace();
	    }finally {
	    	try {
	    		if(rs != null)rs.close();
	    		if(pstmt != null)pstmt.close();
	    		if(conn != null)conn.close();
	    	}catch(Exception e) {}
	    }
		//모든 회원 정보가 누적된 ArrayList 객체의 참조값 리턴해주기
		return list;
	} 
	
	public MemberDto getData(int num) {
		//MemberDto 객체의 참조값을 담을 지역 변수 미리 만들기
		MemberDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			
			//실행할 sql 문
			String sql = "SELECT num, name, addr"
					+" FROM member"
					+" WHERE num = ?";
					  
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			//커서를 내릴 수 있다면(SELECT된 row가 있다면)
			if(rs.next()) {
				dto = new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
			
	    } catch(Exception e) {
    		e.printStackTrace();
	    }finally {
	    	try {
	    		if(rs != null)rs.close();
	    		if(pstmt != null)pstmt.close();
	    		if(conn != null)conn.close();
	    	}catch(Exception e) {}
	    }
		return dto;
	}
}
