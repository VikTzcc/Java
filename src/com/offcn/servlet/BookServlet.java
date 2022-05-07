package com.offcn.servlet;

import com.offcn.bean.Book;
import com.offcn.bean.Page;
import com.offcn.service.BookService;
import com.offcn.service.BookServiceImpl;
import com.offcn.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("insert".equals(method)){//执行添加书籍
            insert(request,response);
        }else if("selectAllBook".equals(method)){
            selectAllBook(request,response);
        }else if ("selectByCondition".equals(method)){
            selectByCondition(request,response);
        }else if("preUpdate".equals(method)){
            preUpdate(request,response);
        }else if ("updateBook".equals(method)){
            updateBook(request,response);
        }else if ("deleteById".equals(method)){
            request.getRequestDispatcher("de" +
                    " leteBookById.jsp").forward(request,response);
            deleteBookById(request,response);
        }

    }

    //删除
    private void deleteBookById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        BookService bs = new BookServiceImpl();
        int i = bs.deleteBookById(Integer.parseInt(id));
        response.sendRedirect("BookServlet?method=selectAllBook");
    }

    //更新
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String booknum = request.getParameter("booknum");
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookpublish = request.getParameter("bookpublish");
        String bookdate = request.getParameter("bookdate");
        String bookprice = request.getParameter("bookprice");

        Book book = null;
        book = new Book(Integer.parseInt(id),booknum,bookname,bookauthor,bookpublish,du.stringToDate(bookdate),Integer.parseInt(bookprice));
        BookService bs = new BookServiceImpl();
        bs.updateBook(book);
        response.sendRedirect("BookServlet?method=selectAllBook");
    }

    //准备修改
    private void preUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        BookService bs = new BookServiceImpl();
        Book book = bs.preUpdate(Integer.parseInt(id));
        request.setAttribute("book",book);
        request.getRequestDispatcher("PreUpdate.jsp").forward(request,response);
    }

    BookService bs = new BookServiceImpl();
    DateUtil du = new DateUtil();
    private void selectByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String booknum = request.getParameter("booknum");
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookpublish = request.getParameter("bookpublish");
        String bookdate = request.getParameter("bookdate");
        String bookprice = request.getParameter("bookprice");
        //封装对象
        Book book = new Book();
        book.setBooknum(booknum);
        book.setBookname(bookname);
        book.setBookauthor(bookauthor);
        book.setBookpublish(bookpublish);
        //设置前进行判断,是否录入有效信息
        if (bookdate != null && !"".equals(bookdate.trim())){
            book.setBookdate(du.stringToDate(bookdate));
        }
        if(bookprice != null && !"".equals(bookprice.trim())){
            book.setBookprice(Integer.parseInt(bookprice));
        }
        //调用方法
        List<Book> bookList = bs.selectByCondition(book);
        request.setAttribute("blist",bookList);
        request.getRequestDispatcher("showBook.jsp").forward(request,response);

    }



    //查询全部
    private void selectAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Book> blist = bs.selectAllBook();
//        request.setAttribute("blist",blist);
//        request.getRequestDispatcher("showBook.jsp").forward(request,response);

        BookService bs = new BookServiceImpl();
        int currentPage = 1;
        String currPage = request.getParameter("currPage");
        if (currPage != null && !"".equals(currPage)){
            currentPage = Integer.parseInt(currPage);
        }
        Page page = new Page();
        //设置当前页
        page.setCurrentPage(currentPage);
        //计算条数
        int totalNum = bs.totalCount();
        //设置条数为9
        page.setTotalNum(totalNum);

        //计算总页数
        int totalPage = 0;
        if (totalNum % Page.PAGE_SIZE == 0){
            totalPage = totalNum / Page.PAGE_SIZE;
        }else {
            totalPage = totalNum / Page.PAGE_SIZE + 1;
        }

        //设置总页码
        page.setTotalPage(totalPage);

        //计算分页信息
        List<Book> blist = bs.selectAllBook(page);
        request.setAttribute("blist",blist);
        request.setAttribute("page",page);
        request.getRequestDispatcher("showBook.jsp").forward(request,response);
    }

    //添加操作
    private void insert(HttpServletRequest request, HttpServletResponse response) {
        //获取参数
        String booknum = request.getParameter("booknum");
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookpublish = request.getParameter("bookpublish");
        String bookdate = request.getParameter("bookdate");
        String bookprice = request.getParameter("bookprice");
        //封装对象
        Book book = new Book();

        book.setBooknum(booknum);
        book.setBookname(bookname);
        book.setBookauthor(bookauthor);
        book.setBookpublish(bookpublish);
        book.setBookdate(du.stringToDate(bookdate));
        book.setBookprice(Integer.parseInt(bookprice));

        //调用方法
        int result = bs.insertBook(book);
        if (result != 0){
            //重定向到查询全部
            try {
                response.sendRedirect("BookServlet?method=selectAll");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
