package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


/**
 * POST http://localhost:8082/books
 * Content-Type : application/json
 * {
 "name": "Book D",
 "bookDetail": {
 "numberOfPages": 79
 }
 }
 */

@RestController
@RequestMapping("books")
public class BookRestController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public String postBooks(@RequestBody Book book) {
        Book created = bookRepository.save(book);
        return "Success";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBooks() {
        List<Book> books = bookRepository.findAll();
//        books.stream(b -> b.bookDetail.setBook(null));
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            b.getBookDetail().setBook(null);
        }
        return books;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Integer id) {
        Book book = bookRepository.findOne(id);
        // TODO: Exception
        if (book != null) {
            book.getBookDetail().setBook(null);
        }

        return book;
    }
}
