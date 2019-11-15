package com.example.books;


import com.example.books.model.Book;
import com.example.books.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    BookRepository bookrepos;

    public SeedData(BookRepository bookrepos){

        this.bookrepos=bookrepos;

    }

    @Override
    public void run(String[]args) throws Exception {





    }
}
