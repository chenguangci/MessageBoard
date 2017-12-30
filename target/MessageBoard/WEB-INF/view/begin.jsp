<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>留言板</title>
    <link rel="stylesheet" href="${path}/static/css/style.css">
</head>
<body class="no-js">
<section class="main">
    <section class="caption">
        <div class="wrap" style="padding-top: 10px">
            <h1>Hello! Welcome to the best message board!<br>Say what you think and leave your
                message.</h1>
        </div><!-- wrap -->
    </section><!-- caption -->
    <section class="slider">
        <div class="wrap">
            <div class="swiper-container">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <img src="${path}/static/image/Color Burst 1 small.jpg" width="940" height="360" alt="">
                    </div><!-- swiper-slide -->
                    <div class="swiper-slide">
                        <img src="${path}/static/image/Color Burst 2 small.jpg" width="940" height="360" alt="">
                    </div><!-- swiper-slide -->
                    <div class="swiper-slide">
                        <img src="${path}/static/image/Color Burst 3 small.jpg" width="720" height="405" alt="">
                    </div><!-- swiper-slide -->
                </div>
                <div class="swiper-pagination-wrapper">
                    <div class="swiper-pagination"></div>
                </div><!-- /swiper-pagination-wrapper -->
            </div>
        </div><!-- wrap -->
    </section><!-- slider -->
    <section class="features">
        <div class="wrap">
            <div class="features-columns clearfix">
                <div class="features-column">
                    <span class="ico-bulb"></span>
                    <a href="${path}/user/operation/load"><h1>过&nbsp;&nbsp; 客<br />Safari</h1></a><!--/////////////////没有账号的过客浏览入口-->
                    <p>这个留言板好像很有趣，进去看看！</p>
                </div><!-- features-column -->
                <div class="features-column">
                    <span class="ico-rocket"></span>
                    <a href="${path}/user/operation/login"><h1>登&nbsp;&nbsp; 陆<br> Login</h1></a><!--////////////////管理员和用户的登陆入口-->
                    <p>看看今天又又什么新的留言！</p>
                </div><!-- features-column -->
                <div class="features-column">
                    <span class="ico-flag"></span>
                    <a href="${path}/user/operation/register"><h1>注&nbsp;&nbsp; 册<br />Register</h1></a><!--/////////////////过客的注册入口-->
                    <p>创建个账号吧！</p>
                </div><!-- features-column -->
            </div><!-- features-columns -->
        </div><!-- wrap -->
    </section><!-- features -->

    <section class="newsletter">
        <div class="wrap">
            <div class="newsletter-title">Have a good day.</div>


        </div><!-- wrap -->
    </section><!-- newsletter -->
</section><!-- main -->
<footer>
    <div class="wrap">
        <div class="social">
            <ul class="clearfix">
                <li><a class="social-facebook" href="#" title="facebook">facebook</a></li>
                <li><a class="social-twitter" href="#" title="twitter">twitter</a></li>
                <li><a class="social-googleplus" href="#" title="google plus">google plus</a></li>
            </ul>
        </div><!-- social -->
    </div><!-- wrap -->
    <div class="footer-image"></div>
</footer>
<script src="${path}/static/js/jquery.js"></script>
<script src="${path}/static/js/library.js"></script>
<script src="${path}/static/js/script.js"></script>
<script src="${path}/static/js/retina.js"></script>
</body>
</html>
