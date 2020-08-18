package vo;

import java.util.Date;

public class Order {
	private int order_no;
	private int no;
	private String mat_no;
	private int mat_qty;
	private int mat_unt;
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
	public String getMat_no() {
		return mat_no;
	}
	public void setMat_no(String mat_no) {
		this.mat_no = mat_no;
	}
	public int getMat_qty() {
		return mat_qty;
	}
	public void setMat_qty(int mat_qty) {
		this.mat_qty = mat_qty;
	}
	public int getMat_unt() {
		return mat_unt;
	}
	public void setMat_unt(int mat_unt) {
		this.mat_unt = mat_unt;
	}
	public Date getRgst_dt() {
		return rgst_dt;
	}
	public void setRgst_dt(Date rgst_dt) {
		this.rgst_dt = rgst_dt;
	}
	public Order(int order_no, int no, String mat_no, int mat_qty, int mat_unt) {
		super();
		this.order_no = order_no;
		this.no = no;
		this.mat_no = mat_no;
		this.mat_qty = mat_qty;
		this.mat_unt = mat_unt;
	}
	public Order(int no, String mat_no, int mat_qty, int mat_unt) {
		super();
		this.no = no;
		this.mat_no = mat_no;
		this.mat_qty = mat_qty;
		this.mat_unt = mat_unt;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [order_no=" + order_no + ", no=" + no + ", mat_no=" + mat_no + ", mat_qty=" + mat_qty
				+ ", mat_unt=" + mat_unt + ", rgst_dt=" + rgst_dt + "]";
	}
	
	
}
