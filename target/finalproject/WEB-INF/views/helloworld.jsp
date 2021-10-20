<%--
  Created by IntelliJ IDEA.
  User: kgagan
  Date: 06-10-2021
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello world</title>
</head>
<body>
Hello world of spring !
<br>
welcome to <%=request.getParameter("studentName")%>
<br>
The message is <%=request.getAttribute("message")%>


</body>
</html>
