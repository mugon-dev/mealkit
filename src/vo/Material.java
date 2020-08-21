package vo;

import java.util.Date;

public class Material {
	private int mat_no;
	private String mat_idx;
	private String mat_nm;
	private int mat_price;
	private int mat_unit;
	private String mat_image;
	private Date rgst_dt;
	public Material() {
		// TODO Auto-generated constructor stub
	}
	public Material(int mat_no, String mat_idx, String mat_nm, int mat_price, int mat_unit, String mat_image
			) {
		super();
		this.mat_no = mat_no;
		this.mat_idx = mat_idx;
		this.mat_nm = mat_nm;
		this.mat_price = mat_price;
		this.mat_unit = mat_unit;
		this.mat_image = mat_image;		
	}
	public Material(int mat_no, String mat_idx, String mat_nm, int mat_price, int mat_unit, String mat_image,
			Date rgst_dt) {
		super();
		this.mat_no = mat_no;
		this.mat_idx = mat_idx;
		this.mat_nm = mat_nm;
		this.mat_price = mat_price;
		this.mat_unit = mat_unit;
		this.mat_image = mat_image;
		this.rgst_dt = rgst_dt;
	}
	public int getMat_no() {
		return mat_no;
	}
	public void setMat_no(int mat_no) {
		this.mat_no = mat_no;
	}
	public String getMat_idx() {
		return mat_idx;
	}
	public void setMat_idx(String mat_idx) {
		this.mat_idx = mat_idx;
	}
	public String getMat_nm() {
		return mat_nm;
	}
	public void setMat_nm(String mat_nm) {
		this.mat_nm = mat_nm;
	}
	public int getMat_price() {
		return mat_price;
	}
	public void setMat_price(int mat_price) {
		this.mat_price = mat_price;
	}
	public int getMat_unit() {
		return mat_unit;
	}
	public void setMat_unit(int mat_unit) {
		this.mat_unit = mat_unit;
	}
	public String getMat_image() {
		return mat_image;
	}
	public void setMat_image(String mat_image) {
		this.mat_image = mat_image;
	}
	public Date getRgst_dt() {
		return rgst_dt;
	}
	public void setRgst_dt(Date rgst_dt) {
		this.rgst_dt = rgst_dt;
	}
	@Override
	public String toString() {
		return "Material [mat_no=" + mat_no + ", mat_idx=" + mat_idx + ", mat_nm=" + mat_nm + ", mat_price=" + mat_price
				+ ", mat_unit=" + mat_unit + ", mat_image=" + mat_image + ", rgst_dt=" + rgst_dt + "]";
	}
	
}
