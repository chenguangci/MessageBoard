<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Nice responsive template for blogger</title>
    <link href="${path}/static/css/bootstrap.css" rel="stylesheet" />
    <link href="${path}/static/css/font-awesome.css" rel="stylesheet" />
    <link href="${path}/static/css/style2.css" rel="stylesheet" />
    <script src="${path}/static/js/jquery-3.2.1.min.js"></script>
    <script>
        function examine(isPass, id) {
            $.ajax({
                url:'${path}/result',
                data: {
                    state:isPass,
                    messageId:id
                },
                dataType:'json',
                type:'POST',
                success:function (data) {
                    $("#message"+id).remove();
                    alert(data.msg);
                    if (document.getElementsByName("msg").length<=0){
                        $("#panel").append("<div class=\"blog-post\"><p>没有待审核的留言</p></div>")
                    }

                }
            });

        }
    </script>
</head>
<body>
<div id="header">
    <div class="overlay">
        <div class="container">
            <div class="row">
                <div class="col-md-8 header-text-top " id="about">
                    <h1>This is the best message board You&#39;ve never seen.</h1>
                    Leave your message . <br />
                    Say what you think.<br />
                    <h2>Hello<strong> ? </strong></h2>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8 " id="panel">
            <c:if test="${fn:length(messageBoard)<=0}">
                <div class="blog-post"><p>没有待审核的留言</p></div>
            </c:if>
            <c:forEach items="${messageBoard}" var="message">
                <div class="blog-post" name="msg" id="message${message.messageBoardId}">
                    <h2>来自${message.userName}&nbsp;&nbsp;时间：${message.createDate}</h2>
                    <p>
                        ${message.context}
                    </p>
                    <input type="button" value="通过" onclick="examine(1,${message.messageBoardId})"/>&nbsp;&nbsp;
                    <input type="button" value="不通过" onclick="examine(-1,${message.messageBoardId})"/>
                </div>
                <br/>
            </c:forEach>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-3" style="padding-top: 30px;">
            <div class="row">
                <ul class="list-group">
                    <li class="list-group-item">管理员操作</li>
                    <li class="list-group-item"><a href="${path}/user">返回首页</a></li>
                    <li class="list-group-item"><a href="${path}/index">进入留言板首页</a></li>

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
<script src="${path}/static/js/jquery-3.2.1.min.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="${path}/static/js/bootstrap.js"></script>

</body>
</html>
