<%@ page import="springmvc.model.Student" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kgagan
  Date: 07-10-2021
  Time: 07:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student-form</title>

</head>
<body>
<form:form action="processForm" modelAttribute="student">
  First Name : <form:input path="firstName"/> <br>
  Last Name(*) : <form:input path="lastName"/>
  <form:errors path="lastName" cssStyle="color: red"/> <br><br>
    Country : <form:select path="country">
    <form:option value="brazil" label="brazil"/>
  <form:option value="india" label="india"/>
  <form:option value="chile" label="chile"/>
  <form:option value="austraia" label="australia"/><br> <br>
  Favourite Language : <br>
  Java :<form:radiobutton path="favouriteLanguage" value="java"/>
  C :<form:radiobutton path="favouriteLanguage" value="C"/>
  Python :<form:radiobutton path="favouriteLanguage" value="python"/>
  C++ :<form:radiobutton path="favouriteLanguage" value="c++"/><br><br>





</form:select>
  <input type="submit" value="Submit"/>


</form:form>

</body>
</html>
