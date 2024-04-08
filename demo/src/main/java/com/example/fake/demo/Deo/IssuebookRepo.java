package com.example.fake.demo.Deo;

import org.springframework.data.repository.CrudRepository;

import com.example.fake.demo.entities.Issue_book_detail;

public interface IssuebookRepo extends CrudRepository<Issue_book_detail, Integer> {
    // public Issue_book_detail save(Issue_book_detail b);
}
