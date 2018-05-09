<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Table</title>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="property.text" var="local"/>
    <fmt:message bundle="${local}" key="recievedInfo" var="recievedInfo" />
    <fmt:message bundle="${local}" key="newspapers" var="newspapers" />
    <fmt:message bundle="${local}" key="booklets" var="booklets" />
    <fmt:message bundle="${local}" key="journals" var="journals" />
    <fmt:message bundle="${local}" key="goToMainButt" var="goToMainButt" />
</head>

<body>

<form action="FrontController" method="get">

    <h1>${recievedInfo} <c:out value="${requestScope.Parser}" /> </h1>

    <input type="button" value="${goToMainButt}" onclick="window.location.href='/index.jsp'" />

    <h2>${newspapers}</h2>

        <table class="table">
            <thead>
            <th>ID</th>
            <th>Index</th>
            <th>Title</th>
            <th>Mounthly</th>
            <th>Colored</th>
            <th>Pages</th>
            <th>Glossy</th>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.Newspapers}" var="news" >
         <tr>
             <td class="id">${news.getId()}</td>
             <td class="index">${news.getIndex()}</td>
             <td class="title">${news.getTitle()}</td>
             <td class="mounthly">${news.getMounthly()}</td>
             <td class="colored">${news.getColored()}</td>
             <td class="pages">${news.getPages()}</td>
             <td class="glossy">${news.getGlossy()}</td>
         </tr>
             </c:forEach>
            </tbody>
        </table>

    </br>

    <h2>${journals}</h2>

        <table class="table">
            <thead>
            <th>ID</th>
            <th>Index</th>
            <th>Title</th>
            <th>Mounthly</th>
            <th>Colored</th>
            <th>Pages</th>
            <th>Glossy</th>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.Journals}" var="journ" >
                <tr>
                    <td class="id">${journ.getId()}</td>
                    <td class="index">${journ.getIndex()}</td>
                    <td class="title">${journ.getTitle()}</td>
                    <td class="mounthly">${journ.getMounthly()}</td>
                    <td class="colored">${journ.getColored()}</td>
                    <td class="pages">${journ.getPages()}</td>
                    <td class="glossy">${journ.getGlossy()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </br>

    <h2>${booklets}</h2>

        <table class="table">
            <thead>
            <th>ID</th>
            <th>Title</th>
            <th>Mounthly</th>
            <th>Colored</th>
            <th>Pages</th>
            <th>Glossy</th>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.Booklets}" var="bookl" >
                <tr>
                    <td class="id">${bookl.getId()}</td>
                    <td class="title">${bookl.getTitle()}</td>
                    <td class="mounthly">${bookl.getMounthly()}</td>
                    <td class="colored">${bookl.getColored()}</td>
                    <td class="pages">${bookl.getPages()}</td>
                    <td class="glossy">${bookl.getGlossy()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

</form>
</body>
</html>
