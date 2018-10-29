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
        log.info(bookStorageService.findNameById().get("DS-CS1"));
        log.info(bookStorageService.findNameById().get("DS-CS1"));

   }
}

