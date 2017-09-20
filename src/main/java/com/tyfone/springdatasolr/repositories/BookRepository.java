package com.tyfone.springdatasolr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.repository.Boost;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.tyfone.springdatasolr.pojos.Book;
import java.util.*;


public interface BookRepository extends SolrCrudRepository<Book, String> {
	
	
	
	public List<Book> findByName(String name);
	
	public List<Book> findByCatOrAuthor(@Boost(2) String cat, String author);


	public Page<Book> findByNameOrAuthor(String name, String author, Pageable pageable);
	
//	@Query("name:?0")
//	@Facet(fields = { "categories_txt" }, limit = 5)
//	FacetPage<Book> findByNameAndFacetOnCategories(String name, Pageable page);

}
