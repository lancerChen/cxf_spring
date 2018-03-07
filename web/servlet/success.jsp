<%--
  Created by IntelliJ IDEA.
  User: ex_chenlx1
  Date: 2018/02/09
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success Page</title>
</head>
<body>
Login successful! You can enjoy your time now!<br/>
Information:<br/>
user name:<%=request.getParameter("uname")%><br/>
password:<%=request.getParameter("upwd")%><br/>
<a href="login.jsp">go to login</a>
</body>
</html>
