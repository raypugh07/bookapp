package com.example.books.service;


import com.example.books.BooksApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith( SpringRunner.class )
@SpringBootTest(classes = BooksApplication.class )
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findAll() {

        assertEquals(1,bookService.findAll().size());
    }
}
