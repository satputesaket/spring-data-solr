package com.tyfone.springdatasolr.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.tyfone.springdatasolr.pojos.Book;

public interface BookServices {
	public List<Book> getAllBooks(String name); 
	public Page<Book> getBooksByNameOrAuthor(String name, String author);
	public List<Book> getBooksByCatOrAuthor(String cat, String author);
}
