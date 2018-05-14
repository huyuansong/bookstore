package cn.synu.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.synu.address.service.AddressService;
import cn.synu.domain.Address;
import cn.synu.domain.Book;
import cn.synu.domain.Order;
import cn.synu.domain.OrderLine;
import cn.synu.domain.User;
import cn.synu.order.service.IOrderService;
import cn.synu.order.service.OrderService;
import cn.synu.utils.BaseServlet;
import cn.synu.utils.BookStoreUtils;
import cn.synu.utils.TxProxy;

public class OrderServlet extends BaseServlet {
	//声明AddressSerivce
	private AddressService addressService = new AddressService();
	//通过代理获取ordersercice
	private IOrderService service = (IOrderService) TxProxy.factory(new OrderService());
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		User user = (User) req.getSession().getAttribute("user");
		List<Address> list = addressService.queryAll(user.getId());
		//放到req
		req.setAttribute("address",list);
		return "order";
	}
	/**
	 * 接收
	 * 送货地址
	 */
	public String create(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		//根据接收的addrid查询这个地址 
		String addrId = req.getParameter("addr");
		Address addr = addressService.queryOne(addrId);
		String addrString = addr.getName()+","+addr.getAddr()+","+addr.getTel();
		
		User user = (User) req.getSession().getAttribute("user");
		
		//声明Order
		Order order = new Order();
		order.setAddr(addrString);
		order.setCtime(BookStoreUtils.date());
		order.setStat("0");
		order.setId(BookStoreUtils.order(order));
		order.setUid(user.getId());
		//声明总
		BigDecimal amount = new BigDecimal(0);
		//遍历所有的购物车的书
		Map<String,Book> car = (Map<String, Book>) req.getSession().getAttribute("car");
		for(Book b:car.values()){
			//一行就是一个明细
			OrderLine ol = new OrderLine();
			ol.setId(BookStoreUtils.uuid());
			ol.setBookid(b.getId());
			ol.setCont(b.getSum());
			BigDecimal a = new BigDecimal(b.getPrice());
			
			a = a.multiply(new BigDecimal(b.getRebate()));
			a = a.divide(new BigDecimal(1),BigDecimal.ROUND_HALF_UP);
			
			ol.setPrice(a.doubleValue());
			
			a = a.multiply(new BigDecimal(b.getSum()));
			amount=amount.add(a);
			
			//明细加到order
			order.getLines().add(ol);
		}
		order.setMoney(amount.doubleValue());
		service.create(order);
		req.getSession().removeAttribute("car");
		resp.getWriter().print("order ok and num is :"+order.getId());
		return null;
	}
}
