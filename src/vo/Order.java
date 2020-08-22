package vo;

import java.util.Date;

public class Order {
	private int order_no;
	private int no;
	private int mat_no;
	private String mat_nm;
	private int mat_qty;
	private int mat_unit;
	private Date rgst_dt;

	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getMat_no() {
		return mat_no;
	}
	@Override
	public String toString() {
		return "Order [order_no=" + order_no + ", no=" + no + ", mat_no=" + mat_no + ", mat_nm=" + mat_nm + ", mat_qty="
				+ mat_qty + ", mat_unt=" + mat_unit + ", rgst_dt=" + rgst_dt + "]";
	}
	public void setMat_no(int mat_no) {
		this.mat_no = mat_no;
	}
	
	public String getMat_nm() {
		return mat_nm;
	}
	public void setMat_nm(String mat_nm) {
		this.mat_nm = mat_nm;
	}
	public int getMat_qty() {
		return mat_qty;
	}
	public void setMat_qty(int mat_qty) {
		this.mat_qty = mat_qty;
	}
	public int getMat_unit() {
		return mat_unit;
	}
	public void setMat_unt(int mat_unit) {
		this.mat_unit = mat_unit;
	}
	public Date getRgst_dt() {
		return rgst_dt;
	}
	public void setRgst_dt(Date rgst_dt) {
		this.rgst_dt = rgst_dt;
	}
	
	public Order() {
		super();
	}
	public Order(int no, int mat_no, String mat_nm, int mat_qty, int mat_unt) {
		super();
		this.no = no;
		this.mat_no = mat_no;
		this.mat_nm = mat_nm;
		this.mat_qty = mat_qty;
		this.mat_unit = mat_unt;
	}
	
	
	
	
}
