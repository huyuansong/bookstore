package cn.synu.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 多处理的Servlet
 * 接收cmd参数，默认值为execute
 * @author huyuansong
 */
public abstract class BaseServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String methodName = req.getParameter("cmd");
		if(methodName==null || methodName.trim().equals("")){
			methodName="execute";
		}
		try{
			Method method = this.getClass()
								.getMethod(methodName,
										HttpServletRequest.class,
										HttpServletResponse.class);
			Object result = method.invoke(this,req,resp);
			//这个返回值有可以是null
			if(result!=null){
				//处理转发
				boolean redirect = false;
				String key = result.toString();//index
				if(key.startsWith("302:")){
					key = key.split(":")[1];
					redirect=true;
				}
				//调用PageUtils页面读取key对应的page
				String page =PageUtils.getPage(key);
				if(page==null){
					throw new RuntimeException("你可以没有配置key:"+key);
				}else{
					if(redirect){
						resp.sendRedirect(req.getContextPath()+page);
					}else{
						req.getRequestDispatcher(page).forward(req, resp);
					}
					
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * 这个返回值，就是指的在views.properties文件中的一个key
	 */
	public abstract String execute(HttpServletRequest req,HttpServletResponse resp)
			throws Exception;
}
