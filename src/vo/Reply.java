package vo;

import java.util.Date;

public class Reply {
	private int reNo, milNo, no;
	private String reply;
	private Date rgstDt;
	
	public Reply() {
		super();
	}

	public Reply(int milNo, int no, String reply) {
		super();
		this.milNo = milNo;
		this.no = no;
		this.reply = reply;
	}

	public int getReNo() {
		return reNo;
	}

	public void setReNo(int reNo) {
		this.reNo = reNo;
	}

	public int getMilNo() {
		return milNo;
	}

	public void setMilNo(int milNo) {
		this.milNo = milNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getRgstDt() {
		return rgstDt;
	}

	public void setRgstDt(Date rgstDt) {
		this.rgstDt = rgstDt;
	}

	@Override
	public String toString() {
		return "Reply [reNo=" + reNo + ", milNo=" + milNo + ", no=" + no + ", reply=" + reply + ", rgstDt=" + rgstDt
				+ "]";
	}
}
