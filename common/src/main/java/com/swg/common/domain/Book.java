package com.swg.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOOK_ID")
    private Long id;

    private String isbn;

    private String title;

    @ManyToOne
    @JoinColumn(name="BOOKSTORE_ID")
    private BookStore bookStore;
}
