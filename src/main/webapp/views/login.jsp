<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message key="head.create.profile" var="head_createp_rofile"/>
<spring:message key="head.profile" var="head_profile"/>
<spring:message key="head.log_out" var="head_log_out"/>
<spring:message key="head.log_in" var="head_log_in"/>

<spring:message key="create.form.email" var="mail"/>
<spring:message key="create.form.pass" var="pass"/>
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

                <c:choose>
                    <c:when test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                       ${SPRING_SECURITY_LAST_EXCEPTION.message}
                    </c:when>
                    <c:otherwise>
                        <h4 class="text">${head_log_in}</h4>
                    </c:otherwise>
                </c:choose>


            <div class = "form_block">
                <form action="login" method="post">
                     <input type="text"  name = "username" placeholder="${mail}">

                     <input type="password" name="password" placeholder="${pass}">

                    <button type="submit" class="submit_button">${submit}</button>

                </form>
            </div>
         </div>
     </div>
</div>

</body>
</html>

