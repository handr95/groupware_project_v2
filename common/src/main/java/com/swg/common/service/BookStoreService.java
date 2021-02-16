package com.swg.common.service;

import com.swg.common.domain.BookStore;
import com.swg.common.repository.BookStoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    @Autowired
    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }
    public BookStore save(BookStore _book) {
        BookStore book = bookStoreRepository.save(_book);
        return book;
    }
}
