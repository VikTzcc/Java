package com.offcn.dao;

import com.offcn.bean.Book;
import com.offcn.bean.Page;
import com.offcn.utils.DataSourceUtils;
import com.offcn.utils.DateUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    //查询全部
    @Override
    public List<Book> selectAllBook() {
        List<Book> list = null;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from book";
        try {
            list = qr.query(sql, new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertBook(Book book) {
        int result = 0;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into book value (null,?,?,?,?,?,?);";
        try {
            result = qr.update(sql, book.getBooknum(), book.getBookname(), book.getBookauthor(), book.getBookpublish(), book.getBookdate(), book.getBookprice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Book> selectByCondition(Book book) {
        List<Book> list = new ArrayList<>();
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = getSql(book);
        try {
            list = qr.query(sql, new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Book preUpdate(int id) {
        Book book = null;
        String sql = "select * from book where id = ? ";
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            book = qr.query(sql, new BeanHandler<>(Book.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    //拼接sql语句
    private String getSql(Book book) {
        StringBuilder sb = new StringBuilder("select * from book where 1 = 1");
        if (book.getBooknum() != null && !"".equals(book.getBooknum().trim())) {
            sb.append(" and booknum like '%").append(book.getBooknum()).append("%'");
        }
        if (book.getBookname() != null && !"".equals(book.getBookname().trim())) {
            sb.append(" and bookname like '%").append(book.getBookname()).append("%'");
        }
        if (book.getBookauthor() != null && !"".equals(book.getBookauthor().trim())) {
            sb.append(" and bookauthor like '%").append(book.getBookauthor()).append("%'");
        }
        if (book.getBookpublish() != null && !"".equals(book.getBookpublish().trim())) {
            sb.append(" and bookpublish like '%").append(book.getBookpublish()).append("%'");
        }
        if (book.getBookdate() != null) {
            sb.append(" and bookdate = '").append(DateUtil.dateToString(book.getBookdate())).append("'");
        }
        if (book.getBookprice() != 0) {
            sb.append(" and bookprice = ").append(book.getBookprice());
        }
        return sb.toString();
    }


    @Override
    public int updateBook(Book book) {
        int result = 0;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update book set booknum = ?,bookname = ?,bookauthor = ?,bookpublish = ?,bookdate = ?," +
                " bookprice = ? where id = ?";
        try {
            result = qr.update(sql, book.getBooknum(), book.getBookname(), book.getBookauthor(), book.getBookpublish(), book.getBookdate(), book.getBookprice(), book.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int totalCount() {
        Long count = 0L;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from book";
        try {
            count = (Long)qr.query(sql, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count.intValue();
    }

    @Override
    public List<Book> selectAllBook(Page page) {
        List<Book> list=null;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from book limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(Book.class),(page.getCurrentPage()-1)*Page.PAGE_SIZE,Page.PAGE_SIZE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


}
