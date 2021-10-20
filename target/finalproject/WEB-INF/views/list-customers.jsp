<%--
  Created by IntelliJ IDEA.
  User: kgagan
  Date: 08-10-2021
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        <h2>STORING CUSTOMERS DATA</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <input type="button" value="Add Customer"
               onclick="window.location.href='AddCustomerForm'; return false;" class="add-button"/>
        <form method="GET" action="search">
            Search customer: <input type="text" name="theSearchName" />

            <input type="submit" value="Search" class="add-button" />

        </form>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>

            </tr>
            <c:forEach var="tempCustomers" items="${customers}">
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
        <hr>

        <c:url var="listCustomersLink" value="/customer/list" />

        <a href="${listCustomersLink}">List All Customers</a>
    </div>
</div>

</body>
</html>
