package cn.synu.user.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.synu.domain.User;
import cn.synu.utils.QueryRunner;
import static cn.synu.utils.DataSourceUtils.*;
public class UserDao {

	public void save(User user) {
		String sql = "insert into users(id,name,pwd,mail) values(?,?,?,?)";
		QueryRunner run = new QueryRunner(getDatasSource());
		run.update(sql,user.getId(),user.getName(),user.getPwd(),user.getMail());
	}

	public User login(User user) {
		String sql = "select * from users where name=? and pwd=?";
		QueryRunner run = new QueryRunner(getDatasSource());
		User user2 = run.query(sql,new BeanHandler<User>(User.class),user.getName(),user.getPwd());
		return user2;
	}

}
