<%-- shiro标签库--%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<%--身份认证通过 展示标签体内容--%>
<shiro:authenticated>
    <%--获取主体的身份信息--%>
    欢迎您:
    <shiro:principal></shiro:principal>

    <a href="${pageContext.request.contextPath}/user/logout">[登出]</a>
</shiro:authenticated>

<%--身份未认证通过 展示标签体内容--%>
<shiro:notAuthenticated>
    <a href="${pageContext.request.contextPath}/login.jsp">[登陆]</a>
    <a href="${pageContext.request.contextPath}/register.jsp">[注册]</a>
</shiro:notAuthenticated>

<%--认证通过或者记住我登陆 展示标签体内容--%>
<shiro:user></shiro:user>
<%--认证未通过或者记住我未通过 展示标签体内容--%>
<shiro:guest></shiro:guest>

<hr>
<shiro:hasRole name="root">
    主体<shiro:principal></shiro:principal> 有root角色
</shiro:hasRole>

<hr>
<shiro:hasAnyRoles name="root,admin,user">
    主体<shiro:principal></shiro:principal> 有root admin user角色
</shiro:hasAnyRoles>

<hr>
<shiro:hasAnyRoles name="root,aa">
    主体<shiro:principal></shiro:principal> 有root aa角色
</shiro:hasAnyRoles>

<hr>
<%-- 缺失角色--%>
<shiro:lacksRole name="aa">
    主体<shiro:principal></shiro:principal> 缺失aa角色
</shiro:lacksRole>
<shiro:lacksRole name="root">
    主体<shiro:principal></shiro:principal> 缺失root角色
</shiro:lacksRole>

<%--<hr>--%>
<%--<shiro:hasPermission name="user:add">--%>
    <%--主体<shiro:principal></shiro:principal> 有对用户资源的添加权限--%>
<%--</shiro:hasPermission>--%>
</body>
</html>
