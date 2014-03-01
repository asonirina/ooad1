<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<body>

<h1>Person's Company Registration</h1>

<c:set var="contact" value="${contact}" />
<form method="post" action="Registration">
    <input type=hidden name=action value=aPersonalInfo>
    First Name:
    <%--<%= request.getParameter("firstname") %>--%>
    ${contact.firstName}
    <input type=hidden name=firstname value= <%= request.getParameter("firstname") %> >
    <br>
    Last Name:
    <%= request.getParameter("lastname") %>
    <input type=hidden name=lastname value= <%= request.getParameter("lastname") %> >
    <br>
    Company Name:
    <input type=text size=20 name=companyname>
    <br>
    <input type=submit value=Next>

</form>
</body>
</html>