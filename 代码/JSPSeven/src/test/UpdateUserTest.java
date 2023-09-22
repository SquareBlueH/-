package test;

import java.util.Date;

import bean.User;
import dao.UsersDao;
public class UpdateUserTest {
	public static void main(String[] args) {
		// 修改User对象的数据
		UsersDao usersDao = new UsersDao();
		User user = new User();
		user.setId(5);
		user.setUsername("hanyongmeng");
		user.setPassword("123456");
		user.setEmail("hanyongmeng@sina.com");
		user.setBirthday(new Date());
		boolean b = usersDao.update(user);
		System.out.println(b);
	}
}
