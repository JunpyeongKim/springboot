package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("bookcats")
public class BookCategoryRestController {
    @Autowired
    BookCategoryRepository bookCategoryRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public BookCategory postBookCats(@RequestBody BookCategory bookCategory) {
        Iterator<Book> it = bookCategory.getBooks().iterator();
        while (it.hasNext()) {
            Book b = it.next();
            b.setBookCategory(bookCategory);
        }

        BookCategory created = bookCategoryRepository.save(bookCategory);

        it = created.getBooks().iterator();
        while (it.hasNext()) {
            Book b = it.next();
            b.setBookCategory(null);
        }

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookCategory> getBookCats() {
        List<BookCategory> bookCategories = bookCategoryRepository.findAll();

        Iterator<BookCategory> iterator = bookCategories.iterator();
        while (iterator.hasNext()) {
            BookCategory bc = iterator.next();
            Iterator<Book> it = bc.getBooks().iterator();
            while (it.hasNext()) {
                Book b = it.next();
                b.setBookCategory(null);
            }
        }

        return bookCategories;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public BookCategory getBookCat(@PathVariable Integer id) {
        BookCategory bookCategory = bookCategoryRepository.findOne(id);
        Iterator<Book> it = bookCategory.getBooks().iterator();
        while (it.hasNext()) {
            Book b = it.next();
            b.setBookCategory(null);
        }

        return bookCategory;
    }
}
