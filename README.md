This is simple caffeine cache demo project in spring boot



adding @Caheable above method makes the method return value to cache


adding  @Caheable above class makes all method return value to cache

maven dependecies

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>
        <dependency>
            <groupId>com.github.ben-manes.caffeine</groupId>
            <artifactId>caffeine</artifactId>
        </dependency>
        
application.yml
spring
    cache:
        cache-names: name
        caffeine:
            spec: maximumSize=500, expireAfterAccess=3600s
