package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	//查看所有图书
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
	
	//添加一本书籍
	@RequestMapping("/AddBook")
	public String AddBook(HttpServletRequest request, ModelMap mm) {
		String reg = request.getParameter("reg");
		if(reg == null){
			reg = "";
		}
		String bookname = request.getParameter("bookname");
		if(bookname == null){
			bookname = "";
		}
		String author = request.getParameter("author");
		if(author == null){
			author = "";
		}
		String price = request.getParameter("price");
		if(price == null){
			price = "";
		}
		int pri = 0;
		if(!price.equalsIgnoreCase("")){
			pri = Integer.valueOf(price);
		}
		if(reg == ""){
			return "addBook";
		}else{
			Book book = new Book();
			book.setName(bookname);
			book.setPrice(pri);
			book.setAuthor(author);
			try {
				bookbiz.AddBook(book);
				return "addBook";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "addBook";
			}
		}
	}
	
	
	//添加多本书籍
		@RequestMapping("/AddMoreBook")
		public String AddMoreBook(HttpServletRequest request, ModelMap mm) {
			String reg = request.getParameter("reg");
			if(reg == null){
				reg = "";
			}
			String bookname = request.getParameter("bookname");
			String bookname1 = request.getParameter("bookname1");
			if(bookname == null){
				bookname = "";
			}
			if(bookname1 == null){
				bookname1 = "";
			}
			String author = request.getParameter("author");
			String author1 = request.getParameter("author1");
			if(author == null){
				author = "";
			}
			if(author1 == null){
				author1 = "";
			}
			String price = request.getParameter("price");
			String price1 = request.getParameter("price1");
			if(price == null){
				price = "";
			}
			if(price1 == null){
				price1 = "";
			}
			int pri = 0;
			if(!price.equalsIgnoreCase("")){
				pri = Integer.valueOf(price);
			}
			
			int pri1 = 0;
			if(!price1.equalsIgnoreCase("")){
				pri1 = Integer.valueOf(price1);
			}
			if(reg == ""){
				return "addMoreBook";
			}else{
				Book book = new Book();
				book.setName(bookname);
				book.setPrice(pri);
				book.setAuthor(author);
				Book book1 = new Book();
				book1.setName(bookname1);
				book1.setPrice(pri1);
				book1.setAuthor(author1);
				
				List<Book> books = new ArrayList<Book>();
				books.add(book);
				books.add(book1);
				try {
					bookbiz.AddMoreBook(books);
					return "addMoreBook";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "addMoreBook";
				}
			}
		}

		//删除书籍
		@RequestMapping("/delOneBook")
		public String DelOneBook(HttpServletRequest request, ModelMap mm) {
			String id = request.getParameter("id");
			if(id == null){
				id = "";
			}
			if(id == ""){
				return "redirect:/BookController/getAllBook.do";
			}else{
				Book book = new Book();
				book.setId(Integer.valueOf(id));
				try {
					bookbiz.DelOneBook(book);
					return "redirect:/BookController/getAllBook.do";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "redirect:/BookController/getAllBook.do";
				}
				
			}
			
		}
		
	@RequestMapping("/index")
	public String Index() {
		return "list";
	}
}
