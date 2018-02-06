package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.mybatis.IBookMapper;
import com.demo.entity.Book;

@Repository("/bookdao")
public class BookDao {
	
	@Autowired
	private IBookMapper bookMapper;
	
	public List<Book> getAllBook() throws Exception{
		List<Book> books = null;
		books = bookMapper.getAllBook();
		return books;
	}

}
