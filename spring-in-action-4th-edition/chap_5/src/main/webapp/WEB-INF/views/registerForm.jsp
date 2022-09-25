<%--
  Created by IntelliJ IDEA.
  User: dangkl123
  Date: 25/09/2022
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
    <h1>Register</h1>
    <form method="post">
        First Name: <input type="text" name="firstName"/><br/>
        Last Name: <input type="text" name="lastName"/><br/>
        Username: <input type="text" name="username"/><br/>
        Password: <input type="password" name="password"/><br/>
        <input type="submit" value="Register"/>
    </form>
</body>
</html>
