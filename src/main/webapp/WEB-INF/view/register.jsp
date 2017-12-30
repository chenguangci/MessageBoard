<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>注册</title>
    <link href="${path}/static/css/layui.css" rel="stylesheet" type="text/css">
    <script src="${path}/static/js/jquery-3.2.1.min.js"></script>
    <script>
        function test() {
            window.location.href = "${path}/user"
        }
        function register() {
            var userName = $("#userName").val();
            var password = $("#password").val();
            var sure = $("#sure").val();
            if(password===sure){
                $.ajax({
                    url:'${path}/user/register',
                    data: {
                        userName:userName,
                        password:password
                    },
                    dataType:'json',
                    type:'POST',
                    success: function (data) {
                        alert(data.msg)
                    }
                })
            } else{
                alert('两次密码不一致')
            }
        }
    </script>
</head>
<body background="${path}/static/image/background.png">
<br><br>
<div style="width: 30%;margin: auto;padding: 50px; background-color: rgba(240,240,240,0.5)">
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="userName" id="userName" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" id="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-inline">
            <input type="password" name="sure" id="sure" required lay-verify="required" placeholder="确认密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" onclick="register()">立即提交</button>
            <button onclick="test()" class="layui-btn layui-btn-primary">返回首页</button>
        </div>
    </div>
</form>
</div>
</body>
</html>
