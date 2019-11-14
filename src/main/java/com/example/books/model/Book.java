package com.example.books.model;


import javax.persistence.*;
import javax.transaction.UserTransaction;
import java.util.List;

@Entity
@Table( name = "books")

public class Book {

    @Id private String isbn;
    private String title;
    private int year;

    public Book() {
    }

    public Book(String isbn, String title, int year) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
    }

    public String getisbn() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // crud data management methods

    public static void add(EntityManager em, UserTransaction ut,
                           String isbn, String title, int year) throws Exception {
        ut.begin();
        Book book = new Book( isbn, title, year);
        em.persist(book);
        ut.commit();
    }

    public static List<Book> retrieveAll( EntityManager em){
        Query query = em.createQuery( "SELECT b FROM Book b", Book.class);
        List<Book> books = query.getResultList();
        return books;
    }
    public static Book retrieve(){
        return null;
    }
    public static void update( EntityManager em,
                               UserTransaction ut, String isbn, String title,
                               int year) throws Exception {
        ut.begin();
        Book book = em.find( Book.class, isbn);
        if (!title.equals( book.getTitle())) book.setTitle( title);
        if (year != book.getYear()) book.setYear( year);
        ut.commit();
    }
    public static void destroy( EntityManager em,
                                UserTransaction ut, String isbn) throws Exception {
        ut.begin();
        Book book = em.find( Book.class, isbn);
        em.remove( book);
        ut.commit();
    }
    public static void clearData( EntityManager em,
                                  UserTransaction ut) throws Exception {
        ut.begin();
        Query deleteStatement = em.createQuery( "DELETE FROM Book");
        deleteStatement.executeUpdate();
        ut.commit();
    }
    public static void createTestData( EntityManager em,
                                       UserTransaction ut) throws Exception {
        Book book = null;
        Book.clearData( em, ut);  // first clear the books table
        ut.begin();
        book = new Book("006251587X","Weaving the Web", 2000);
        em.persist( book);
        book = new Book("0465026567","Gödel, Escher, Bach", 1999);
        em.persist( book);
        book = new Book("0465030793","I Am A Strange Loop", 2008);
        em.persist( book);
        ut.commit();
    }
}
