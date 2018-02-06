package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.biz.BookBiz;
import com.demo.entity.Book;

@Controller
@RequestMapping("/BookController")
public class BookController {

	@Autowired
	private BookBiz bookbiz;

	@RequestMapping("/getAllBook")
	public String getAllBook(ModelMap mm) {
		List<Book> books = null;
		try {
			books = bookbiz.getAllBook();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		mm.addAttribute("books", books);
		return "book";
	}

//	@RequestMapping("/index")
//	public String Index() {
//		return "redirect:/UserController/getAllUser";
//	}
	
	@RequestMapping("/index")
	public String Index() {
		return "list";
	}
}
