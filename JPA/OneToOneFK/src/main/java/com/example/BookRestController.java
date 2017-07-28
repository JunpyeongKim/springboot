package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * POST http://localhost:8081/books
 * Content-Type : application/json
 *
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
}
