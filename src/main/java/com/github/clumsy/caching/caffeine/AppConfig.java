package com.github.clumsy.caching.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cglib.core.internal.LoadingCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Configuration
public class AppConfig {

    @Value("${caffeinceSpec}")
    private String spec;
    @Bean
    public CacheManager cacheManager() {

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        CaffeineCache stringStringCache = new CaffeineCache("name", Caffeine.from(spec)
                .build());

        simpleCacheManager.setCaches(Collections.singleton(stringStringCache));
        return simpleCacheManager;
    }
}


