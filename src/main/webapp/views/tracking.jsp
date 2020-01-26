<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href="${pageContext.request.contextPath}/styles/map.css" rel="stylesheet" type="text/css" media="screen" />
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

    <div id="three-column" class="container">
        <div class="tbox1">
            <div class="box-style box-style01">
                <div class="content">
                    <!-- tracking service -->
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
            </div>
        </div>
        <div class="doubletbox">
            <div class="box-style box-style02">
                <div style="width: 748px">
                    <div class="map" id="map"></div>
                </div>
            </div>
        </div>

    </div>

</div>

</body>
</html>

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

<!--
<script>
//Default new marker func
function newMarker(latt,longg) {
loc = {lat: latt, lng: longg};
map = new google.maps.Map(document.getElementById("map"),{zoom: 12, center: loc});
marker = new google.maps.Marker({position: loc, map: map});
}
</script>
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