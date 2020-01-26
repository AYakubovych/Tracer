<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:message key="label_users" var="labelUsers"/>
<spring:message key="all.head.profile" var="profile"/>
<spring:message key="head.create.profile" var="head_createp_rofile"/>
<spring:message key="head.profile" var="head_profile"/>
<spring:message key="head.log_out" var="head_log_out"/>
<spring:message key="head.log_in" var="head_log_in"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Tracer</title>
    <link href="http://fonts.googleapis.com/css?family=Oxygen:400,700,300" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>


<div id="wrapper">
    <!-- Menu pannel -->
    <div id="menu-wrapper">
        <div id="menu" class="container">
            <ul>
                <li class="current_page_item" style="float: left"><a href="/">Home</a></li>
                <c:choose>
                    <c:when test="${cookie.containsKey('id') }">
                        <li style="float: right"><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
                        <li style="float: right"><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
                    </c:when>
                    <c:otherwise>
                        <li style="float: right"><a href="${pageContext.request.contextPath}/create">Create Profile</a></li>
                        <li style="float: right"><a href="${pageContext.request.contextPath}/login">Log In</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>
    <div><a href="?lang=ru_RU">[RU]</a><a href="?lang=en_EU">[EN]</a></div>

<h1>${labelUsers}</h1>
<c:if test = "${not empty users}">
    <table>
        <thead>
        <th>First Name</th>
        <th>Last Name</th>
        <th>E-mail</th>
        </thead>
    <tbody>
    <c:forEach items = "${users}" var = "user">
        <tr>
            <td>${user.name}</td>
            <td>${user.last_name}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
</c:if>


</body>
</html>
