package dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import bean.User;
import util.JDBCUtils;

public class UsersDao {
	// 添加用户的操作
	public boolean insert(User user) {
		// 补充代码
		Connection conn = null;
		PreparedStatement prestmt = null;
		ResultSet rs = null;

		boolean success = false;
		try {
				conn = JDBCUtils.getConnection();
				String sql = "insert into tb_user3 values(?,?,?,?,?)";
				prestmt = conn.prepareStatement(sql);
				prestmt.setInt(1, user.getId());
				prestmt.setString(2, user.getUsername());
				prestmt.setString(3, user.getPassword());
				prestmt.setString(4, user.getEmail());
				prestmt.setString(5, user.getBirthday());
				int num = prestmt.executeUpdate();
			if (num > 0)
				success = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(prestmt, conn, rs);
		}
		return success;
	}

	// 查询所有的User对象
	public ArrayList<User> findAll() {
		// 补充代码
		Connection conn=null;
		PreparedStatement prestmt =null;
		ResultSet rs=null;
		
		boolean success=false;
		ArrayList<User> list = new ArrayList<User>();
		try {
			conn=JDBCUtils . getConnection();
			String sql="select * from tb_user3";
			prestmt=conn.prepareStatement(sql);
			rs=prestmt.executeQuery( );
			
		while(rs. next()) {
				User user=new User(); 
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs. getString("email"));
				user.setBirthday(rs. getString("birthday"));
				list.add(user);
				
			}
		
		} catch (ClassNotFoundException e) {
		//TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SQLException e) {
		//TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(prestmt, conn, rs);
		}
		return list;

	}

	// 根据id查找指定的user
	public User find(int id) {
		// 补充代码
		Connection conn=null ;
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		
		User user=null;
		
		try {
				conn=JDBCUtils.getConnection();
				String sql="select * from tb_user3 where id=?";
				prestmt=conn. prepareStatement(sql);
				prestmt.setInt(1, id);
				rs=prestmt . executeQuery();
			if(rs.next()) {
					user=new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username") ) ;
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setBirthday(rs.getString( "birthday"));
			}
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
				e. printStackTrace();
			} catch (SQLException e) {
			//TODO Auto-generated catch block
				e. printStackTrace();
			}finally {
					JDBCUtils.release(prestmt, conn, rs);
			}
			return user;
	}

	// 删除用户
	public boolean delete(int id) {
		// 补充代码
		Connection conn=null ;
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		
		boolean success=false;
		
		try {
			conn= JDBCUtils.getConnection();
			String sql="delete from tb_user3 where id=?";
			prestmt=conn. prepareStatement(sql);
			prestmt.setInt(1, id);
			int num=prestmt . executeUpdate( );
		if(num>0)
				success=true;
		} catch (ClassNotFoundException e) {
		//TODO Auto-generated catch block
				e. printStackTrace();
		} catch (SQLException e) {
		//TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
				JDBCUtils .release(prestmt, conn, rs);
		}
		return success;

	}

	// 修改用户
	public boolean update(User user) {
		// 补充代码
		Connection conn=null;
		PreparedStatement prestmt=null;
		ResultSet rs=null;
		boolean success=false; 
		try {
			conn=JDBCUtils .getConnection();
			String sql="update tb_user3 set username=?,password=?,email=?,birthday=? where id=?";
			prestmt=conn. prepareStatement(sql);
			prestmt.setString(1, user. getUsername());
			prestmt.setString(2, user. getPassword());
			prestmt.setString(3, user. getEmail());
			prestmt.setString(4, user . getBirthday());
			prestmt.setInt(5, user . getId());
			int num=prestmt . executeUpdate( );
		if(num>0)
				success=true;
		} catch (ClassNotFoundException e) {
		//TODO Auto-generated catch block
				e. printStackTrace();	
		} catch (SQLException e) {
		//TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
				JDBCUtils.release(prestmt, conn, rs);
		}
		return success;

	}
}
