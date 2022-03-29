package com.example.lauribookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.lauribookstore.domain.Book;
import com.example.lauribookstore.domain.BookRepository;
import com.example.lauribookstore.domain.Category;



@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Harry Potter");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("JK Rowling");

	}

	@Test
	public void createNewBook() {
		Book book = new Book("Tuntematon sotilas", "Väinö Linna", 1954, "951-98548-9-9", 30.10,
				new Category("History"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteNewBook() {
		List<Book> books = repository.findByTitle("Harry Potter");
		Book book = books.get(0);
		repository.delete(book);
		List<Book> newBooks = repository.findByTitle("Harry Potter");
		assertThat(newBooks).hasSize(0);
	}

}
