<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/26
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
</head>
<body>
<form action="BookServlet?method=insert" method="post">
    <table border="1px" cellspacing="1px" width="500px" height="300px" align="center">
        <tr>
            <td align="right">图书编号</td>
            <td>
                <input type="text" name="booknum" id="booknum" placeholder="请输入编号">
            </td>
        </tr>
        <tr>
            <td align="right">图书名称</td>
            <td>
                <input type="text" name="bookname" id="bookname" placeholder="请输入名称">
            </td>
        </tr>
        <tr>
            <td align="right">图书作者</td>
            <td>
                <input type="text" name="bookauthor" id="bookauthor" placeholder="请输入作者">
            </td>
        </tr>
        <tr>
            <td align="right">出版社</td>
            <td>
                <input type="text" name="bookpublish" id="bookpublish" placeholder="请输入出版社">
            </td>
        </tr>
        <tr>
            <td align="right">出版日期</td>
            <td>
                <input type="text" name="bookdate" id="bookdate" placeholder="请输入日期">
            </td>
        </tr>
        <tr>
            <td align="right">价格</td>
            <td>
                <input type="text" name="bookprice" id="bookprice" placeholder="请输入价格">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="添加">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
