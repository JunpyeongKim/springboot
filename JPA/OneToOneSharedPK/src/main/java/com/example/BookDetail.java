package com.example;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Composite-id class must implement Serializable: com.example.BookDetail
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BookDetail implements Serializable {
//    @Id
//    private Integer book_id;
    private Integer numberOfPages;

    // Relationship
    @Id
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;


    public BookDetail(Integer numberOfPages) {
        System.out.println("BookDetail.init(1): " + numberOfPages);
        this.numberOfPages = numberOfPages;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book getBook() {
        System.out.println("BookDetail.getBook()");
        return book;
    }

    public void setBook(Book book) {
        System.out.println("BookDetail.setBook(): " + book);
        this.book = book;
    }
}
