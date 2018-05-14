package cn.synu.buy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.synu.book.service.BookService;
import cn.synu.domain.Book;
import cn.synu.utils.BaseServlet;

public class BuyServlet extends BaseServlet {
	private BookService bookService = new BookService();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		//接收书的id
		String bookid = req.getParameter("bookid");
		System.err.println("bookid is:"+bookid);
		//放到购物车中去
		//根据map，在map中判断是否已经买过这本书，
		Map<String,Book> car = (Map<String, Book>) req.getSession().getAttribute("car");
		if(car==null){
			car = new HashMap<String, Book>();
			req.getSession().setAttribute("car", car);
		}
		if(car.get(bookid)==null){
			//根据这个id查询这本书的实例，
			Book book = bookService.detail(bookid);
			book.setSum(1);
			//放到car
			car.put(book.getId(), book);
		}else{
			Book bk = car.get(bookid);
			bk.setSum(bk.getSum()+1);
		}
		//去一个页面显示车的
		return "302:car";
	}
}
