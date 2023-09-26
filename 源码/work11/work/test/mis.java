package src.com.work.test;
import java.sql.*; 
import java.util.Scanner;
public class mis{
public static void main(String[] args)
        throws SQLException, ClassNotFoundException {
 Scanner reader=new Scanner(System.in);
 System.out.println("欢迎登录简易学生信息管理系统！");
 System.out.println("请输入用户名");
 String aname =new String(reader.nextLine());
 System.out.println("请输入密码");
 String apass =new String(reader.nextLine());
 //定义了数据库连接串
 String url ="jdbc:mysql://localhost:3306/ex"
         +"?serverTimezone=GMT%2B8&useSSL=false";
//数据库的用户名 
 String user ="root";
//数据库的用户口令 
 String password ="123456";
//加载jdbc驱动程序
 Class.forName("com.mysql.cj.jdbc.Driver");
// 与url指定的数据源建立连接
 Connection con = DriverManager.getConnection(url,user,password);
//采用Statement进行查询
 Statement s = con.createStatement();
 String sql="SELECT  *  FROM admin  WHERE aname=? and apass=?";
 PreparedStatement ps=con.prepareStatement(sql);
 ps.setString(1,aname);
ps.setString(2,apass);
ResultSet rs=ps.executeQuery();
// 查询是否存在用户名和密码都对的人
       if(rs.next()) {
// 如存在打印字段信息 
          System.out.println("登陆成功！");
          new menu(); // 初始化菜单类
       } else { System.out.println("用户名或密码错误，程序结束！");
       }
        //关闭资源
        ps.close();
       con.close();
       }
}