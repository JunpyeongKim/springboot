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
public class OneToOneFkApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(OneToOneFkApplication.class);

    @Autowired
    BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneFkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Book A", new BookDetail(49)));
		books.add(new Book("Book B", new BookDetail(59)));
		books.add(new Book("Book C", new BookDetail(69)));

        bookRepository.save(books);

        for (Book book : bookRepository.findAll()) {
            logger.info(book.toString());
        }
	}
}
