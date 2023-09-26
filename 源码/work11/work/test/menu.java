package src.com.work.test;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.lang.reflect.Parameter;
import java.sql.*;
import java.util.Scanner;

public class menu {
	Connection con;
	Statement s; //预输入则换成private Statement方法
	ResultSet rs;
	Scanner reader = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/ex"
			+ "?serverTimezone=GMT%2B8&useSSL=false"
			+"&allowPublicKeyRetrieval=true"
			+"&allowMultiQueries=true";//"&allowMultiQueries=true"批量更新mysql
	String user = "root";
	String password = "123456";

	public menu() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");                          //加载数据库驱动
		con = DriverManager.getConnection(url, user, password);            //连接数据库
		s = con.createStatement();                 						   //创建查询语句实例
		// 显示菜单
		showmenu();
	}
	public void showmenu() throws SQLException //菜单
	{
		while (true) {
			System.out.println("请选择操作");
			System.out.println("1. 添加学生");
			System.out.println("2. 删除学生");
			System.out.println("3. 修改学生");
			System.out.println("4. 查看学生");
			System.out.println("5. 退出");
			int i = reader.nextInt(); //输入选择方法.nextInt输入整数

			switch(i)
			{
				case 1: Insert(); break;//插入
				case 2: delele(); break;//删除
				case 3: update(); break;//修改
				case 4: showtable(); break;//显示
				case 5: System.out.println("程序结束！");
				System.exit(0);//系统退出
				break;//退出
				default: continue; //忽略其他无关输入
			}
		}
	}

	void Insert()throws SQLException{
		String sname =null;
		String sex =null;
		int age =0;
 		reader.nextLine();//接收回车
		System.out.println("输入姓名");
		sname=reader.nextLine();
		System.out.println("输入性别");
		sex=reader.nextLine();
		System.out.println("输入年龄");
		age=reader.nextInt();
//		String[] sql =new String[3];
//		sql[0] = "INSERT INTO stu values (NULL,'"+sname+"','"+sex+"','"+age+"');";
//		sql[1] = "alter table stu drop sid";
//		sql[2] = "alter table stu add sid int not null primary key auto_increment first";
		String sql="INSERT INTO stu values (NULL,'"+sname+"','"+sex+"','"+age+"');"
				+"ALTER TABLE stu DROP sid;"
				+"ALTER TABLE stu ADD sid int not NULL PRIMARY KEY auto_increment FIRST;";
		//String sql="INSERT INTO stu VALUES sname='"+sname+"' and sex='"+sex+"' and age='"+age+"'";
		s.executeUpdate(sql); //插入学生数据，没有查询去掉前头
//		Connection con=null;
		System.out.println("添加成功");
	}
	void delele()throws SQLException{
		String sname =null;
		reader.nextLine();//接收回车
		System.out.println("输入要删除的学生姓名");
		sname=reader.nextLine();;
		String sql="DELETE FROM stu where (sname='"+sname+"');"
				+"ALTER TABLE stu DROP sid;"
				+"ALTER TABLE stu ADD sid int not NULL PRIMARY KEY auto_increment FIRST ;";
		s.executeUpdate(sql);//删除对应的学生姓名的数据
		System.out.println("删除成功");
	}
	void update()throws SQLException{
		String oldsname =null;
		String sname =null;
		String sex =null;
		int age =0;
		reader.nextLine();//接收回车
		System.out.println("输入要修改的学生姓名");
		oldsname=reader.nextLine();
		System.out.println("输入新姓名");
		sname=reader.nextLine();
		System.out.println("输入新性别");
		sex=reader.nextLine();
		System.out.println("输入新年龄");
		age=reader.nextInt();
		//更新要修改的学生姓名的数据
		String sql="UPDATE stu set sname='"+sname+"',sex='"+sex+"',age='"+age+"' where (sname='"+oldsname+"');";
		s.executeUpdate(sql);
		System.out.println("修改成功");
	}
	public void showtable() throws SQLException
	{
		System.out.println("学生表信息:");
		Connection con = DriverManager.getConnection(url,user,password);
		Statement s = con.createStatement();
		//+"alter table stu drop sid;"+"alter table stu add sid int not null primary key auto_increment first;"
		ResultSet rs = s.executeQuery("SELECT * from stu");
		 //将学生表的内容查到结果集
		while(rs.next()) {
			System.out.println(
					rs.getString("sid")+"  |	"+
					rs.getString("sname")+"  |	"
					+ rs.getString("sex")+"  |	"
					+ rs.getString("age"));
			}
			rs.close();
			con.close();
			// 循环打印字段信息
		System.out.println();
	}
}