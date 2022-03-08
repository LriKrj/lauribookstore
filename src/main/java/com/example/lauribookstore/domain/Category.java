package com.example.lauribookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Category() {
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	
	
	public Category(Long categoryid, String name, List<Book> books) {
		super();
		this.categoryid = categoryid;
		this.name = name;
		this.books = books;
	}

	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryId) {
		this.categoryid = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryid + ", name=" + name + "]";
	}
		
	
}