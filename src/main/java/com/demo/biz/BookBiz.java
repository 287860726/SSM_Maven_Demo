package com.demo.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.BookDao;
import com.demo.entity.Book;

@Service("/bookbiz")
public class BookBiz {

	@Autowired
	private BookDao bookdao;

	public List<Book> getAllBook() throws Exception {
		List<Book> books = null;
		books = bookdao.getAllBook();
		return books;
	}
	
	public boolean AddBook(Book book) throws Exception {
		try {
			bookdao.AddBook(book);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean DelOneBook(Book book) throws Exception {
		try {
			bookdao.DelOneBook(book);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean AddMoreBook(List<Book> books) throws Exception {
		try {
			bookdao.AddMoreBook(books);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
