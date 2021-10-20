<%--
  Created by IntelliJ IDEA.
  User: kgagan
  Date: 13-10-2021
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>customers list</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CUSTOMERS DATA</h2>
    </div>
</div>
<div id="container">
    <div id="content">


        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>

            </tr>
            <c:forEach var="tempCustomers" items="${searchCustomers}">
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomers.id}"/>
                </c:url>
                <tr>
                    <td>${tempCustomers.firstName}</td>
                    <td>${tempCustomers.lastName}</td>
                    <td>${tempCustomers.email}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="customer/list">Back to customer list</a>
</div>

</body>
</html>
