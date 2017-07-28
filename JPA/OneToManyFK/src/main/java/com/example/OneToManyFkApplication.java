package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class OneToManyFkApplication implements CommandLineRunner {
	@Autowired
	BookCategoryRepository bookCategoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToManyFkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		BookCategory bookCategoryA = new BookCategory("Category A", new HashSet<Book>(){{
//			add(new Book("Book A1"));
//			add(new Book("Book A2"));
//			add(new Book("Book A3"));
//		}});

//		BookCategory bookCategoryB = new BookCategory("Category B", new HashSet<Book>(){{
//			add(new Book("Book B1"));
//			add(new Book("Book B2"));
//			add(new Book("Book B3"));
//		}});

//		bookCategoryRepository.save(new HashSet<BookCategory>() {{
//			add(bookCategoryA);
//			add(bookCategoryB);
//		}});

		final BookCategory bookCategoryA = new BookCategory("Category A");
		bookCategoryA.setBooks(new HashSet<Book>(){{
			add(new Book("Book A1", bookCategoryA));
			add(new Book("Book A2", bookCategoryA));
			add(new Book("Book A3", bookCategoryA));
		}});

		bookCategoryRepository.save(bookCategoryA);

	}
}
