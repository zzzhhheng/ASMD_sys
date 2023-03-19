<%@ page contentType="text/html;charset=UTF-8"  %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
     <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="<%= basePath+"loginWindow/css/master.css" %>" />
</head>
<body>
<div class="login-box">
    <img src="<%= basePath +"loginWindow/img/logo.png"%>" class="avatar" alt="Avatar Image">
    <h1>Login Here</h1>
    <form action="/login" method="post">
        <!-- USERNAME INPUT -->
        <label for="username">Username</label>
        <input type="text" placeholder="Enter Username" id="username">
        <!-- PASSWORD INPUT -->
        <label for="password">Password</label>
        <input type="password" placeholder="Enter Password" id="password">
        <input type="submit" value="Log In">
        <a href="#">Lost your Password?</a><br>
        <a href="#">Don't have An account?</a>
    </form>
</div>
</body>
</html>
