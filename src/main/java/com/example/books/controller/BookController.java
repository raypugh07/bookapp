package com.example.books.controller;


import com.example.books.model.Book;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.transaction.UserTransaction;
import java.util.List;

@RestController
@RequestMapping(value = "/")

public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }


}
