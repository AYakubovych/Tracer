<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message key="create.form.message" var="profile_message"/>
<spring:message key="all.head.profile" var="profile"/>
<spring:message key="head.create.profile" var="head_createp_rofile"/>
<spring:message key="head.profile" var="head_profile"/>
<spring:message key="head.log_out" var="head_log_out"/>
<spring:message key="head.log_in" var="head_log_in"/>
<spring:message key="head.main" var="head_main"/>
<spring:message key="about" var="about_project"/>
<spring:message key="tracking" var="tracking"/>

<!--Map scripts -->
<script>
    var map;
    var marker;
    var loc;
    var selectValue;
    var res;
    function initMap() {
        loc = {lat: 52.425962, lng: 18.670546};
        map = new google.maps.Map(
            document.getElementById('map'), {zoom: 4, center: loc});
    }
    function markerSet() {
        selectValue = document.getElementById("select").value;
        res = selectValue.split(" ");
        loc = {lat: parseFloat(res[0]), lng: parseFloat(res[1])};
        map = new google.maps.Map(document.getElementById("map"),{zoom: 12, center: loc});
        marker = new google.maps.Marker({position: loc, map: map});
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=${api_key}&callback=initMap">
</script>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/tracer.png" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Tracer</title>
    <link href="http://fonts.googleapis.com/css?family=Oxygen:400,700,300" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="${pageContext.request.contextPath}/styles/main.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="${pageContext.request.contextPath}/styles/index.css" rel="stylesheet" type="text/css" media="screen" />
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

    <!-- Body -->

    <div id="three-column" class="container">

        <div class = "center_main_left">
            <div class="main_left">
                <h4 class="text">If you have something to say. Please do it.</h4>
                <form method="get" action="${pageContext.request.contextPath}/mail">
                    <textarea name="text" id="text" class="textarea" placeholder=" Write here.." cols="48"></textarea>
                    <input class="feedBackButton" type="submit" value="Send feedback"/>
                </form>

            </div>
        </div>


        <div class="center_main_right">
            <div class="main_right">
                <div class="main_map" id="map"></div>
            </div>
        </div>

        <div class="center_targets">

            <div class = "center_add_target2">
                <div class="image_margin">

                    <img  src="${pageContext.request.contextPath}/images/tracer.png" width="250" height="250" alt="" />
                    <sec:authorize access="!isAuthenticated()">
                        <a class="form_button" style="background: #204969;" href="${pageContext.request.contextPath}/create">${head_createp_rofile}</a>
                        <a class="form_button" style="background: #204969;" href="${pageContext.request.contextPath}/login">${head_log_in}</a>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <a class="form_button" style="background: #204969;" href="${pageContext.request.contextPath}/profile">${profile}</a>
                        <a class="form_button" style="background: #204969;" href="${pageContext.request.contextPath}/tracking">${tracking}</a>

                    </sec:authorize>
                </div>
            </div>

            <div class = "center_add_target">
                <div class="image_margin">

                    <img  src="${pageContext.request.contextPath}/images/user.png" width="250" height="250" alt="" />
                        <sec:authorize access="!isAuthenticated()">
                            <a class="form_button" style="background: #A80038;"   href="${pageContext.request.contextPath}/login?test=true">Test user</a>
                        </sec:authorize>

                    <a class="form_button" style="background: #A80038;" href="${pageContext.request.contextPath}/about">${about_project}</a>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
