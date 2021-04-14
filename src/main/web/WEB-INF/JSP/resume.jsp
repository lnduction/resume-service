<%--
  Created by IntelliJ IDEA.
  User: aleksandrce
  Date: 14.04.2021
  Time: 03:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Resume</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <th>UID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Middle Name</th>
            <th>City</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Skills</th>
            <th>Experience</th>
            <th>Objective</th>
        </tr>
        <c:forEach  items="${items}" var ="resume">
            <tr>
                <td>${person.uid}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>${person.middleName}</td>
                <td>${person.city}</td>
                <td>${person.email}</td>
                <td>${person.phone}</td>
                <td>${person.skills}</td>
                <td>${person.experience}</td>
                <td>${person.objective}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
