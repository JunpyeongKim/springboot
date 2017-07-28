package com.example;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    // Relationship
//    private Integer bookDetailId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk")
    private BookDetail bookDetail;

    public Book(String name, BookDetail bookDetail) {
        this.name = name;
        this.bookDetail = bookDetail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookDetail=" + bookDetail.getNumberOfPages() +
                '}';
    }
}
