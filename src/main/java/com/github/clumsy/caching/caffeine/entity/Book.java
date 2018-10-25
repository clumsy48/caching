package com.github.clumsy.caching.caffeine.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "book_id" , nullable = false)
    private String id;
    @Column(name = "book_name")
    private String name;
    @Column(name = "author")
    private String author;

    public Book() {
    }

    public Book(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
