package com.example;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer numberOfPages;

    // Relationship
    @OneToOne(mappedBy = "bookDetail")
    private Book book;

    public BookDetail(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
