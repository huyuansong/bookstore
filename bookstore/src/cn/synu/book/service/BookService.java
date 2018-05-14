package cn.synu.book.service;

import java.util.List;

import cn.synu.book.dao.BookDao;
import cn.synu.domain.Book;

public class BookService {
	private BookDao dao = new BookDao();
	public List<Book> query(String typeid){
		return dao.query(typeid);
	}
	public Book detail(String bookid) {
		return dao.detail(bookid);
	}
}
