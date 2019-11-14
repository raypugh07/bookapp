package com.example.books.service;


import com.example.books.model.Book;
import com.example.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "bookservice")

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookrepos;

    @Override
    public ArrayList<Book> findAll(){

        ArrayList<Book> list= new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Book save(Book book){

        Book newBook=new Book();

        newBook.setTitle(book.getTitle());

        return bookrepos.save(newBook);
    }

    @Override
    public ArrayList<Book> update(Book book, String isbn) {

        ArrayList<Book> currentBook = bookrepos.findByString(isbn);

        return currentBook;

    }

    @Transactional
    @Override
    public void delete(String isbn) throws EntityNotFoundException {

        if (bookrepos.findByString(isbn)){
            bookrepos.deleteByString(isbn);
        }else {
            throw new EntityNotFoundException(isbn);
        }
    }


}
