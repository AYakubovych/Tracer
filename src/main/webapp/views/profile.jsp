<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message key="head.create.profile" var="head_createp_rofile"/>
<spring:message key="head.profile" var="head_profile"/>
<spring:message key="head.log_out" var="head_log_out"/>
<spring:message key="head.log_in" var="head_log_in"/>
<spring:message key="personal.data" var="personal_data"/>
<spring:message key="name" var="name"/>
<spring:message key="last.name" var="surname"/>
<spring:message key="mail" var="mail"/>
<spring:message key="tracking" var="tracking"/>

<spring:message key="child.mail" var="child_mail"/>
<spring:message key="child.pass" var="child_pass"/>
<spring:message key="submit" var="submit"/>
<spring:message key="head.main" var="head_main"/>

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
                <li class="current_page_item" style="float: left"><a href="${pageContext.request.contextPath}/">${head_main}</a></li>
                <sec:authorize access="!isAuthenticated()">
                    <li style="float: right"><a href="${pageContext.request.contextPath}/create">${head_createp_rofile}</a></li>
                    <li style="float: right"><a href="${pageContext.request.contextPath}/login">${head_log_in}</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li style="float: right"><a href="${pageContext.request.contextPath}/profile">${head_profile}</a></li>
                    <li style="float: right"><a href="${pageContext.request.contextPath}/logout">${head_log_out}</a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
    <div><a href="?lang=ru_RU">[RU]</a><a href="?lang=en_EU">[EN]</a><a href="?lang=pl_PL">[PL]</a></div>

    <!-- Mid pannel -->
<div class = "center_block">
    <div class="center_top"></div>
        <div class = "center_border">
            <div class="text_box">

                <h4 class="in_box_text">${personal_data}</h4>
                <h4 class="in_box_text">${name}: ${user.name}</h4>
                <h4 class="in_box_text">${surname}: ${user.last_name}</h4>
                <h4 class="in_box_text">${mail}: ${user.email}</h4>

                <c:choose>
                    <c:when test="${user.targets.size() > 0}">
                        <h4 class="in_box_text">${tracking}: ${user.targets.get(0).name}</h4>
                        <form action="${pageContext.request.contextPath}/tracking">
                        <button class="submit_button" type="submit">Map</button>
                        </form>
                    </c:when>
                    <c:otherwise>

                        <c:choose>
                            <c:when test="${not empty message}">
                                <h4 class="${message.type}">${message.message}</h4>
                            </c:when>
                            <c:otherwise>
                                <h4 class="in_box_text">Add child</h4>
                            </c:otherwise>
                        </c:choose>

                        <form:form method="post" modelAttribute="target" >

                            <form:input path="email" id="email" name = "email" placeholder="${child_mail}"/>

                            <form:password path="pass" id="pass" name="pass" placeholder="${child_pass}"/>

                            <button class="submit_button" type="submit">${submit}</button>

                        </form:form>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
    </div>
</div>
</body>
</html>

