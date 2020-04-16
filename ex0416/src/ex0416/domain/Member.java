package ex0416.domain;

public class Member {
	private String id;
	private String name;
	private String pwd;
	private int age;
	private String phone;
	private String addr;
	private String joinDate;
	
	public Member() {}

	public Member(String id, String name, String pwd, int age, String phone, String addr) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.phone = phone;
		this.addr = addr;
	}

	public Member(String id, String name, String pwd, int age, String phone, String addr, String joinDate) {
		this(id, name, pwd, age, phone, addr);
		this.joinDate = joinDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
}
