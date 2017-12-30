<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>欢迎登陆</title>
    <link href="${path}/static/css/layui.css" rel="stylesheet" type="text/css">
</head>
<body background="${path}/static/image/background.png">
<br><br>
<div style="text-align: center">
    <h1 style="font-family: 'Microsoft YaHei UI';font-size: 50px;color: white">—— 登陆 ——</h1><br>
</div>
<div style="width: 30%;margin: auto;padding: 50px; background-color: rgba(240,240,240,0.5)">
    <h2 style="color: red">${msg}</h2>
    <form class="layui-form" action="${path}/user/login">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="userName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>

