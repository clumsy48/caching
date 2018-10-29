package com.github.clumsy.caching.caffeine.service;

import com.github.clumsy.caching.caffeine.entity.Book;
import com.github.clumsy.caching.caffeine.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookStorageServiceImpl implements BookStorageService {

    private final BookRepository bookRepository;
    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Cacheable("name")
    @Override
    public Map<String,String> findNameById() {
        log.info("db call");
        return IteratorUtils.toList(bookRepository
                .findAll()
                .iterator())
                .stream()
                .collect(Collectors.toMap(Book::getId,Book::getName));
    }
}
