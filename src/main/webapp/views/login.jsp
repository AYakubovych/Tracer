<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                <li class="current_page_item" style="float: left"><a href="/">${head_main}</a></li>
                <c:choose>
                    <c:when test="${cookie.containsKey('id') }">
                        <li style="float: right"><a href="${pageContext.request.contextPath}/profile">${head_profile}</a></li>
                        <li style="float: right"><a href="${pageContext.request.contextPath}/logout">${head_log_out}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li style="float: right"><a href="${pageContext.request.contextPath}/create">${head_createp_rofile}</a></li>
                        <li style="float: right"><a href="${pageContext.request.contextPath}/login">${head_log_in}</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>
    <div><a href="?lang=ru_RU">[RU]</a><a href="?lang=en_EU">[EN]</a></div>
<!-- Mid pannel -->
    <div class = "center_block">
        <div class="center_top"></div>
            <div class = "center_border">

                <c:choose>
                    <c:when test="${not empty error_message}">
                        <h4 class="${error_message.type}">${error_message.message}</h4>
                    </c:when>
                    <c:otherwise>
                        <h4 class="text">${head_log_in}</h4>
                    </c:otherwise>
                </c:choose>


            <div class = "form_block">
                <form method="post">
                     <input type="text" id="email" name = "email" placeholder="${mail}">

                     <input type="password" id="pass" name="pass" placeholder="${pass}">

                    <button type="submit" class="submit_button">${submit}</button>

                </form>
            </div>
         </div>
     </div>
</div>

</body>
</html>

