package com.offcn.service;

import com.offcn.bean.Book;
import com.offcn.bean.Page;
import com.offcn.dao.BookDao;
import com.offcn.dao.BookDaoImpl;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bd = new BookDaoImpl();
    @Override
    public List<Book> selectAllBook() {
        return bd.selectAllBook();
    }

    @Override
    public int insertBook(Book book) {
        return bd.insertBook(book);
    }

    @Override
    public List<Book> selectByCondition(Book book) {
        return bd.selectByCondition(book);
    }

    @Override
    public Book preUpdate(int id) {
        return bd.preUpdate(id);
    }

    @Override
    public int updateBook(Book book) {
        return bd.updateBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return deleteBookById(id);
    }

    @Override
    public int totalCount() {
        return bd.totalCount();
    }

    @Override
    public List<Book> selectAllBook(Page page) {
        return bd.selectAllBook(page);
    }

}
