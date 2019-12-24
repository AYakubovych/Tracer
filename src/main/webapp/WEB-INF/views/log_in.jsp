<%--
  Created by IntelliJ IDEA.
  User: ayaku
  Date: 20.10.2019
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Util.CookieCheck" %>
<html>
<head>
    <title>Create account</title>
    <link rel="stylesheet" type="text/css" href="../../style.css">
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
                try{
                    if (cookieCheck.check()) {
                        out.print(" <p class=\"top_bar_text\" onclick=\"openProfile()\" >Profile </p>");
                        out.print(" <p class=\"top_bar_text\" onclick=\"openLogOut()\" > Log out</p>");
                        }
                    else {
                        out.print("<p class=\"top_bar_text\" onclick=\"openLogIn()\" >Log in</p>");
                        out.print("<p class=\"top_bar_text\" onclick=\"openCreate()\"> Create account</p>");
                    }
                }catch (NullPointerException e){
                    out.print("<p class=\"top_bar_text\" onclick=\"openLogIn()\" >Log in</p>");
                    out.print("<p class=\"top_bar_text\" onclick=\"openCreate()\"> Create account</p>");
                }
            %>
    </span>
</div>
<div style="height:90px;"></div>
<!-- Mid pannel -->
<div class = "center_block">
    <div class="center_top"></div>
        <div class = "center_border">
            <h4 style="text-align:center;font-family:Courier New, italic;font-size: 24px;color: #204969">Log in</h4>
            <div class = "form_block">
                <form action="login_logic" method="post">
                    <input type="text" id="email" name = "email" placeholder="Your e-mail..">

                    <input type="password" id="pass" name="pass" placeholder="Your password..">

                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script language="javascript" type="text/javascript">
    function openMain()
    {
        window.open("index.jsp","_self");
    }
    function openProfile()
    {
        window.open("profile.jsp","_self");
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
