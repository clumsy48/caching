package com.github.clumsy.caching.caffeine.service;

        import com.github.clumsy.caching.caffeine.entity.Book;

        import java.util.Map;

public interface BookStorageService  {

    void save(Book book);

    Map<String,String> findNameById();
}
