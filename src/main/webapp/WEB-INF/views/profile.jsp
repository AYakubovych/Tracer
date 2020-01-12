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

<spring:message key="child.mail" var="child_mail"/>
<spring:message key="child.pass" var="child_pass"/>
<spring:message key="submit" var="submit"/>

<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="../../../styles/style.css">
</head>
<body style="background-color:#F2F2F2;">

<!-- Top pannel -->
<div class="top_menu_bar">
    <span class="spam" style="float:left;margin-left: 20%">
        <p class="top_bar_text" onclick="openMain()">ServerSideDiplom</p>
    </span>
    <span class="spam" style="float:right;margin-right: 20%">
            <c:choose>
                <c:when test="${cookie.containsKey('id') }">
                    <p class="top_bar_text" onclick="openProfile()">${head_profile} </p>
                    <p class="top_bar_text" onclick="openLogOut()" > ${head_log_out}</p>
                </c:when>
                <c:otherwise>
                    <p class="top_bar_text" onclick="openLogIn()" >${head_log_in} </p>
                    <p class="top_bar_text" onclick="openCreate()"> ${head_createp_rofile}</p>
                </c:otherwise>
            </c:choose>

    </span>
</div>
<div style="height:90px;"></div>

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
                        <h4 class="in_box_text">${user.child.name}</h4>
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
