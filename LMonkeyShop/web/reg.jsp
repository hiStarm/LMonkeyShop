<%--
  Created by IntelliJ IDEA.
  User: 马志伟
  Date: 2021/1/10
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script type="text/javascript" src="js/Calendar.js"></script>
    <script type="text/javascript" src="js/function.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>

    <style>
        .reg p ._error{
            display: inline-block;
            border: 1px solid #ff0000;
            background-color: #ff9900;
            margin-left: 20px;
        }
    </style>
</head>
<body><!-------------------reg-------------------------->
    <div class="reg">
        <form action="register" method="post" onsubmit="return CheckForm(this)">
            <!--<h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>-->
            <h1>用户注册</h1>
            <p><input type="text" name="userName" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入用户名"><span></span></p>
            <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入姓名"><span></span></p>
            <p><input type="text" name="passWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
            <p><input type="text" name="rePassWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请确定密码"><span></span></p>
            <p>
                <input style="width: 25px;height: 15px" type="radio" name="sex" value="T" checked="checked">男
                <input style="width: 25px;height: 15px" type="radio" name="sex" value="F" checked="checked">女<span></span>
            </p>
            <p><input type="text" name="birthday" value="" onfocus="new Calendar().show(this);" readonly="readonly"
                      placeholder="请输入出生日期"><span></span></p>
            <p><input type="text" name="email" value="" placeholder="请输入邮箱"><span></span></p>
            <p><input type="text" name="mobile" value="" placeholder="请输入电话号码"><span></span></p>
            <p><input type="text" name="address" value="" placeholder="请输入地址"><span></span></p>
            <p ><input class="code" type="text" name="veryCode" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)"placeholder="验证码">
                <img style="width: 100px;height: 25px" src="getCode" id="img-verify" alt="更换验证码" height="36"
                     onclick="change(this)" ><span></span></p>
            <p><input type="submit" name="" value="注册"><span></span></p>
            <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
                <使用条款和隐私策略/>
            </a></p>
            <p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>
            <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
    </div>
</body>

</html>