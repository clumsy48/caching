package com.github.clumsy.caching.caffeine.repositories;

import com.github.clumsy.caching.caffeine.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book,String> {

    @Query("SELECT b.name from Book b where b.id =:bId")
    String findNameById(@Param("bId")String bId);

}
