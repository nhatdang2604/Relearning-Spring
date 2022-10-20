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
    <title>Spittle</title>

    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/css/style.css"/>">
</head>
<body>

    <div class="spittleView">
        <div class="spittleMessage">
            <c:out value="${spittle.message}"/>
        </div>

        <div>
            <span class="spittleTime">
                <c:out value="${spittle.time}"/>
            </span>
        </div>
    </div>

</body>
</html>
