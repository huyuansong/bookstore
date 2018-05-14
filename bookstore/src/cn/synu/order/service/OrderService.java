package cn.synu.order.service;

import cn.synu.domain.Order;
import cn.synu.order.dao.OrderDao;

public class OrderService implements IOrderService {
	private OrderDao dao = new OrderDao();
	public Order create(Order order){
		return dao.create(order);
	}
}
