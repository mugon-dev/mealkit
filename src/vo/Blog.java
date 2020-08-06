package vo;

import java.util.Date;

public class Blog {
	private int milNo;
	private String division, title, content, image;
	private int readCount, replyCount;
	private String cookIndex, cookType, main, sub, sauce;
	private int no;
	private Date rgstDt;
	
	public Blog() {
		super();
	}

	public Blog(String division, String title, String content, String image, String cookIndex, String cookType,
			String main, String sub, String sauce, int no) {
		super();
		this.division = division;
		this.title = title;
		this.content = content;
		this.image = image;
		this.cookIndex = cookIndex;
		this.cookType = cookType;
		this.main = main;
		this.sub = sub;
		this.sauce = sauce;
		this.no = no;
	}

	public Blog(int milNo, String division, String title, String content, String image, int readCount, int replyCount,
			String cookIndex, String cookType, String main, String sub, String sauce, int no, Date rgstDt) {
		super();
		this.milNo = milNo;
		this.division = division;
		this.title = title;
		this.content = content;
		this.image = image;
		this.readCount = readCount;
		this.replyCount = replyCount;
		this.cookIndex = cookIndex;
		this.cookType = cookType;
		this.main = main;
		this.sub = sub;
		this.sauce = sauce;
		this.no = no;
		this.rgstDt = rgstDt;
	}

	public int getMilNo() {
		return milNo;
	}

	public void setMilNo(int milNo) {
		this.milNo = milNo;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getCookIndex() {
		return cookIndex;
	}

	public void setCookIndex(String cookIndex) {
		this.cookIndex = cookIndex;
	}

	public String getCookType() {
		return cookType;
	}

	public void setCookType(String cookType) {
		this.cookType = cookType;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Date getRgstDt() {
		return rgstDt;
	}

	public void setRgstDt(Date rgstDt) {
		this.rgstDt = rgstDt;
	}

	@Override
	public String toString() {
		return "Bolg [milNo=" + milNo + ", division=" + division + ", title=" + title + ", content=" + content
				+ ", image=" + image + ", readCount=" + readCount + ", replyCount=" + replyCount + ", cookIndex="
				+ cookIndex + ", cookType=" + cookType + ", main=" + main + ", sub=" + sub + ", sauce=" + sauce
				+ ", no=" + no + ", rgstDt=" + rgstDt + "]";
	}
}
