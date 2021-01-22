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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
        <div class="result-wrap">
            <form id="myform" action="admin_doucatedel" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_tocateadd"><i class="icon-font"></i>新增分类</a>
                        <a id="batchDel" href="javascript:delmore('你确定删除这些用户名？','myform')"><i class="icon-font"></i>批量删除</a>
                        <!--<a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>-->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="50%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectall(this)" type="checkbox"></th>
                            <th>ID</th>
                            <th>分类名称</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="cate" items="${catelist}">
                            <c:if test="${cate.CATE_PARENT_ID==0}">
                                <tr>
                                    <td class="tc"><input name="id[]" value="${cate.CATE_ID}" type="checkbox"></td>
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
                                            <td class="tc"><input name="id[]" value="${zcate.CATE_ID}" type="checkbox"></td>
                                            <td>${zcate.CATE_ID}</td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${zcate.CATE_NAME}</td>
                                            <td>
                                                <a class="link-update" href="admin_tocateupdate?id=${zcate.CATE_ID}">修改</a>

                                                <a class="link-del" href="javascript:Delete('你确定要删除【${zcate.CATE_NAME}】用户吗','admin_douserdel?id=${zcate.CATE_ID}')">删除</a>

                                            </td>
                                        </tr>
                                    </c:if>
                                </c:if>

                            </c:forEach>
                            <c:forEach var="xcate" items="${catelist}">
                                <c:if test="${xcate.CATE_PARENT_ID==2}">
                                    <c:if test="${xcate.CATE_PARENT_ID==cate.CATE_ID}">
                                        <tr>
                                            <td class="tc"><input name="id[]" value="${xcate.CATE_ID}" type="checkbox"></td>
                                            <td>${xcate.CATE_ID}</td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${xcate.CATE_NAME}</td>
                                            <td>
                                                <a class="link-update" href="admin_tocateupdate?id=${xcate.CATE_ID}">修改</a>

                                                <a class="link-del" href="javascript:Delete('你确定要删除【${xcate.CATE_NAME}】用户吗','admin_douserdel?id=${xcate.CATE_ID}')">删除</a>

                                            </td>
                                        </tr>
                                    </c:if>
                                </c:if>

                            </c:forEach>
                            <c:forEach var="ccate" items="${catelist}">
                            <c:if test="${ccate.CATE_PARENT_ID==3}">
                                <c:if test="${ccate.CATE_PARENT_ID==cate.CATE_ID}">
                                    <tr>
                                        <td class="tc"><input name="id[]" value="${ccate.CATE_ID}" type="checkbox"></td>
                                        <td>${ccate.CATE_ID}</td>
                                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ccate.CATE_NAME}</td>
                                        <td>
                                            <a class="link-update" href="admin_tocateupdate?id=${ccate.CATE_ID}">修改</a>

                                            <a class="link-del" href="javascript:Delete('你确定要删除【${ccate.CATE_NAME}】用户吗','admin_douserdel?id=${ccate.CATE_ID}')">删除</a>

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
                            function selectall(o) {
                                var a = document.getElementsByName("id[]");
                                for (var i=0;i<a.length;i++){
                                    a[i].checked=o.checked;
                                }
                            }
                            function delmore(mess,formname) {
                                if (confirm(mess)){
                                    var form = document.getElementById(formname);
                                    form.submit();
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