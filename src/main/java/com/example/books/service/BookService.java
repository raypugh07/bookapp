package com.example.books.service;

import com.example.books.model.Book;

import java.util.ArrayList;

public interface BookService {

    ArrayList<Book> findAll();

   // ArrayList<Book> findByString(String isbn);

    Book save (Book book);

    ArrayList<Book> update(Book book, String isbn);

    void delete(String isbn);
}
