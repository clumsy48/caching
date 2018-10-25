package com.github.clumsy.caching.caffeine.service;

import com.github.clumsy.caching.caffeine.entity.Book;
import com.github.clumsy.caching.caffeine.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookStorageServiceImpl implements BookStorageService {

    private final BookRepository bookRepository;
    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Object[]> findNameAndauthor() {
        return bookRepository.findBooks();
    }

    @Cacheable(value = "name" ,sync=true)
    public Book findNameById(String id)  {
        log.info("db call");
        return bookRepository.findById(id).get();
    }
}
