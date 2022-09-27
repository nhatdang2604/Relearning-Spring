<%--
  Created by IntelliJ IDEA.
  User: dangkl123
  Date: 25/09/2022
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>

<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
    <h1>Register</h1>
<%--    <form method="post">--%>
<%--        First Name: <input type="text" name="firstName"/><br/>--%>
<%--        Last Name: <input type="text" name="lastName"/><br/>--%>
<%--        Username: <input type="text" name="username"/><br/>--%>
<%--        Password: <input type="password" name="password"/><br/>--%>
<%--        <input type="submit" value="Register"/>--%>
<%--    </form>--%>

    <sf:form method="POST" modelAttribute="spitter">

        <sf:errors path="*" element="div" cssClass="errors"/>

        <sf:label path="firstName"
                  cssErrorClass="error">First name</sf:label>:
        <sf:input path="firstName" cssErrorClass="error"/><br/>

        <sf:label path="lastName"
                  cssErrorClass="error">Last name</sf:label>:
        <sf:input path="lastName" cssErrorClass="error"/><br/>

        <sf:label path="username"
                  cssErrorClass="error">Username</sf:label>:
        <sf:input path="username" cssErrorClass="error"/><br/>

        <sf:label path="password"
                  cssErrorClass="error">First name</sf:label>:
        <sf:input path="password" cssErrorClass="error"/><br/>

        <input type="submit" value="Register"/>
    </sf:form>

</body>
</html>
