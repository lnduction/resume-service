<%--
  Created by IntelliJ IDEA.
  User: aleksandrce
  Date: 14.04.2021
  Time: 06:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="/edit" method="post" commandName="editForm">
    <div>
        <label for="firstName">First name</label>
        <input type="text" class="form-control" id="firstName" maxlength="20" name="firstName" value="${firstName}" placeholder="First name">
    </div>
    <div>
         <label for="lastName">Last name</label>
         <input type="text" class="form-control" id="lastName" maxlength="20" name="lastName" value="${lastName}" placeholder="Last name">
    </div>
    <div>
        <label for="middleName">Middle name</label>
        <input type="text" class="form-control" id="middleName" maxlength="20" name="middleName" value="${middleName}" placeholder="Middle name">
    </div>
    <div>
        <label for="city">City</label>
        <input type="text" class="form-control" id="city" maxlength="20" name="city" value="${city}" placeholder="City">
    </div>
    <div>
        <label for="email">Email</label>
        <input type="text" class="form-control" id="email" maxlength="20" name="email" value="${email}" placeholder="Email">
    </div>
    <div>
        <label for="phone">Phone</label>
        <input type="text" class="form-control" id="phone" maxlength="20" name="phone" value="${phone}" placeholder="Phone">
    </div>
    <div>
        <label for="skills">Skills</label>
        <textarea placeholder="Skills" id="skills" name="skills">${skills}</textarea>
    </div>
    <div>
        <label for="experience">Experience</label>
        <textarea placeholder="Experience" id="experience" name="experience">${experience}</textarea>
    </div>
    <div>
        <label for="objective">Objective</label>
        <textarea placeholder="Objective" id="objective" name="objective">${objective}</textarea>
    <button type="submit">Submit</button>
    </div>
</form>
</body>
</html>
