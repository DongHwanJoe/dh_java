package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 *  JDBC ( Java DataBase Connectivity )
 *  
 *  DataBase에 연결해서 SELECT, INSERT, UPDATE, DELETE 작업하기
 *  
 *  Oracle에 연결하기 위해서는 드라이버 클래스가 들어있는 object6.jar 파일을
 *  사용할 수 있도록 설정해야 한다.
 */
public class MainClass01 {
	public static void main(String[] args) {
		//DB 연결객체를 담을 지역 변수 만들기
		Connection conn = null;
		  
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB 의 정보 @아이피주소:port번호:db이름
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		//SEELCT 작업을 위해서 필요한 객체의 참조값을 담을 지역 변거 ㅁㄹㄹ
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//실행할 sql 문
			String sql = "SELECT num, name, addr FROM member ORDER BY num DESC";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//PreparedStatement 객체를 이용해서 query문 수행 후
			//결과를 ResultSet 객체로 받아오기
			rs = pstmt.executeQuery();
			
			/*
			 * ResultSet 객체의 .next() 메소드는 cursor 밑에 row가 존재하는지 확인해서
			 * 존재하면 true를 리턴하고 cursor가 한 칸 밑으로 이동한다.
			 * 존재하지 않으면 false를 리턴한다.
			 */
			while(rs.next()) {
			System.out.print("번호:"+rs.getInt("num"));
			System.out.print(" 이름:"+rs.getString("name"));
			System.out.print(" 주소:"+rs.getString("addr"));
			System.out.println("");
			} 	  
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
