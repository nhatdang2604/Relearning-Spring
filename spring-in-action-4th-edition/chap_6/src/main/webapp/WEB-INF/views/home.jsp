<%--
  Created by IntelliJ IDEA.
  User: dangkl123
  Date: 20/09/2022
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
    <title><s:message code="spittr.welcome"/></title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
    <h1>Welcome to Spittr</h1>

<%--    <a href="<c:url value="/spittles"/>">Spittles</a>--%>

    <s:url value="/spittles/" var="spittlesUrl">
        <s:param name="max" value="60"/>
        <s:param name="count" value="20"/>
    </s:url>
    <a href="${spittlesUrl}">Spittles</a>


    <s:url value="/spitter/register" var="registerUrl"/>
    <a href="${registerUrl}">Register</a>

<%--    <a href="<s:url value="/spitter/register/"/>">Register</a>--%>
</body>
</html>
