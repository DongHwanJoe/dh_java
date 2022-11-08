package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.FriendDto;
import test.util.DBConnect;

public class FriendDao {

	public boolean insert(FriendDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int rowCount = 0;
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "INSERT INTO friend"
					+ " (num, name, phone, birth)"
					+ " VALUES(friend_seq.NEXTVAL, ?, ?,"
					+ " to_date(?, 'yyyy-mm-dd'))";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getBirth());
			
			rowCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		
		if(rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int rowCount = 0;
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "DELETE FROM friend"
					+ " WHERE num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rowCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		
		if(rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean update(FriendDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int rowCount = 0;
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "UPDATE friend SET"
					+ " name = ?, phone = ?,"
					+ " birth = to_date(?, 'yyyy-mm-dd')"
					+ " WHERE num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getBirth());
			pstmt.setInt(4, dto.getNum());
			
			rowCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		
		if(rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<FriendDto> getlist(){
		List<FriendDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "SELECT num, name, phone,"
					+ " to_char(birth, 'yyyy-mm-dd') birth"
					+ " FROM friend"
					+ " ORDER BY num ASC";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FriendDto dto = new FriendDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setBirth(rs.getString("birth"));
				
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		
		return list;
	}
	
	public FriendDto getdata(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FriendDto dto = null;
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "SELECT num, name, phone,"
					+ " to_char(birth, 'yyyy-mm-dd') birth"
					+ " FROM friend"
					+ " WHERE num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new FriendDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setBirth(rs.getString("birth"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {}
		}
		
		return dto;
	}
}
