package cn.synu.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.synu.domain.User;
import cn.synu.user.service.UserService;
import cn.synu.utils.BaseServlet;

public class UserServlet extends BaseServlet {
	//声明userService
	private UserService service = new UserService();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		//声明User类
		User user = new User();
		//封装数据
		BeanUtils.populate(user,req.getParameterMap());
		//调用service保存
		service.save(user);
		//显示登录页面
		req.getSession().setAttribute("msg","你已经注册成功，请登录");
		return "302:login";
	}
	/**
	 * 提供用户登录
	 */
	public String login(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = new User();
		BeanUtils.populate(user,req.getParameterMap());
		//调用serivce
		User user2 = service.login(user);
		if(user2==null){
			//登录不成功。再去显示登录页面
			req.setAttribute("user",user);
			req.getSession().setAttribute("msg", "你的用户名或是密码错误");
			return "login";
		}else{
			//将用户放到session
			req.getSession().setAttribute("user", user2);
			return "302:succ";
		}
	}

}
