package com.springframework.springwebapp.services;

import com.springframework.springwebapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
