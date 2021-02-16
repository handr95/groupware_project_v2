package com.swg.common.service;

import com.swg.common.domain.Book;
import com.swg.common.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book save(Book _book) {
        Book book = bookRepository.save(_book);
        return book;
    }
}
