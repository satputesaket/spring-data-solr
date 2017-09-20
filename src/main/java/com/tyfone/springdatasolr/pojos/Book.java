package com.tyfone.springdatasolr.pojos;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Dynamic;
import org.springframework.stereotype.Component;


@Component
public class Book {

	@Field
	private String id;
	
	@Field
	private String name;
	
	@Field
	private String author;
	
	@Field
	private List<String> cat;
	
	@Field
	private double price;
	
	@Field
	private boolean inStock;
	
	@Dynamic @Field("*_t")
	private Map<String, Object> dynamicTextFields;
	
	@Dynamic @Field("*_i")
	private Map<String, Object> dynamicIntegerFields;
	
	@Dynamic @Field("*_s")
	private  Map<String, Object> dynamicStringFields;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<String> getCat() {
		return cat;
	}

	public void setCat(List<String> cat) {
		this.cat = cat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public Map<String, Object> getDynamicTextFields() {
		return dynamicTextFields;
	}

	public void setDynamicTextFields(Map<String, Object> dynamicTextFields) {
		this.dynamicTextFields = dynamicTextFields;
	}

	public Map<String, Object> getDynamicIntegerFields() {
		return dynamicIntegerFields;
	}

	public void setDynamicIntegerFields(Map<String, Object> dynamicIntegerFields) {
		this.dynamicIntegerFields = dynamicIntegerFields;
	}

	public Map<String, Object> getDynamicStringFields() {
		return dynamicStringFields;
	}

	public void setDynamicStringFields(Map<String, Object> dynamicStringFields) {
		this.dynamicStringFields = dynamicStringFields;
	}
	
	
	
	
}
