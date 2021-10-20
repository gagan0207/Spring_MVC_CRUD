<%--
  Created by IntelliJ IDEA.
  User: kgagan
  Date: 07-10-2021
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
Hi Buddy <%=request.getParameter("firstName")%><br>
country <%=request.getParameter("country")%> <br>
Favourite Language <%=request.getParameter("favouriteLanguage")%><br>


</body>
</html>
