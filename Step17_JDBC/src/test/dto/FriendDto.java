package test.dto;

public class FriendDto {
	private int num;
	private String name;
	private String phone;
	private String birth;
	
	public FriendDto() {}

	public FriendDto(int num, String name, String phone, String birth) {
		super();
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
}
