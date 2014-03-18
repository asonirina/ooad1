<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<h1>Personal Info Registreation</h1>


<form method="post" action="Registration">
    <input type="hidden" name="current" value="3">
    <input type=hidden name=action value=aSave>
    First Name: ${firstName}
    <br>
    Last Name: ${lastName}
    <br>
    Company Name: ${company}
    <br>
    Hobby:
    <input type=text name=hobby/>
    <br>
    <input type=submit value=Next>

</form>
</body>
</html>