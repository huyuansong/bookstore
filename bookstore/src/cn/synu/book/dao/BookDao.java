package cn.synu.book.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.synu.domain.Book;
import cn.synu.utils.QueryRunner;
import static cn.synu.utils.DataSourceUtils.*;
public class BookDao {
	/**
	 * 查询所有图书
	 * 参数为类型id
	 */
	public List<Book> query(String typeid){
		String sql = "select * from books";
		if(typeid!=null){
			sql = "select b.* from books b inner join booktype bt on b.id=bt.bookid" +
					" where bt.typeid='"+typeid+"'";
		}
		QueryRunner run = new QueryRunner(getDatasSource());
		List<Book> list = run.query(sql,new BeanListHandler<Book>(Book.class));
		return list;
	}
	/**
	 * 查询一本书
	 */
	public Book detail(String bookid) {
		String sql = "select * from books where id=?";
		QueryRunner run = new QueryRunner(getDatasSource());
		Book book = run.query(sql,new BeanHandler<Book>(Book.class),bookid);
		return book;
	}
}
