package com.example.lauribookstore.domain;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long>  {

	
}
