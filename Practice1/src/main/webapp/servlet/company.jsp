<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<body>

<h1>Person's Company Registration</h1>

<form method="post" action="Registration">
    <input type=hidden name=action value=aPersonalInfo>
    First Name:
    <%= request.getAttribute("firstName") %>
    <input type=hidden name=firstName value= <%= request.getAttribute("firstName") %> >
    <br>
    Last Name:
    <%= request.getAttribute("lastName") %>
    <input type=hidden name=lastName value= <%= request.getAttribute("lastName") %> >
    <br>
    Company Name:
    <input type=text size=20 name=company>
    <br>
    <input type=submit value=Next>

</form>
</body>
</html>