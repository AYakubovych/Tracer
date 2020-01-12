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


<html>
<head>
    <title>Create account</title>
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
<div style="height:48px;"></div>
<div style="height:24px;"><a href="?lang=ru_RU">[RU]</a><a href="?lang=en_EU">[EN]</a></div>
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
</script>
