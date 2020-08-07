package vo;

public class Dish {
	private String type1;
	private String type2;
	private String type3;
	private String name;
	private int like;
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public Dish(String type1, String type2, String type3, String name, int like) {
		super();
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.name = name;
		this.like = like;
	}
	@Override
	public String toString() {
		return "Dish [type1=" + type1 + ", type2=" + type2 + ", type3=" + type3 + ", name=" + name + ", like=" + like
				+ "]";
	}
	public Dish() {
		super();
	}
	public Dish(String type1, String type2, String type3) {
		super();
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
	}
	public Dish(String type1, String type2, String type3, String name) {
		super();
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.name = name;
	}
	
	
}
