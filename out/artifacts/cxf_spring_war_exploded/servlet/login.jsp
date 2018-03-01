<%--
  Created by IntelliJ IDEA.
  User: ex_chenlx1
  Date: 2018/02/09
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/loginServlet" method="post">
    userName:<input type="text" name="uname" /> <br/>
    password :<input type="password" name="upwd" /> <br/>
    <input type="submit" value="Login"/>
    <input type="reset" value="Reset"/>
</form>
</body>
</html>
