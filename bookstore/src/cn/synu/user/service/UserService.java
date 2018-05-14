package cn.synu.user.service;

import cn.synu.domain.User;
import cn.synu.user.dao.UserDao;
import cn.synu.utils.BookStoreUtils;
import cn.synu.utils.PasswordUtils;

public class UserService {
	//声明dao
	private UserDao dao = new UserDao();
	public void save(User user) {
		//给user设置id
		user.setId(BookStoreUtils.uuid());
		user.setPwd(PasswordUtils.encodePassword(user.getName(), user.getPwd()));
		dao.save(user);
	}
	/**
	 * 再对密码进行计算
	 * @param user
	 * @return
	 */
	public User login(User user) {
		//只要用户名和密码是之前的，就会再加密
		user.setPwd(PasswordUtils.encodePassword(user.getName(), user.getPwd()));
		return dao.login(user);
	}

}
