package cn.synu.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.synu.domain.Types;
import cn.synu.types.service.TypeService;
import cn.synu.utils.BaseServlet;

public class IndexServlet extends BaseServlet {
	private TypeService service = new TypeService();
	/**
	 * 去显示主页
	 * 要查询出所有的图书分类
	 */
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		List<Types> types = service.queryAll();
		//封装到req
		req.setAttribute("types",types);
		return "index";
	}
}
