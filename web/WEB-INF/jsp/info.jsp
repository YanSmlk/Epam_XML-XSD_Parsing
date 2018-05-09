<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Info</title>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="property.text" var="local"/>
    <fmt:message bundle="${local}" key="goToMainButt" var="goToMainButt" />
    <fmt:message bundle="${local}" key="serverReply" var="serverReply" />
</head>

<body>

<h2>${serverReply}</h2>

<c:out value="${requestScope.Message}" />

<br>
<br>

<input type="button" value="${goToMainButt}" onclick="window.location.href='/index.jsp'" />

</body>
</html>
