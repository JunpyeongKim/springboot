package com.example;


import javax.persistence.*;
import java.util.Set;

@Entity
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    // Relationship
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookCategory")
    private Set<Book> books;

    public BookCategory() {
        System.out.println("BookCategory.init()");
    }

    public BookCategory(String name) {
        System.out.println("BookCategory.init(1)");
        this.name = name;
    }

    public BookCategory(String name, Set<Book> books) {
        System.out.println("BookCategory.init(2)");
        this.name = name;
        this.books = books;
    }


    public Integer getId() {
        System.out.println("BookCategory.getId()");
        return id;
    }

    public void setId(Integer id) {
        System.out.println("BookCategory.setId(): " + id);
        this.id = id;
    }

    public String getName() {
        System.out.println("BookCategory.getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("BookCategory.setName(): " + name);
        this.name = name;
    }

    public Set<Book> getBooks() {
        System.out.println("BookCategory.getBooks()");
        return books;
    }

    public void setBooks(Set<Book> books) {
        System.out.println("BookCategory.setBooks(): " + books.size());
        this.books = books;
    }

//    @Override
//    public String toString() {
//        return "BookCategory{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", books=" + books.size() +
//                '}';
//    }
}
