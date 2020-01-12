<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:message key="head.create.profile" var="head_createp_rofile"/>
<spring:message key="head.profile" var="head_profile"/>
<spring:message key="head.log_out" var="head_log_out"/>
<spring:message key="head.log_in" var="head_log_in"/>


<html>
<head>
    <title>Tracking</title>
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
        <div class="text_box">


        <!-- tracking service -->


                <c:forEach items="${locationMap.keySet()}" var="date">
                    <h4>${date}</h4>
                        <c:forEach items="${locationMap.get(date)}" var="time">
                            <a target="_blank"
                               href="https://www.google.com/maps/place/${time.getLatitude()}N+${time.getLongitude()}E">
                               ${time.getTime()}
                            </a><br>
                        </c:forEach>
                </c:forEach>




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
</script>
<!--
<script>
    var dd2options = ${dd2optionsAsJSObject};
    var dd3options = ${dd3optionsAsJSObject};
    function dd1change(dd1) {
        // Fill dd2 options based on selected dd1 value.
        var selected = dd1.options[dd1.selectedIndex].value;
    ...
    }
    function dd2change(dd2) {
        // Fill dd3 options based on selected dd2 value.
        var selected = dd2.options[dd2.selectedIndex].value;
    ...
    }
</script>

-->