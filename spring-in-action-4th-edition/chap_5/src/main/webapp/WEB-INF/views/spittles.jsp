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
    <title>Spittles</title>
</head>
<body>
    <c:forEach var="spittle" items="${spittleList}">
        <li id="spittle_<c:out value="${spittle.id}"/>">

            <div class="spittleMessage">
                <c:out value="${spittle.message}"/>
            </div>

            <div>
                <span class="spittleTime">
                    <c:out value="${spittle.time}"/>
                </span>

                <span class="spittleLocation">
                    (<c:out value="${spittle.latitude}"/>,
                    <c:out value="${spittle.longitude}"/>)
                </span>
            </div>

        </li>
    </c:forEach>
</body>
</html>
