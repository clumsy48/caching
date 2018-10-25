package com.github.clumsy.caching.caffeine;

import com.github.clumsy.caching.caffeine.service.BookStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableJpaRepositories("com/github/clumsy/caching/caffeine/repositories")
@EntityScan("com/github/clumsy/caching/caffeine/entity")
public class Application implements CommandLineRunner {

    private final BookStorageService bookStorageService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*bookStorageService.save(new Book("DS-CS3", "The Algorithm Design Manual", "Steven S. Skiena"));
        bookStorageService.save(new Book("DS-CS1", "DS and ALGO Made Easy", "Narasimha k."));
        bookStorageService.save(new Book("DS-CS2", "CLRS", "Cormen"));//persist object*/
        /*List<Object[]> list = bookStorageService.findNameAndauthor();        // get list of key value pairs
        list.forEach(objects -> {
            System.out.println("key : " + (String) objects[0] + " value : " + (String) objects[1]);
        });*/
        log.info(bookStorageService.findNameById("DS-CS1").toString());
        log.info(bookStorageService.findNameById("DS-CS1").toString());
        log.info(bookStorageService.findNameById("DS-CS1").toString());
        log.info(bookStorageService.findNameById("DS-CS2").toString());
        log.info(bookStorageService.findNameById("DS-CS1").toString());
        log.info(bookStorageService.findNameById("DS-CS1").toString());
    }
}

