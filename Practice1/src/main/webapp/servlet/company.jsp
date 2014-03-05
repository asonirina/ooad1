<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<h1>Person's Company Registration</h1>

<form method="POST" action="Registration">
    <input type=hidden name=action value=aPersonalInfo>
    First Name:   ${firstName}
    <br>
    Last Name: ${lastName}
    <br>
    Company Name:
    <input type=text size=20 name=company>
    <br>
    <input type=submit value=Next>

</form>
</body>
</html>