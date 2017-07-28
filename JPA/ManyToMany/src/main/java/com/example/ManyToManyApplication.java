package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ManyToManyApplication.class);

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Publisher publisherA = new Publisher("Publisher A");
		Publisher publisherB = new Publisher("Publisher B");
		Publisher publisherC = new Publisher("Publisher C");

		bookRepository.save(new HashSet<Book>(){{
			add(new Book("Book A", new HashSet<Publisher>(){{
				add(publisherA);
				add(publisherB);
			}}));

			add(new Book("Book B", new HashSet<Publisher>(){{
				add(publisherA);
				add(publisherC);
			}}));
		}});

		for(Book book : bookRepository.findAll()) {
			logger.info(book.toString());
		}

		Book bookA = new Book("Book A");
		Book bookB= new Book("Book B");

		publisherRepository.save(new HashSet<Publisher>(){{
			add(new Publisher("Publisher A", new HashSet<Book>() {{
				add(bookA);
				add(bookB);
			}}));

			add(new Publisher("Publisher B", new HashSet<Book>() {{
				add(bookA);
				add(bookB);
			}}));
		}});

		for (Publisher publisher : publisherRepository.findAll()) {
			logger.info(publisher.toString());
		}
	}
}
