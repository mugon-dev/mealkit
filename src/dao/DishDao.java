package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Dish;

public class DishDao {
	private DishDao() {};
	private static DishDao instance=new DishDao();
	public static DishDao getInstance() {
		return instance;
	}
	public List<Dish> selectSearch(String type1,String type2,String type3){
		List<Dish> list = new ArrayList<Dish>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from dish where type1=? && type2=? && type3=?";
		String sql1="select * from dish";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql1);
//			ps.setString(1, type1);
//			ps.setString(2, type2);
//			ps.setString(3, type3);
			rs=ps.executeQuery();
			while(rs.next()) {
				Dish dish=new Dish();
				dish.setType1(rs.getString("type1"));
				dish.setType2(rs.getString("type2"));
				dish.setType3(rs.getString("type3"));
				dish.setName(rs.getString("name"));
				dish.setLike(rs.getInt("like"));
				list.add(dish);
				//System.out.println(dish);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	public Dish selectOne(String name) {
		Dish dish=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from dish where name=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()) {
				dish=new Dish();
				dish.setType1(rs.getString("type1"));
				dish.setType2(rs.getString("type2"));
				dish.setType3(rs.getString("type3"));
				dish.setName(rs.getString("name"));
				dish.setLike(rs.getInt("like"));
				System.out.println("rs내부");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return dish;
	}
}
