package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	// 加载驱动，并建立数据库连接
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
         //补充代码
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/studb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT%2B8";
		String user="root";
		String password="123456";
		Connection connection=DriverManager.getConnection(url, user, password);
		return connection;
	}
	// 关闭数据库连接，释放资源
	public static void release(PreparedStatement prestmt, Connection conn,ResultSet rs) {
       //补充代码
		try {
			if (rs!=null) 
				rs.close();
				if (prestmt!=null) 
					prestmt.close();
					if (conn!=null) 
						conn.close();	
		} catch (SQLException e) {
			// TODO: handle exception
				e.printStackTrace();
		}
		}
}