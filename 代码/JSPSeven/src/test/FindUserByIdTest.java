package test;

import bean.User;
import dao.UsersDao;

public class FindUserByIdTest{
	public static void main(String[] args) {
	UsersDao usersDao = new UsersDao();
	User user = usersDao.find(5);
	System.out.println("id为5的User对象的name值为："+user.getUsername());
   }
}
