<%--
  Created by IntelliJ IDEA.
  User: 马志伟
  Date: 2020/12/2
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="admin_douserselect">用户管理</a>
            <span class="crumb-step">&gt;</span><span>修改用户</span>
        </div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_douserupdate" method="post" id="myform" name="myform">
                <input type="hidden" name="userStatus" value="${user.USER_STATUS}">
                <input type="hidden" name="cpage" value="${cpage}">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>用户名：</th>
                        <td>
                            <input class="common-text required" id="title" name="userName" size="50" value="${user.USER_ID}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>用户姓名：</th>
                        <td>
                            <input class="common-text required" id="j" name="name" size="50" value="${user.USER_NAME}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>登录密码：</th>
                        <td>
                            <input class="common-text required" id="y" name="passWord" size="50" value="${user.USER_PASSWORD}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th>性别：</th>
                        <td>
                            <input type="radio" name="sex" value="T" ${USER_SEX=="T"?"checked":""}>男
                            <input type="radio" name="sex" value="F" ${USER_SEX=="F"?"":"checked"}>女
                        </td>
                    </tr>
                    <tr>
                        <th>出生日期：</th>
                        <td><input class="common-text" name="birthday" size="50" value="${user.USER_BIRTHDAY}" type="text"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>电子邮箱：</th>
                        <td>
                            <input class="common-text required" id="m" name="email" size="50" value="${user.USER_EMAIL}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>手机号码：</th>
                        <td>
                            <input class="common-text required" id="" name="mobile" size="50" value="${user.USER_MOBILE}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>送货地址：</th>
                        <td>
                            <input class="common-text required" id=" " name="address" size="50" value="${user.USER_ADDRESS}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                    </tbody></table>
            </form>
        </div>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
