package com.example.books.controller;


import com.example.books.model.Book;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.transaction.UserTransaction;
import java.util.List;

public class BookController {

    @PersistenceContext( unitName = "MinimalApp")
            private EntityManager em;
    @Resource()
    UserTransaction ut;

    public List<Book> getBooks() {
    }

    public void refreshObject(Book book) {
    }

    public String add(String isbn, String title,
                      int year) {
        try{
            Book.add( em, ut, isbn, title, year);
            //clear the formaftersaving the book record
            FacesContext fContext = FacesContext.getCurrentInstance();
            fContext.getExternalContext().getRequestMap().remove("book");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "create";
    }

    public String update(String isbn,
                         String title, int year) {
    }

    public String destroy(String isbn) {
    }

  /*  EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("MinimalApp");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();*/
}
