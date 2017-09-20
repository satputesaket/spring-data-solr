package com.tyfone.springdatasolr.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tyfone.springdatasolr.pojos.Book;
import com.tyfone.springdatasolr.repositories.BookRepository;
import com.tyfone.springdatasolr.services.BookServices;

@Service
public class BookServicesImpl implements BookServices {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks(String name) {
		return bookRepository.findByName(name);
	}

	@Override
	public Page<Book> getBooksByNameOrAuthor(String name, String author) {
		return bookRepository.findByNameOrAuthor(name, author, new PageRequest(0, 5));
	}
	
	
	@Override
	public List<Book> getBooksByCatOrAuthor(String cat, String author) {
		// TODO Auto-generated method stub
		return bookRepository.findByCatOrAuthor(cat, author);
	}

}
