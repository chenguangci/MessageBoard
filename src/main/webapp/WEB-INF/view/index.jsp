<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>留言板</title>
    <link href="${path}/static/css/bootstrap.css" rel="stylesheet" />
    <link href="${path}/static/css/font-awesome.css" rel="stylesheet" />
    <link href="${path}/static/css/style2.css" rel="stylesheet" />
    <script src="${path}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
    <script>
        function main(id) {
            if (document.getElementsByName("main"+id).length<=0){
                var a = "<div name=\"main"+id+"\" id=\"main"+id+"\">" +
                    "<textarea style=\"width: 50%;height: 60px;\" id=\"replyContext"+id+"\"></textarea>"+
                    "<br><input type=\"button\" value=\"提交 >\" onclick='reply("+id+")'/></div>";
                $("#reply"+id).prepend(a);
            } else {
                $("#main"+id).remove();
            }
        }
        function reply(id) {
            var context = $("#replyContext"+id).val();
            $.ajax({
                url:'${path}/index/insertReply',
                data:{
                    messageId:id,
                    context:context
                },
                dataType:'json',
                type:'POST',
                success:function (data) {
                    alert(data.msg);
                    $("#main"+id).remove();
                    var reply = "<h3>"+context+"<br></h3><h5>"+data.userName+"&nbsp;&nbsp;&nbsp;&nbsp;"+data.time+"</h5>";
                    $("#reply"+id).prepend(reply)
                }
            })
        }
        function submitMessage() {
            var context = $("#context").val();
            $.ajax({
                url:'${path}/index/insertMessageBoard',
                data:{
                    context:context
                },
                dataType:'json',
                type:'POST',
                success:function (data) {
                    alert(data.msg);
                    $("#context").val("")
                }
            })
        }
    </script>

</head>
<body>
<div id="header">
    <div class="overlay">
        <div class="container">
            <div class="row">
                <div class="col-md-8 header-text-top " id="about">
                    <h1>这可能是世界上最好的留言板</h1>
                    今天天气怎么样？ <br />
                    写留言告诉我，今夜你想要梦什么？<br />
                    <h2>Hello<strong> ? </strong></h2>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8 ">
            <c:forEach items="${messageBoard}" var="message"><br><br>
                <div class="blog-post" style="margin: auto;padding: 30px; background-color: rgba(168,168,168,0.3)">
                    <h2>来自：${message.userName}</h2>                 <!-- 用户名位置 -->
                    <h4>${message.createDate}</h4>          <!-- 时间位置 -->
                    <p>
                            ${message.context}     <!-- 内容位置 -->
                    </p>
                    <c:if test="${sessionScope.userType>=0}">
                        <input type="button" value="评论 >" onclick="main(${message.messageBoardId})"/>
                    </c:if>
                    <br><br>
                    <div id="reply${message.messageBoardId}" style="padding: 20px; background-color: rgba(200,200,200,0.3)">
                        <c:forEach items="${message.replies}" var="reply">
                            <h3>${reply.context}<br></h3>
                            <h5>${reply.userName}&nbsp;&nbsp;${reply.createDate}</h5>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
            <br />
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-3" style="padding-top: 30px;">
            <div class="row">
                <ul class="list-group">
                    <li class="list-group-item">用户操作</li>
                    <li class="list-group-item"><a href="${path}/user">返回首页</a></li>
                    <li class="list-group-item"><a href="${path}/user/operation/login">退出登陆</a></li>
                    <c:if test="${sessionScope.userType>=0}">
                        <li class="list-group-item">编写留言<br><textarea id="context" style="width: 100%;height: 60px;"></textarea><br>
                            <input type="button" value="提交 >" onclick="submitMessage()"/></li>
                        <!-- 编写留言超链接 -->
                    </c:if>
                </ul>
            </div>
        </div>

    </div>


</div>

<!--END HOME PAGE SECTION-->
<div class="footer-sec" style="margin-top: 0;">
    <div class="container">
    </div>
</div>


</body>
</html>
