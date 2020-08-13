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
				material.setMat_idx();
				list.add(material);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
}
