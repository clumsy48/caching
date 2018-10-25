package com.github.clumsy.caching.caffeine.service;

import com.github.clumsy.caching.caffeine.entity.Book;

import java.util.List;

public interface BookStorageService  {

    void save(Book book);

    List<Object[]> findNameAndauthor();

    Book findNameById(String id) throws InterruptedException;
}
