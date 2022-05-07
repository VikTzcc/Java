<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/26
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询图书</title>
</head>
<body>
<table border="1px" width="60%" align="center" cellspacing="1px">
    <tr>
        <th>ID</th>
        <th>编号</th>
        <th>名称</th>
        <th>作者</th>
        <th>出版社</th>
        <th>日期</th>
        <th>价格</th>
        <th>其他操作</th>
    </tr>
    <c:forEach items="${requestScope.blist}" var="b">
        <tr>
            <td>${b.id}</td>
            <td>${b.booknum}</td>
            <td>${b.bookname}</td>
            <td>${b.bookauthor}</td>
            <td>${b.bookpublish}</td>
            <td>${b.bookdate}</td>
            <td>${b.bookprice}</td>
            <td>
                <a href="BookServlet?method=PreUpdate&id=${b.id}">修改</a>
                <a href="javascript:deleteBookById${b.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="8">
            <%-- 首页 --%>
            <a href="BookServlet?method=selectAllBook&currPage=1">首页</a>&nbsp;
            <%-- 上一页 --%>
            <c:if test="${requestScope.page.currentPage != 1}">
                <%--  当前页 -1  --%>
                <a href="BookServlet?method=selectAllBook&currPage=${requestScope.page.currentPage-1}">上一页</a>
            </c:if>
            <%-- 页码 --%>
            <c:forEach begin="1" end="${requestScope.page.totalPage}" var="n">
                <c:choose>
                    <c:when test="${requestScope.page.currentPage == n}">
                        <a style="color: red" href="BookServlet?method=selectAllBook&currPage=${n}">${n}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="BookServlet?method=selectAllBook&currPage=${n}">${n}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <%-- 下一页 如果不是最后一页显示下一页--%>
            <c:if test="${requestScope.page.currentPage != requestScope.page.totalPage}">
                <%--  当前页 + 1   --%>
                <a href="BookServlet?method=selectAllBook&currPage=${requestScope.page.currentPage+1}">下一页</a>
            </c:if>
            <%-- 尾页 总页码--%>
            <a href="BookServlet?method=selectAllBook&currPage=${requestScope.page.totalPage}">尾页</a>
            共${requestScope.page.totalPage}页
        </td>
    </tr>
    <tr>
        <td colspan="8" align="center">
            <a href="index.jsp"><input type="button" value="返回"></a>
        </td>
    </tr>
</table>
</body>
<script>
    function deleteBookById(id) {
        var flag = confirm("确认删除?");//
        if (flag){
            location = "BookServlet?method=deleteBookById" + id;

        }
    }
</script>
</html>
