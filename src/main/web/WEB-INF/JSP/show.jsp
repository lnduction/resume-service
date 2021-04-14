<%--
  Created by IntelliJ IDEA.
  User: aleksandrce
  Date: 14.04.2021
  Time: 06:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${person.firstName}</h1>
<h1>${person.lastName}</h1>
<h1>${person.middleName}</h1>
<h3>${person.city}</h3>
<h3>${person.email}</h3>
<h3>${person.phone}</h3>
<textarea>${person.skills}</textarea>
<textarea>${person.experience}</textarea>
<textarea>${person.objective}</textarea>
</body>
</html>
