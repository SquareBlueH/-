package src.com.work.test;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
//查看用户账号和密码
public class Main {
    public static  void main(String[] args)
        throws SQLException,ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/ex"
                +"?serverTimezone=GMT%2B8&useSSL=false";
        String user ="root";
        String password = "123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,user,password);
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * from admin");
        while (rs.next()){
            System.out.println(
                    rs.getString("aname") +","
                    + rs.getString("apass"));
        }
        rs.close();
        con.close();
    }
}