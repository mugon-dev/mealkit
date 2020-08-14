package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Material;

public class MaterialDao {
	private MaterialDao() {}
	private static MaterialDao instance = new MaterialDao();
	public static MaterialDao getInstance() {
		return instance;
	}
	
	public List<Material> selectAll(){
		List<Material> list=new ArrayList<Material>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from mat";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Material material=new Material();
				material.setMat_no(rs.getString("mat_no"));
				material.setMat_idx(rs.getString("mat_idx"));
				material.setMat_nm(rs.getString("mat_nm"));
				material.setMat_price(rs.getInt("mat_price"));
				material.setMat_unit(rs.getInt("mat_unit"));
				material.setMat_image(rs.getString("mat_image"));
				System.out.println(material);
				list.add(material);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	//idx로 선택
	public Material selectOne(String idx){
		Material material=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from mat where mat_idx=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, idx);
			rs=ps.executeQuery();
			while(rs.next()) {
				material=new Material();
				material.setMat_no(rs.getString("mat_no"));
				material.setMat_idx(rs.getString("mat_idx"));
				material.setMat_nm(rs.getString("mat_nm"));
				material.setMat_price(rs.getInt("mat_price"));
				material.setMat_unit(rs.getInt("mat_unit"));
				material.setMat_image(rs.getString("mat_image"));
				System.out.println(material);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return material;
	}
	
	public boolean insert(Material material) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql= "insert into mat(mat_no, mat_idx, mat_nm, mat_price, mat_unit,mat_image) VALUES (?, ?, ?, ?, ?,?)";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setNString(1, material.getMat_no());
			ps.setNString(2, material.getMat_idx());
			ps.setNString(3, material.getMat_nm());
			ps.setInt(4, material.getMat_price());
			ps.setInt(5, material.getMat_unit());
			ps.setNString(6, material.getMat_image());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("데이터 입력 성공");
			}else {
				System.out.println("데이터 입력 실패");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			try {
				DBConn.close(conn, ps);
			}catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}
		}
		return flag;
	}
	//업데이트 idx로 검색 가격,단위,사진만 가능
	public boolean update(Material material) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql= "update mat set mat_price = ?, mat_unit = ?, mat_image =? where mat_idx=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, material.getMat_price());
			ps.setInt(2, material.getMat_unit());
			ps.setNString(3, material.getMat_image());
			ps.setNString(4, material.getMat_idx());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("업데이트 성공");
			}else {
				System.out.println("업데이트 실패");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			try {
				DBConn.close(conn, ps);
			}catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}
		}
		return flag;
	}
	//idx로 삭제
	public boolean delete(String idx) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql= "delete from mat where mat_idx=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setNString(1, idx);
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			try {
				DBConn.close(conn, ps);
			}catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
