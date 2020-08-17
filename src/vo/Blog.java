package vo;

import java.util.Date;

public class Blog {
	private int milNo, readCount, replyCount, matQty1, matQty2, matQty3, no;
	private String recIdx, title, content, image, cookIdx, cookType, matNo1, matNo2, matNo3, matEtc,  plate, hour, level;
	private Date rgstDt;
	
	public Blog() {
		super();
	}

	public Blog(int matQty1, int matQty2, int matQty3, int no, String recIdx, String title, String content, String image, 
				String cookIdx, String cookType, String matNo1, String matNo2, String matNo3, String matEtc, String plate, 
				String hour, String level) {
		super();
		this.matQty1 = matQty1;
		this.matQty2 = matQty2;
		this.matQty3 = matQty3;
		this.no = no;
		this.recIdx = recIdx;
		this.title = title;
		this.content = content;
		this.image = image;
		this.cookIdx = cookIdx;
		this.cookType = cookType;
		this.matNo1 = matNo1;
		this.matNo2 = matNo2;
		this.matNo3 = matNo3;
		this.matEtc = matEtc;
		this.plate = plate;
		this.hour = hour;
		this.level = level;
	}

	public Blog(int milNo, int readCount, int replyCount, int matQty1, int matQty2, int matQty3, int no, String recIdx,
			String title, String content, String image, String cookIdx, String cookType, String matNo1, String matNo2,
			String matNo3, String matEtc, String plate, String hour, String level, Date rgstDt) {
		super();
		this.milNo = milNo;
		this.readCount = readCount;
		this.replyCount = replyCount;
		this.matQty1 = matQty1;
		this.matQty2 = matQty2;
		this.matQty3 = matQty3;
		this.no = no;
		this.recIdx = recIdx;
		this.title = title;
		this.content = content;
		this.image = image;
		this.cookIdx = cookIdx;
		this.cookType = cookType;
		this.matNo1 = matNo1;
		this.matNo2 = matNo2;
		this.matNo3 = matNo3;
		this.matEtc = matEtc;
		this.plate = plate;
		this.hour = hour;
		this.level = level;
		this.rgstDt = rgstDt;
	}

	public int getMilNo() {
		return milNo;
	}

	public void setMilNo(int milNo) {
		this.milNo = milNo;
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

	public int getMatQty1() {
		return matQty1;
	}

	public void setMatQty1(int matQty1) {
		this.matQty1 = matQty1;
	}

	public int getMatQty2() {
		return matQty2;
	}

	public void setMatQty2(int matQty2) {
		this.matQty2 = matQty2;
	}

	public int getMatQty3() {
		return matQty3;
	}

	public void setMatQty3(int matQty3) {
		this.matQty3 = matQty3;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getRecIdx() {
		return recIdx;
	}

	public void setRecIdx(String recIdx) {
		this.recIdx = recIdx;
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

	public String getCookIdx() {
		return cookIdx;
	}

	public void setCookIdx(String cookIdx) {
		this.cookIdx = cookIdx;
	}

	public String getCookType() {
		return cookType;
	}

	public void setCookType(String cookType) {
		this.cookType = cookType;
	}

	public String getMatNo1() {
		return matNo1;
	}

	public void setMatNo1(String matNo1) {
		this.matNo1 = matNo1;
	}

	public String getMatNo2() {
		return matNo2;
	}

	public void setMatNo2(String matNo2) {
		this.matNo2 = matNo2;
	}

	public String getMatNo3() {
		return matNo3;
	}

	public void setMatNo3(String matNo3) {
		this.matNo3 = matNo3;
	}

	public String getMatEtc() {
		return matEtc;
	}

	public void setMatEtc(String matEtc) {
		this.matEtc = matEtc;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getRgstDt() {
		return rgstDt;
	}

	public void setRgstDt(Date rgstDt) {
		this.rgstDt = rgstDt;
	}

	@Override
	public String toString() {
		return "Blog [milNo=" + milNo + ", readCount=" + readCount + ", replyCount=" + replyCount + ", matQty1="
				+ matQty1 + ", matQty2=" + matQty2 + ", matQty3=" + matQty3 + ", no=" + no + ", recIdx=" + recIdx
				+ ", title=" + title + ", content=" + content + ", image=" + image + ", cookIdx=" + cookIdx
				+ ", cookType=" + cookType + ", matNo1=" + matNo1 + ", matNo2=" + matNo2 + ", matNo3=" + matNo3
				+ ", matEtc=" + matEtc + ", plate=" + plate + ", hour=" + hour + ", level=" + level + ", rgstDt="
				+ rgstDt + ", getMilNo()=" + getMilNo() + ", getReadCount()=" + getReadCount() + ", getReplyCount()="
				+ getReplyCount() + ", getMatQty1()=" + getMatQty1() + ", getMatQty2()=" + getMatQty2()
				+ ", getMatQty3()=" + getMatQty3() + ", getNo()=" + getNo() + ", getRecIdx()=" + getRecIdx()
				+ ", getTitle()=" + getTitle() + ", getContent()=" + getContent() + ", getImage()=" + getImage()
				+ ", getCookIdx()=" + getCookIdx() + ", getCookType()=" + getCookType() + ", getMatNo1()=" + getMatNo1()
				+ ", getMatNo2()=" + getMatNo2() + ", getMatNo3()=" + getMatNo3() + ", getMatEtc()=" + getMatEtc()
				+ ", getPlate()=" + getPlate() + ", getHour()=" + getHour() + ", getLevel()=" + getLevel()
				+ ", getRgstDt()=" + getRgstDt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
