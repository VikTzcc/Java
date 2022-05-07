package com.offcn.service;

import com.offcn.bean.Book;
import com.offcn.bean.Page;

import java.util.List;

public interface BookService {
    //查询所有书籍
    List<Book> selectAllBook();
    //添加书籍
    int insertBook(Book book);
    //情况查询
    List<Book> selectByCondition(Book book);
    //更新
    Book preUpdate(int id);
    //修改书
    int updateBook(Book book);
    //删除书
    int deleteBookById(int id);
    //分页
    int totalCount();

    List<Book> selectAllBook(Page page);
}
