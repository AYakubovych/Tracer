<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ddns.net.entities.User" %>
<%@ page import="ddns.net.service.UserServiceImpl" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="../../style.css">
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


            </div>
        </div>
    </div>
</div>
</body>
</html>

<script language="javascript" type="text/javascript">
    function openProfile()
    {
        window.open("profile.jsp","_self");
    }
    function openMain()
    {
        window.open("index.jsp","_self");
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
        window.open("create.jsp","_self");
    }
</script>
