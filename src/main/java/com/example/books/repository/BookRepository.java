package com.example.books.repository;

import com.example.books.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, String > {

    ArrayList<Book> findBooksByBookitemEquals(String title );

    ArrayList<Book> findByString(String isbn);

    void deleteByString(String isbn);
}
