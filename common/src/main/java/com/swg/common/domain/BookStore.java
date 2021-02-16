package com.swg.common.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOOKSTORE_ID")
    private Long id;

    private String nm;

    @OneToMany(mappedBy = "bookStore")
    private Set<Book> books = new HashSet<>();

    void add(Book _book) {
        this.books.add(_book);
    }
}
