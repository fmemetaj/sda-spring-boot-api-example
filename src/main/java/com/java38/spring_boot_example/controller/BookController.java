package com.java38.spring_boot_example.controller;

import com.java38.spring_boot_example.entity.Book;
import com.java38.spring_boot_example.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Book> getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("create")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book.getTitle(), book.getAuthor());
    }

    @PutMapping("update")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book.getId(),
                book.getTitle(),
                book.getAuthor());
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

}
