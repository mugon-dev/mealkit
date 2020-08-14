package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Material;
import vo.Recipe;

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
	public Material selectOne(String mat_no){
		Material material=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from mat where mat_no=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, mat_no);
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
}
