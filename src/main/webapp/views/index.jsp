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
                        <li style="float: right"><a href="${pageContext.request.contextPath}/profile">${head_profile}</a></li>
                        <li style="float: right"><a href="${pageContext.request.contextPath}/logout">${head_log_out}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li style="float: right"><a href="${pageContext.request.contextPath}/create">${head_createp_rofile}</a></li>
                        <li style="float: right"><a href="${pageContext.request.contextPath}/login">${head_log_in}</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>
<div><a href="?lang=ru_RU">[RU]</a><a href="?lang=en_EU">[EN]</a></div>

<!--Grid-->
    <div id="three-column" class="container">
        <div class="tbox1">
            <div class="box-style box-style01">
                <div class="content">
                    <div class="image"><img  src="images/github.png" width="250" height="250" alt="" /></div>
                    <h2>GitHub</h2>
                    <p>${github}</p>
                    <a href="https://github.com/AYakubovych/Tracer" class="button">${here}</a>
                </div>
            </div>
        </div>
        <div class="tbox2">
            <div class="box-style box-style02">
                <div class="content">
                    <div class="image"><img  src="images/javaee.png" width="250" height="250" alt="" /></div>
                    <h2>Java</h2>
                    <p>${java}</p>
                </div>
            </div>
        </div>
        <div class="tbox3">
            <div class="box-style box-style03">
                <div class="content">
                    <div class="image"><img  src="images/spring.png" width="250" height="250" alt="" /></div>
                    <h2>Spring</h2>
                    <p>${spring}</p>
                </div>
            </div>
        </div>

    </div>
    <div id="three-column" class="container">
        <div class="tbox1">
            <div class="box-style box-style01">
                <div class="content">
                    <div class="image"><img  src="images/hibernate.png" width="250" height="250" alt="" /></div>
                    <h2>Hibernate</h2>
                    <p>${hibernate}</p>
                </div>
            </div>
        </div>
        <div class="tbox2">
            <div class="box-style box-style02">
                <div class="content">
                    <div class="image"><img  src="images/postgres.jpg" width="250" height="250" alt="" /></div>
                    <h2>PostgreSQL</h2>
                    <p>${postgre}</p>
                </div>
            </div>
        </div>
        <div class="tbox3">
            <div class="box-style box-style03">
                <div class="content">
                    <div class="image"><img  src="images/android.png" width="250" height="250" alt="" /></div>
                    <h2>Android</h2>
                    <p>${android}</p>
                    <a href="https://github.com/AYakubovych/AndroidAppDiplom" class="button">${here}</a>
                </div>
            </div>
        </div>
    </div>
    <div id="three-column" class="container">
        <div class="tbox1">
            <div class="box-style box-style01">
                <div class="content">
                    <div class="image"><img src="images/tomcat.jpg" width="250" height="250" alt="" /></div>
                    <h2>Tomcat</h2>
                    <p>${tomcat}</p>
                </div>
            </div>
        </div>
        <div class="tbox2">
            <div class="box-style box-style02">
                <div class="content">
                    <div class="image"><img  src="images/ubuntu.png" width="250" height="250"alt="" /></div>
                    <h2>Ubuntu</h2>
                    <p>${ubuntu}</p>
                </div>
            </div>
        </div>
        <div class="tbox3">
            <div class="box-style box-style03">
                <div class="content">
                    <h2>Test user is:</h2>
                    <p>asd@asd.com</p>
                    <h2>Password:</h2>
                    <p>asd</p>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

