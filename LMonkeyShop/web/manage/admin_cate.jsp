<%--
  Created by IntelliJ IDEA.
  User: 马志伟
  Date: 2020/11/29
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
        <div class="result-wrap">
            <form id="myform" action="admin_doucatedel" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_tocateadd"><i class="icon-font"></i>新增分类</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="50%">
                        <tr>

                            <th>ID</th>
                            <th>分类名称</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="cate" items="${catelist}">
                            <c:if test="${cate.CATE_PARENT_ID==0}">
                                <tr>
                                    <td>${cate.CATE_ID}</td>
                                    <td>${cate.CATE_NAME}</td>
                                    <td>
                                        <a class="link-update" href="admin_tocateupdate?id=${cate.CATE_ID}">修改</a>

                                        <a class="link-del" href="javascript:Delete('你确定要删除【${cate.CATE_NAME}】分类吗','admin_docatedel?id=${cate.CATE_ID}')">删除</a>

                                    </td>
                                </tr>
                            </c:if>
                            <c:forEach var="zcate" items="${catelist}">
                                <c:if test="${zcate.CATE_PARENT_ID==1}">
                                    <c:if test="${zcate.CATE_PARENT_ID==cate.CATE_ID}">
                                        <tr>
                                            <td>${zcate.CATE_ID}</td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${zcate.CATE_NAME}</td>
                                            <td>
                                                <a class="link-update" href="admin_tocateupdate?id=${zcate.CATE_ID}">修改</a>

                                                <a class="link-del" href="javascript:Delete('你确定要删除【${zcate.CATE_NAME}】用户吗','admin_docatedel?id=${zcate.CATE_ID}')">删除</a>

                                            </td>
                                        </tr>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                            <c:forEach var="xcate" items="${catelist}">
                                <c:if test="${xcate.CATE_PARENT_ID==2}">
                                    <c:if test="${xcate.CATE_PARENT_ID==cate.CATE_ID}">
                                        <tr>
                                            <td>${xcate.CATE_ID}</td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${xcate.CATE_NAME}</td>
                                            <td>
                                                <a class="link-update" href="admin_tocateupdate?id=${xcate.CATE_ID}">修改</a>

                                                <a class="link-del" href="javascript:Delete('你确定要删除【${xcate.CATE_NAME}】用户吗','admin_docatedel?id=${xcate.CATE_ID}')">删除</a>

                                            </td>
                                        </tr>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                            <c:forEach var="ccate" items="${catelist}">
                            <c:if test="${ccate.CATE_PARENT_ID==3}">
                                <c:if test="${ccate.CATE_PARENT_ID==cate.CATE_ID}">
                                    <tr>
                                        <td>${ccate.CATE_ID}</td>
                                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ccate.CATE_NAME}</td>
                                        <td>
                                            <a class="link-update" href="admin_tocateupdate?id=${ccate.CATE_ID}">修改</a>

                                            <a class="link-del" href="javascript:Delete('你确定要删除【${ccate.CATE_NAME}】用户吗','admin_docatedel?id=${ccate.CATE_ID}')">删除</a>

                                        </td>
                                    </tr>
                                </c:if>
                            </c:if>

                        </c:forEach>
                        </c:forEach>
                        <script>
                            function Delete(mess,url) {
                                if (confirm(mess)){
                                    location.href=url;
                                }
                            }



                        </script>
                    </table>

                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>