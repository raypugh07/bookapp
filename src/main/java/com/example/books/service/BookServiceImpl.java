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
    public Book update(Book book, long id) {

        Book currentBook = bookrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (book.getTitle()!= null) {

            currentBook.setTitle(book.getTitle());
        }
        return bookrepos.save(currentBook);
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException {

        if (bookrepos.findById(id).isPresent()){

            bookrepos.deleteById(id);

        }else {

            throw new EntityNotFoundException(Long.toString(id));
        }
    }



}
