<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

  <head>
      <c:if test = "${empty param.language}">
          <c:set var="language" value='en'/>
      </c:if>
      <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
      <fmt:setLocale value="${language}" />
      <fmt:setBundle basename="property.text" var="local"/>
      <fmt:message bundle="${local}" key="chooseAction" var="chooseAction" />
      <fmt:message bundle="${local}" key="sendEmail" var="sendEmail" />
      <fmt:message bundle="${local}" key="inputEmail" var="inputEmail" />
      <fmt:message bundle="${local}" key="inputText" var="inputText" />
      <fmt:message bundle="${local}" key="sendButt" var="sendButt" />
    <title>Main</title>
  </head>
  <body>

  <form>
      <select id="language" name="language" onchange="submit()">
          <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
          <option value="rus" ${language == 'rus' ? 'selected' : ''}>Russian</option>
      </select>
  </form>

  <form action="FrontController" method="post" enctype="multipart/form-data">

      <input type="hidden" name="lang" value="${language}">

    <h3>${chooseAction}</h3>

    <br/>
      <input type="file" name="file"/>
    <br/>

    <br/>
    <button input type="submit" name="action" value="dom">DOM</button></pre>
    <button input type="submit" name="action" value="sax">SAX</button></pre>
    <button input type="submit" name="action" value="stax">STAX</button></pre>
    <button input type="submit" name="action" value="jaxb">JAXB</button>
    <br/>
    <br/>

    <h3>${sendEmail}</h3>

    <div>
      <label>${inputEmail}</label>
      <input type="text" name="mailTo">
      <br/>
      <label>${inputText}</label>
      <input type="text" name="mailText">
      <br/>
      <button input type="submit" name="action" value="sendMail">${sendButt}</button>
    </div>

  </form>
  </body>
</html>
