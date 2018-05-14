package cn.synu.order.dao;

import cn.synu.domain.Order;
import cn.synu.domain.OrderLine;
import cn.synu.utils.QueryRunner;
import static cn.synu.utils.DataSourceUtils.*;
public class OrderDao {

	public Order create(Order order) {
		QueryRunner run = new QueryRunner();
		String sql = "insert into orders(id,addr,money,stat,uid,ctime)" +
				     " values(?,?,?,?,?,?)";
		run.update(getConn(),sql,order.getId(),order.getAddr(),
				order.getMoney(),order.getStat(),order.getUid(),order.getCtime());
		sql = "insert into orderline(id,bookid,cont,price,orderid)" +
				" values(?,?,?,?,?)";
		for(OrderLine ol:order.getLines()){
			run.update(getConn(),sql,ol.getId(),ol.getBookid(),
							ol.getCont(),ol.getPrice(),
							order.getId());
		}
		return order;
	}
	
}
