<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/13
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script src="../../static/js/cookie_openid.js"></script>
</head>
<body>
<p style="display: none" id="id"><%=request.getAttribute("openID")%></p>
<script>
//  function setCookie(cookieName,cookieValue){
//    var theCookie = cookieName + "=" + cookieValue;
//    var date = new Date("June 3, 2030");
//    var cookieDate = date.toGMTString();
//    theCookie += ";expires=" + cookieDate+";path=/";
//    document.cookie = theCookie;
//  }
  var id=document.getElementById("id").innerHTML;
  setCookie("openid",id,10000);
//  alert(getCookie("openid"));
  window.window.location.href="../../userMessage.html";
</script>
</body>
</html>
