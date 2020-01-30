<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:message key="create.form.name" var="name"/>
<spring:message key="create.form.email" var="mail"/>
<spring:message key="create.form.second_name" var="l_name"/>
<spring:message key="create.form.pass" var="pass"/>
<spring:message key="create.form.c_pass" var="c_pass"/>
<spring:message key="create.form.message" var="profile_message"/>
<spring:message key="all.head.profile" var="profile"/>
<spring:message key="submit" var="submit"/>

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
    <!-- Mid pannel -->
<div class = "center_block">
    <div class="center_top"></div>
    <div class = "center_border">
<c:choose>

                    <c:when test="${not empty error_message}">
                    <h4 class="${error_message.type}">${error_message.message}</h4>
                    </c:when>
                    <c:otherwise>
                        <h4 class="text">${profile_message}</h4>
                    </c:otherwise>
                </c:choose>

            <div class = "form_block">
                <form:form method="post" modelAttribute="user" >
                    <form:input path="email" id="email" name = "email" placeholder="${mail}"/>

                    <form:input path="name" id="fname" name="firstname" placeholder="${name}"/>

                    <form:input path="last_name"  id="lname" name="lastname" placeholder="${l_name}"/>


                    <form:password path="pass" id="pass" name="pass" placeholder="${pass}"/>

                    <form:password path="confirm_pass"  id="c_pass" name="c_pass" placeholder="${c_pass}"/>

                    <button class="submit_button" type="submit">${submit}</button>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

