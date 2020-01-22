<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <li style="float: right"><a href="/profile">Profile</a></li>
                        <li style="float: right"><a href="/logout">Log Out</a></li>
                    </c:when>
                    <c:otherwise>
                        <li style="float: right"><a href="/create">Create Profile</a></li>
                        <li style="float: right"><a href="/login">Log In</a></li>
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
            <div class="text_box">

                <h4 class="in_box_text">${personal_data}</h4>
                <h4 class="in_box_text">${name}: ${user.name}</h4>
                <h4 class="in_box_text">${surname}: ${user.last_name}</h4>
                <h4 class="in_box_text">${mail}: ${user.email}</h4>

                <c:choose>
                    <c:when test="${user.child != null}">
                        <h4 class="in_box_text">${tracking}: ${user.child.name}</h4>
                        <button class="submit_button" onclick="openTracking()">Track</button>
                    </c:when>
                    <c:otherwise>
                        <form:form method="post" modelAttribute="child" >
                            <form:input path="name" id="email" name = "email" placeholder="${child_mail}"/>

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

<script language="javascript" type="text/javascript">
    function openProfile()
    {
        window.open("/profile","_self");
    }
    function openMain()
    {
        window.open("/","_self");
    }
    function openLogIn()
    {
        window.open("/login","_self");
    }
    function openLogOut()
    {
        window.open("/logout","_self");
    }
    function openCreate()
    {
        window.open("/create","_self");
    }
    function openMap()
    {
        window.open("/map","_self");
    }
    function openTracking()
    {
        window.open("/tracking","_self");
    }
</script>
