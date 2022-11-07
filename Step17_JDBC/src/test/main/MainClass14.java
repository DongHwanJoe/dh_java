package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		//추가할 회원의 정보라고 가정
		String name = "원숭이";
		String addr = "동물원";
		
		/*
		 *  MemberDao 객체를 생성해서 참조값을 dao라는 지역 변수에 담기
		 */
		MemberDao dao = new MemberDao();
		
		//insert()메소드에 전달할 MemberDto 객체 생성 및 회원정보 추가
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//MemberDao 객체를 이용해 회원정보를 추가하고 성공 여부를 리턴
		boolean isSuccess = dao.insert(dto);
		
		if(isSuccess) {
			System.out.println(name+" 의 정보를 추가했습니다.");
		}else {
			System.out.println("회원정보 추가 실패");
		}
	}
}
