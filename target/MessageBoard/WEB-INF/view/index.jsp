<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
你好：${userName}<br>
    <c:forEach items="${messageBoard}" var="message">
        <h2>
            ${message.context}<br>
        </h2>
        <h4>
            来自：${message.userName}&nbsp;&nbsp;时间：${message.createDate}<br>
        </h4>
        <h3>回复：<br></h3>
        <c:forEach items="${message.replies}" var="reply">
            <h3>${reply.context}<br></h3>
            <h5>${reply.userName}&nbsp;&nbsp;${reply.createDate}</h5>
        </c:forEach>
        ----------------------------------------------------------------
    </c:forEach>
</body>
</html>
