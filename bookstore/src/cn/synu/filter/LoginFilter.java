package cn.synu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 验证用户是否已经登录
 *
 */
public class LoginFilter implements Filter{
	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//转化成hreq
		HttpServletRequest hreq = (HttpServletRequest) req;
		if(hreq.getSession().getAttribute("user")==null){
			if(hreq.getRequestURI().contains("BuyServlet")){
				String bookid = req.getParameter("bookid");
				hreq.getSession().setAttribute("bookid",bookid);
			}
			//向session中放入一个信息
			hreq.getSession().setAttribute("msg", "你还没有登录，请先登录");
			//重定向
			HttpServletResponse hresp = (HttpServletResponse) resp;
			hresp.sendRedirect(hreq.getContextPath()+"/jsps/user/login.jsp");
		}else{
			chain.doFilter(hreq, resp);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
