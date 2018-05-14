package cn.synu.order.service;

import cn.synu.domain.Order;
import cn.synu.utils.Tx;

public interface IOrderService {
	@Tx
	Order create(Order order);
}