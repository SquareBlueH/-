package test;
import java.util.Date;

import bean.User;
import dao.UsersDao;
public class InsertUserTest{
	public static void main(String[] args) {
         // 向users表插入一个用户信息
		UsersDao ud = new UsersDao();
		User user=new User();
			user.setId(5);
			user.setUsername("hym");
			user.setPassword("1234");
			user.setEmail("hym@sina.com");
			user.setBirthday(new Date());
			boolean b=ud.insert(user);
			System.out.println(b);
		}
}
