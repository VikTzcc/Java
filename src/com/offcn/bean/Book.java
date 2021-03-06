package com.offcn.bean;

import java.util.Date;

public class Book {
    //id int primary key AUTO_INCREMENT,
    //  booknum varchar(100),
    //  bookname varchar(100),
    //  bookauthor varchar(100),
    //  bookpublish varchar(100),
    //  bookdate date,
    //  bookprice int
    private int id;
    private String booknum;
    private String bookname;
    private String bookauthor;
    private String bookpublish;
    private Date bookdate;
    private int bookprice;
    
    private int b;

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", booknum=" + booknum +
                ", bookname='" + bookname + '\'' +
                ", bookauthor='" + bookauthor + '\'' +
                ", bookpublish='" + bookpublish + '\'' +
                ", date=" + bookdate +
                ", bookprice=" + bookprice +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooknum() {
        return booknum;
    }

    public void setBooknum(String booknum) {
        this.booknum = booknum;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookpublish() {
        return bookpublish;
    }

    public void setBookpublish(String bookpublish) {
        this.bookpublish = bookpublish;
    }

    public Date getBookdate() {
        return bookdate;
    }

    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }

    public int getBookprice() {
        return bookprice;
    }

    public void setBookprice(int bookprice) {
        this.bookprice = bookprice;
    }

    public Book(int id, String booknum, String bookname, String bookauthor, String bookpublish, Date bookdate, int bookprice) {
        this.id = id;
        this.booknum = booknum;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookpublish = bookpublish;
        this.bookdate = bookdate;
        this.bookprice = bookprice;
    }

    public Book(String id, String bookname, String bookauthor, String bookpublish, Date parse, int parseInt) {
    }
}
