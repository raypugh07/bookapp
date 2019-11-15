package com.example.books.repository;

import com.example.books.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long > {

    ArrayList<Book> findBooksBytitleEquals(String title );

   /*Book findById(long id);

    void deleteById(long id);*/


}
