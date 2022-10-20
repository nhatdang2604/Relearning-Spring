<%--
  Created by IntelliJ IDEA.
  User: dangkl123
  Date: 23/09/2022
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<head>
    <title>Profile</title>

    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/css/style.css"/>">
</head>
<body>

    <h1>Your Profile</h1>
    <c:out value="${spitter.username}"/> <br/>
    <c:out value="${spitter.firstName}"/>
        <c:out value="${spitter.lastName}"/>

</body>
</html>
