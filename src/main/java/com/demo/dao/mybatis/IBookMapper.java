package com.demo.dao.mybatis;

import java.util.List;

import com.demo.entity.Book;

public interface IBookMapper {

	public List<Book> getAllBook() throws Exception;
}
