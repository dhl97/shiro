<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<body>

<center>
    <h2>登陆页</h2>
    <form method="post" action="${pageContext.request.contextPath}/user/login">
        用户名: <input type="text" name="username">
        密码: <input type="text" name="password">
        记住我: <input type="checkbox" name="rememberMe">
        <input type="submit" value="登陆">
    </form>
</center>
</body>
</html>
