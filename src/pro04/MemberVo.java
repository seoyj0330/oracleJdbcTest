package pro04;

public class MemberVo {
	
	//MemberVo �ۼ�
	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;

	
	public MemberVo() {
	}

	public MemberVo(int id, String name, String email, String password, String gender) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return id + " | " + name + " | " + email + " | " + password + " | " + gender;
	}

}
	
	
