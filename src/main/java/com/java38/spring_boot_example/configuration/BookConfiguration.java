package com.java38.spring_boot_example.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java38.spring_boot_example.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfiguration {

    @Bean
    public Book book() {
        return new Book();
    }
}
