package com.example.fake.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fake.demo.Services.BookServices;
import com.example.fake.demo.entities.Book;

@RestController
public class Controller {
    @Autowired
    private BookServices bookServices;

    int student_id = 777;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list = bookServices.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addnewBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookServices.addBook(book);
            System.out.println(book);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/books/{id}")
    public Book getBookByID(@PathVariable("id") int id) {
        return this.bookServices.getBookById(id);
    }

    @DeleteMapping("/books/{id}")
    public Book getdeletBookByID(@PathVariable("id") int id) {
        return this.bookServices.getRemoveBookById(id);
    }

    @GetMapping("/book/issued_book_id/{issued_book_id}")
    public ResponseEntity<Book> issud_bk(@PathVariable("issued_book_id") int id) {
        try {
            this.bookServices.issued_book(id);
            // this.issuebookRepo.save(id);
            System.out.println("Book issued sucessfully");
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
