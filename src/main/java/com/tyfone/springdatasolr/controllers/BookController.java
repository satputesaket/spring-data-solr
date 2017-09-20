package com.tyfone.springdatasolr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyfone.springdatasolr.pojos.Book;
import com.tyfone.springdatasolr.services.BookServices;


@RestController
public class BookController {

	@Autowired
	BookServices bookService;
	
	@RequestMapping(value="/books" ,method = RequestMethod.GET)
	public List<Book> getAllBooks(@RequestParam("bookName")String name){
		System.out.println(name);
		return bookService.getAllBooks(name);
	}
	
	@RequestMapping(value="/book-by-author-or-cat" ,method = RequestMethod.GET)
	public List<Book> getAllBooksByAuthorOrCat(@RequestParam("cat")String cat, @RequestParam("author")String author){
		return bookService.getBooksByCatOrAuthor(cat, author);
	}
	
	@RequestMapping(value="/book-by-author-or-name" ,method = RequestMethod.GET)
	public Page<Book> getAllBooksByAuthorOrName(@RequestParam("bookName")String name, @RequestParam("author")String author){
//		return bookService.getBooksByCatOrAuthor(cat, author);
		return bookService.getBooksByNameOrAuthor(name, author);
	}
}
