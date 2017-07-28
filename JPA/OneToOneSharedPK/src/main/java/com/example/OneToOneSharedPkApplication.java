package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OneToOneSharedPkApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(OneToOneSharedPkApplication.class);

    @Autowired
    private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneSharedPkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Book> books = new ArrayList<Book>();

        books.add(new Book("Book A", new BookDetail(49)));
        books.add(new Book("Book B", new BookDetail(59)));
        books.add(new Book("Book C", new BookDetail(69)));

        bookRepository.save(books);
	}
}
