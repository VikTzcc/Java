<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/26
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>条件查询</title>
</head>
<body>
<form action="BookServlet?method=selectByCondition" method="post">
    <table border="1px" cellspacing="1px" width="500px" height="300px" align="center">
        <tr>
            <td align="center">编号</td>
            <td><input type="text" name="booknum" id="booknum" placeholder="请输入序号"></td>
        </tr>
        <tr>
            <td align="center">书名</td>
            <td><input type="text" name="bookname" id="bookname" placeholder="请输入书名"></td>
        </tr>
        <tr>
            <td align="center">作者</td>
            <td><input type="text" name="bookauthor" id="bookauthor" placeholder="请输入作者"></td>
        </tr>
        <tr>
            <td align="center">出版社</td>
            <td><input type="text" name="bookpublish" id="bookpublish" placeholder="请输入出版社"></td>
        </tr>
        <tr>
            <td align="center">日期</td>
            <td><input type="text" name="bookdate" id="bookdate" placeholder="请输入日期"></td>
        </tr>
        <tr>
            <td align="center">价格</td>
            <td><input type="text" name="bookprice" id="bookprice" placeholder="请输入价格"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="查询">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
