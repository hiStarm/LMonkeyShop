<%--
  Created by IntelliJ IDEA.
  User: 马志伟
  Date: 2021/1/20
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                <c:if test="${isLogin !=1}">
                    <a href="login.jsp" id="login">登录</a>
                    <a href="reg.jsp" id="reg">注册</a>
                </c:if>
                <c:if test="${isLogin==1}">
                    你好:<a href="login.jsp" id="login">${name.USER_NAME }</a>

                </c:if>
                <c:if test="${isAdminLogin==1}">
                    <a href="/shop/manage/admin_index.jsp" id="login">进入后台</a>
                </c:if>
                </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix">
                    <c:if test="${isLogin==1}">
                        <a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                    </c:if>
                    <a href="#" class="er1"><img src="img/ewm.png"/></a>
                    <c:if test="${isLogin==1}">
                        <a href="cart.html"><img src="img/gwc.png"/></a>
                    </c:if>
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
                </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="#">所有商品</a>
                <div class="sList">
                    <div class="wrapper  clearfix"><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav1.jpg"/></dt>
                            <dd>浓情欧式</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav2.jpg"/></dt>
                            <dd>浪漫美式</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav3.jpg"/></dt>
                            <dd>雅致中式</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav6.jpg"/></dt>
                            <dd>简约现代</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="img/nav7.jpg"/></dt>
                            <dd>创意装饰</dd>
                        </dl>
                    </a></div>
                </div>
            </li>
            <li><a href="flowerDer.html">装饰摆件</a>
                <div class="sList2">
                    <div class="clearfix"><a href="proList.html">干花花艺</a><a href="vase_proList.html">花瓶花器</a></div>
                </div>
            </li>
            <li><a href="decoration.html">布艺软饰</a>
                <div class="sList2">
                    <div class="clearfix"><a href="zbproList.html">桌布罩件</a><a href="bzproList.html">抱枕靠垫</a></div>
                </div>
            </li>
            <li><a href="paint.html">墙式壁挂</a></li>
            <li><a href="perfume.html">蜡艺香薰</a></li>
            <li><a href="idea.html">创意家居</a></li>
        </ul>
    </div>
</div>
