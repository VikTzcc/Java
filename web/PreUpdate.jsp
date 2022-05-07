<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/26
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="BookServlet?method=updateBook" method="post">
<table border="1px" cellspacing="0px" align="center" width="60%">
    <tr>
        <td>ID</td>
        <td>
            <input TYPE="text" name="id" value="${requestScope.book.id}">
        </td>
    </tr>
    <tr>
        <td>编号</td>
        <td><input type="text" name="booknum" value="${requestScope.book.booknum}"></td>
    </tr>
    <tr>
        <td>书名</td>
        <td><input type="text" name="bookname" VALUE="${requestScope.book.bookname}"></td>
    </tr>
    <tr>
        <td>作者</td>
        <td><input type="text" name="bookauthor" value="${requestScope.book.bookauthor}"></td>
    </tr>
    <tr>
        <td>出版社</td>
        <td><input type="text" name="bookpublish" value="${requestScope.book.bookpublish}"></td>
    </tr>
    <tr>
        <td>日期</td>
        <td><input type="text" name="bookdate" value="${requestScope.book.bookdate}"></td>
    </tr>
    <tr>
        <td>价格</td>
        <td><input type="text" name="bookprice" value="${requestScope.book.bookprice}"></td>
    </tr>
    <tr>
        <td colspan="7" align="center">
            <input type="submit" value="修改">
            <a href="index.jsp"><input type="button"  value="返回"></a>
        </td>
    </tr>
</table>
</form>
</body>
</html>
