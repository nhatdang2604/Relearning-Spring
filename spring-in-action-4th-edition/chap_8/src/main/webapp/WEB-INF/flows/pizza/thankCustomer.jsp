<%--
  Created by IntelliJ IDEA.
  User: dangkl123
  Date: 15/10/2022
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:output omit-xml-declaration="yes"/>
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <head>
        <title>Spizza</title>
    </head>
    <body>
        <h2>Thank you for your order!</h2>
        <![CDATA[
        <a href='${flowExecutionUrl}&_eventId=finished'>Finish</a>
        ]]>
    </body>
</html>
