<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/26
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>警告</title>
</head>
<body>
         <script>
             if(confirm("确认删除?")){
                 location.href="BookServlet?method=deleteBookById";
             }else {
                 location.href="BookServlet?method=selectAllBook";
                 alert("取消删除");
             }
         </script>
</body>
</html>
