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
import com.example.lauribookstore.domain.User;
import com.example.lauribookstore.domain.UserRepository;



@SpringBootApplication
public class LauribookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(LauribookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LauribookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple books");
			
			
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Fiction"));
			
			repository.save(new Book("Harry Potter", "JK Rowling", 2005, "951-98548-9-4", 20.20, crepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Lord of the rings", "Tolkien", 1998, "951-98548-9-1", 30.50, crepository.findByName("Fiction").get(0)));
			
			// Create users: admin/admin user/user
			User user1 = new User("user",
			"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin",
			"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
