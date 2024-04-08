package com.example.fake.demo.Deo;

import org.springframework.data.repository.CrudRepository;

import com.example.fake.demo.entities.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
