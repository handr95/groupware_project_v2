package com.swg.common.repository;

import com.swg.common.domain.BookStore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

}
