package com.offcn.dao;

import com.offcn.bean.Book;
import com.offcn.bean.Page;

import java.util.List;

public interface BookDao {
    //查询所有书籍
    List<Book> selectAllBook();
    //添加书籍
    int insertBook(Book book);
    //根据id查询
    List<Book> selectByCondition(Book book);
    //更新书籍
    Book preUpdate(int id);
    //修改书
    int updateBook(Book book);
    //分页
    int totalCount();

    List<Book> selectAllBook(Page page);
}
