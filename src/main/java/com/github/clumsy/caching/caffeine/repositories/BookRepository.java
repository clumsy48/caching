package com.github.clumsy.caching.caffeine.repositories;

import com.github.clumsy.caching.caffeine.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book,String> {

    @Query("SELECT b.name, b.author from Book b")
    List<Object[]> findBooks();

}
