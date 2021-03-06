<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message key="create.form.message" var="profile_message"/>
<spring:message key="all.head.profile" var="profile"/>
<spring:message key="head.create.profile" var="head_createp_rofile"/>
<spring:message key="head.profile" var="head_profile"/>
<spring:message key="head.log_out" var="head_log_out"/>
<spring:message key="head.log_in" var="head_log_in"/>
<spring:message key="head.main" var="head_main"/>

<spring:message key="name" var="name"/>
<spring:message key="last.name" var="surname"/>
<spring:message key="mail" var="mail"/>
<spring:message key="phone" var="phone"/>

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

<script>
    function deleteFunction() {
        var person = prompt("Please enter target index", "0");
        if (person != null) {
        }
        console.log("/profile");
        console.log(person);
        deleteData(person, "/profile");
    }
    function deleteData(item, url) {
        fetch(url + '/' + item, {
            method: 'delete'
        }).then((data) => window.location.replace("/tracking"));
        //location.reload();
    }
</script>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Tracer</title>
    <link href="http://fonts.googleapis.com/css?family=Oxygen:400,700,300" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="${pageContext.request.contextPath}/styles/main.css" rel="stylesheet" type="text/css" media="screen" />
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

    <!-- Main Page -->
            <div id="three-column" class="container">

                <div class = "center_main_left">
                    <div class="main_left">
                        <div class="inll">
                            <div class="targetImage">
                                <img class="imageBor" src="${pageContext.request.contextPath}/images/nophoto.png" >
                            </div>
                        </div>
                        <div class="inll">
                            <div class="data">
                                <input type="image" src="${pageContext.request.contextPath}/images/settings.png" onclick="location.href = '/profile';" width="24" height="24" alt="Settings">
                                <h4 class="data_text">${name}: ${targetInfo.name}</h4>
                                <h4 class="data_text">${surname}: ${targetInfo.surname}</h4>
                                <h4 class="data_text">${mail}: ${targetInfo.email}</h4>
                                <h4 class="data_text">${phone}: ${targetInfo.phone}</h4>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="center_main_right">
                    <div class="main_right">
                        <div class="main_map" id="map"></div>
                    </div>
                </div>

                <div class="center_targets">

                    <div class = "center_add_target2">
                        <select id = "select">
                            <c:forEach items="${locationMap.keySet()}" var = "date">
                                <optgroup label="${date}">${date}</optgroup>
                                <c:forEach items="${locationMap.get(date)}" var = "time_entity">
                                    <option value="${time_entity.getLatitude()} ${time_entity.getLongitude()}">${time_entity.getTime()}</option>
                                </c:forEach>
                            </c:forEach>

                        </select>
                        <button onclick="markerSet()">Track</button>
                    </div>

                    <div class = "center_add_target">
                        <div class="inlineDiv">
                            <button class="halfButton"
                                    style="background: #204969;color: white"
                                    onclick="location.href = '/adding'">Add</button>
                        </div>
                        <div class="inlineDiv">
                            <button class="halfButton"
                                    style="background: #A80038;color: white"
                                    onclick="deleteFunction()">Remove</button>
                        </div>
                            <c:forEach items="${targets}" var = "target">
                            <button class="testButton" onclick="location.href = '/tracking/${target.i}';">${target.i}. ${target.s}</button>
                        </c:forEach>

                    </div>

                </div>

            </div>

</div>
</body>
</html>


