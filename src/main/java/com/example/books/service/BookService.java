package com.example.books.service;

import com.example.books.model.Book;

import java.util.ArrayList;

public interface BookService {

    ArrayList<Book> findAll();

   // Book findById(long id);

   // ArrayList<Book> findByString(String isbn);

    Book save (Book book);

    Book update(Book book, long id);

    void delete(long id);
}
