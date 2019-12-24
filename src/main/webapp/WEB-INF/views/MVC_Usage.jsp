<%--
  Created by IntelliJ IDEA.
  User: ayaku
  Date: 20.10.2019
  Time: 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Util.CookieCheck" %>
<html>
<head>
    <title>MVC_Usage</title>
    <link href="../../style.css" rel="stylesheet" type="text/css">
</head>
<body style="background-color:#F2F2F2;">

<!-- Top pannel -->

    <div class="top_menu_bar">
		<span class="spam" style="float:left;margin-left: 20%">
            <p class="top_bar_text" onclick="openMain()">ServerSideDiplom</p>
		</span>
        <span class="spam" style="float:right;margin-right: 20%">
                <%
                Cookie[] cookies = request.getCookies();
                CookieCheck cookieCheck = new CookieCheck(cookies);
                        if (cookieCheck.check()) {
                            out.print(" <p class=\"top_bar_text\" onclick=\"openProfile()\" >Profile </p>");
                            out.print(" <p class=\"top_bar_text\" onclick=\"openLogOut()\" > Log out</p>");
                        } else {
                            out.print("<p class=\"top_bar_text\" onclick=\"openLogIn()\" >Log in</p>");
                            out.print("<p class=\"top_bar_text\" onclick=\"openCreate\"> Create account</p>");
                        }

            %>
        </span>
    </div>
</div>

<div style="height:90px;"></dir>

<div class = "center_block">
    <div class="center_top"></div>
    <div class = "center_border">
        <div class="text_box">
            <h4 class="text_class" style="color: #A80038">M: Profile (from PSQL)</h4>
            <h4 class="text_class" style="color: #204969">V: This and profile JSP</h4>
            <h4 class="text_class" style="color: #2B2024">C: Cookie deploy and PSQL update</h4>
            <h4 class="text_class" style="color: #2B2024"> </h4>

            <h4 class="text_class" style="color: #2B2024">PSQL used by Hibernate</h4>
            <h4 class="text_class" style="color: #2B2024">Cookie set for day</h4>


            <form action="profile.jsp" method="post">

                <input type="submit" value="Go to Profile">
            </form>

        </div>
    </div>
</div>

<dir style="height:90px;"></dir>

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
