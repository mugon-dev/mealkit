package vo;

public class Member {
	private int no;
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String tel;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String pw, String name, String addr, String tel) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	public Member(int no, String id, String pw, String name, String addr, String tel) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", addr=" + addr + ", tel=" + tel
				+ "]";
	}
}
