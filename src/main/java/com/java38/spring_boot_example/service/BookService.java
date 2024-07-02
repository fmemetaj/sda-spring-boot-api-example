package com.java38.spring_boot_example.service;

import com.java38.spring_boot_example.entity.Book;
import com.java38.spring_boot_example.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(String title, String author) {
        Book book = new Book(title, author);
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, String title, String author) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            return null;
        }

        Book updateBook = book.get();
        updateBook.setTitle(title);
        updateBook.setAuthor(author);

        return bookRepository.save(updateBook);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
