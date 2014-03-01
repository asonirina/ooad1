<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<body>

<h1>Personal Info Registreation</h1>


<form method="post" action="Registration">
    <input type=hidden name=action value=aSave>
    First Name:
    <%= request.getParameter("firstname") %>
    <input type=hidden name=firstname value= <%= request.getParameter("firstname") %> />
    <br>
    Last Name:
    <%= request.getParameter("lastname") %>
    <input type=hidden name=lastname value= <%= request.getParameter("lastname") %> />
    <br>
    Company Name:
    <%= request.getParameter("companyname") %>
    <input type=hidden name=companyname value= <%= request.getParameter("companyname") %> />
    <br>
    Hobby:
    <input type=text name=hobby/>
    <br>
    <input type=submit value=Next>

</form>
</body>
</html>