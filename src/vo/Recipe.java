package vo;

import java.util.Date;

public class Recipe {
	private int mil_no;
	private String rec_idx;
	private String title;
	private String content;
	private String image;
	private int read_count;
	private int reply_count;
	private String cook_idx;
	private String cook_type;
	private int mat_no1;
	private int mat_qty1;
	private int mat_no2;
	private int mat_qty2;
	private int mat_no3;
	private int mat_qty3;
	private String mat_etc;
	private int no;
	private Date rgst_dt;
	private String plate;
	private String hour;
	private String level;
	
	public int getMil_no() {
		return mil_no;
	}
	@Override
	public String toString() {
		return "Recipe [mil_no=" + mil_no + ", rec_idx=" + rec_idx + ", title=" + title + ", content=" + content
				+ ", image=" + image + ", readcount=" + read_count + ", replycount=" + reply_count + ", cook_idx="
				+ cook_idx + ", cook_type=" + cook_type + ", mat_no1=" + mat_no1 + ", mat_qty1=" + mat_qty1
				+ ", mat_no2=" + mat_no2 + ", mat_qty2=" + mat_qty2 + ", mat_no3=" + mat_no3 + ", mat_qty3=" + mat_qty3
				+ ", mat_etc=" + mat_etc + ", no=" + no + ", rgst_dt=" + rgst_dt + ", plate=" + plate + ", hour=" + hour
				+ ", level=" + level + "]";
	}
	public void setMil_no(int mil_no) {
		this.mil_no = mil_no;
	}
	public String getRec_idx() {
		return rec_idx;
	}
	public void setRec_idx(String rec_idx) {
		this.rec_idx = rec_idx;
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
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	public String getCook_idx() {
		return cook_idx;
	}
	public void setCook_idx(String cook_idx) {
		this.cook_idx = cook_idx;
	}
	public String getCook_type() {
		return cook_type;
	}
	public void setCook_type(String cook_type) {
		this.cook_type = cook_type;
	}
	public int getMat_no1() {
		return mat_no1;
	}
	public void setMat_no1(int mat_no1) {
		this.mat_no1 = mat_no1;
	}
	public int getMat_qty1() {
		return mat_qty1;
	}
	public void setMat_qty1(int mat_qty1) {
		this.mat_qty1 = mat_qty1;
	}
	public int getMat_no2() {
		return mat_no2;
	}
	public void setMat_no2(int mat_no2) {
		this.mat_no2 = mat_no2;
	}
	public int getMat_qty2() {
		return mat_qty2;
	}
	public void setMat_qty2(int mat_qty2) {
		this.mat_qty2 = mat_qty2;
	}
	public int getMat_no3() {
		return mat_no3;
	}
	public void setMat_no3(int mat_no3) {
		this.mat_no3 = mat_no3;
	}
	public int getMat_qty3() {
		return mat_qty3;
	}
	public void setMat_qty3(int mat_qty3) {
		this.mat_qty3 = mat_qty3;
	}
	public String getMat_etc() {
		return mat_etc;
	}
	public void setMat_etc(String mat_etc) {
		this.mat_etc = mat_etc;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getRgst_dt() {
		return rgst_dt;
	}
	public void setRgst_dt(Date rgst_dt) {
		this.rgst_dt = rgst_dt;
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
	
}
