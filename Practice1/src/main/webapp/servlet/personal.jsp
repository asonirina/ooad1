<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<body>

<h1>Personal Info Registreation</h1>


<form method="post" action="Registration">
    <input type=hidden name=action value=aSave>
    First Name:
    <%= request.getParameter("firstName") %>
    <input type=hidden name=firstName value= <%= request.getParameter("firstName") %> />
    <br>
    Last Name:
    <%= request.getParameter("lastName") %>
    <input type=hidden name=lastName value= <%= request.getParameter("lastName") %> />
    <br>
    Company Name:
    <%= request.getParameter("company") %>
    <input type=hidden name=company value= <%= request.getParameter("company") %> />
    <br>
    Hobby:
    <input type=text name=hobby/>
    <br>
    <input type=submit value=Next>

</form>
</body>
</html>