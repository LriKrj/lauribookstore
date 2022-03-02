package com.example.lauribookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.lauribookstore.domain.Book;
import com.example.lauribookstore.domain.BookRepository;
import com.example.lauribookstore.domain.Category;
import com.example.lauribookstore.domain.CategoryRepository;



@SpringBootApplication
public class LauribookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(LauribookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LauribookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple books");
			
			
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Fiction"));
			
			repository.save(new Book("Harry Potter", "JK Rowling", 2005, "951-98548-9-4", 20.20, crepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Lord of the rings", "Tolkien", 1998, "951-98548-9-1", 30.50, crepository.findByName("Fiction").get(0)));
			
			
			
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
