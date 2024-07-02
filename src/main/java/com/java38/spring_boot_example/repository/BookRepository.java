package com.java38.spring_boot_example.repository;

import com.java38.spring_boot_example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
