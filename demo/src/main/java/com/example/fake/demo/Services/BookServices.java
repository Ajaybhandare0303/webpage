package com.example.fake.demo.Services;

import java.util.List;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fake.demo.Deo.BookRepo;
import com.example.fake.demo.entities.Book;

@Component
public class BookServices {
    @Autowired
    private BookRepo bookRepo;

    // @Autowired
    // private IssuebookRepo issuebookRepo;

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepo.findAll();
        return list;
    }

    public Book addBook(Book bk) {
        return this.bookRepo.save(bk);
    }

    public Book getBookById(int id) {
        Book book = bookRepo.findById(id);
        return book;
    }

    public Book getRemoveBookById(int id) {
        Book book = bookRepo.findById(id);
        bookRepo.delete(book);
        return book;
    }

    public Book issued_book(int id) {
        // Issue_book_detail issue_book_detail=new Issue_book_detail();
        Book book = bookRepo.findById(id);

        // int bk_id = book.getId();
        // int Student_id = student_id;
        // this.issuebookRepo.save(null);
        this.bookRepo.delete(book);
        return book;
    }

}
