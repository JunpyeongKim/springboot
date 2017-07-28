package com.example;


import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    // Relationship
    @ManyToOne
    @JoinColumn
    private BookCategory bookCategory;

    public Book() {
        System.out.println("Book.init()");
    }

    public Book(String name) {
        System.out.println("Book.init(1) : " + name);
        this.name = name;
    }

    public Book(String name, BookCategory bookCategory) {
        System.out.println("Book.init(2)");
        this.name = name;
        this.bookCategory = bookCategory;
    }

    public Integer getId() {
        System.out.println("Book.getId()");
        return id;
    }

    public void setId(Integer id) {
        System.out.println("Book.setId(): " + id);
        this.id = id;
    }

    public String getName() {
        System.out.println("Book.getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("Book.setName(): " + name);
        this.name = name;
    }

    public BookCategory getBookCategory() {
        System.out.println("Book.getBookCategory()");
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {

        System.out.println("Book.setBookCategory(): ");
        this.bookCategory = bookCategory;
    }
}
