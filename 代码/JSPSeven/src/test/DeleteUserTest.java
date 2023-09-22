package test;

import dao.UsersDao;

public class DeleteUserTest{
	public static void main(String[] args) {
		// 删除操作
		UsersDao usersDao = new UsersDao();
		boolean b = usersDao.delete(5);
		System.out.println(b);
	}
}
