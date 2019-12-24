<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:message key="label_users" var="labelUsers"/>
<spring:message key="all.head.profile" var="profile"/>
<spring:message key="head.create.profile" var="head_createp_rofile"/>
<spring:message key="head.profile" var="head_profile"/>
<spring:message key="head.log_out" var="head_log_out"/>
<spring:message key="head.log_in" var="head_log_in"/>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="../../../styles/style.css">
</head>
<body style="background-color:#F2F2F2;">

<!-- Top pannel -->

<div class="top_menu_bar">
		<span class="spam" style="float:left;margin-left: 20%">
				<p class="top_bar_text"  onclick="openMain()">ServerSideDiplom</p>
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

<h1>${labelUsers}</h1>
<c:if test = "${not empty users}">
    <table>
        <thead>
        <th>First Name</th>
        <th>Last Name</th>
        <th>E-mail</th>
        </thead>
    <tbody>
    <c:forEach items = "${users}" var = "user">
        <tr>
            <td>${user.name}</td>
            <td>${user.last_name}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
</c:if>


</body>
</html>

<script language="javascript" type="text/javascript">
    function openProfile()
    {
        window.open("profile.jsp","_self");
    }
    function openMain()
    {
        window.open("/","_self");
    }
    function openLogIn()
    {
        window.open("log_in.jsp","_self");
    }
    function openLogOut()
    {
        window.open("log_out","_self");
    }
    function openCreate()
    {
        window.open("/create","_self")
    }
</script>