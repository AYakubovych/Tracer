<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:message key="create.form.message" var="profile_message"/>
<spring:message key="all.head.profile" var="profile"/>
<spring:message key="head.create.profile" var="head_createp_rofile"/>
<spring:message key="head.profile" var="head_profile"/>
<spring:message key="head.log_out" var="head_log_out"/>
<spring:message key="head.log_in" var="head_log_in"/>

<spring:message key="here" var="here"/>
<spring:message key="index.github" var="github"/>
<spring:message key="index.java" var="java"/>
<spring:message key="index.android" var="android"/>
<spring:message key="index.ubuntu" var="ubuntu"/>
<spring:message key="index.spring" var="spring"/>
<spring:message key="index.hibernate" var="hibernate"/>
<spring:message key="index.postgres" var="postgre"/>
<spring:message key="index.tomcat" var="tomcat"/>

<html>
<head>
    <title>Main</title>
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

<!-- First Grid-->
<div class="index_block" style="min-width: 1024px">
    <div class="quarter">
        <img src="${pageContext.request.contextPath}/img/github.png" alt="GitHub" width="250" height="250">
        <h3>GitHub</h3>
        <p>${github} <a href="https://github.com/AYakubovych/Tracer" target="_blank">${here}</a>.</p>
    </div>
    <div class="quarter">
        <img src="${pageContext.request.contextPath}/img/javaee.png" alt="Java" width="250" height="250">
        <h3>Java</h3>
        <p>${java}</p>
    </div>
    <div class="quarter">
        <img src="${pageContext.request.contextPath}/img/android.png" alt="Android" width="250" height="250">
        <h3>Android</h3>
        <p>${android} <a href="https://github.com/AYakubovych/AndroidAppDiplom" target="_blank">${here}</a>.
            <!-- You can download it here.--></p>
    </div>
    <div class="quarter">
        <img src="${pageContext.request.contextPath}/img/ubuntu.png" alt="Ubuntu" width="250" height="250">
        <h3>Ubuntu Server</h3>
        <p>${ubuntu}</p>
    </div>
</div>
<!-- Second Grid-->
<div class="index_block" style="min-width: 1024px">
    <div class="quarter">
        <img src="${pageContext.request.contextPath}/img/spring.png" alt="Spring" width="250" height="250">
        <h3>Spring</h3>
        <p>${spring}</p>
    </div>
    <div class="quarter">
        <img src="${pageContext.request.contextPath}/img/hibernate.png" alt="Hibernate" width="250" height="250">
        <h3>Hibernate</h3>
        <p>${hibernate}</p>
    </div>
    <div class="quarter">
        <img src="${pageContext.request.contextPath}/img/postgres.jpg" alt="PostgreSQL" width="250" height="250">
        <h3>PostgreSQL</h3>
        <p>${postgre}</p>
    </div>
    <div class="quarter">
        <img src="${pageContext.request.contextPath}/img/tomcat.jpg" alt="Tomcat" width="250" height="250">
        <h3>Tomcat</h3>
        <p>${tomcat}</p>
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
