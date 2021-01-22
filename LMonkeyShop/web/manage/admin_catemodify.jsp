<%--
  Created by IntelliJ IDEA.
  User: 马志伟
  Date: 2020/12/2
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_CateSelect">分类管理</a><span class="crumb-step">&gt;</span><span>修改分类</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_docatupdate" method="post" id="myform" name="myform">
                <input type="hidden" name="id" value="${cate.CATE_ID}">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>父级分类：</th>
                        <td>
                            <select class="common-text required" name="parentID">
                                <option value="0" selected="selected">根分类</option>
                                <c:forEach var="catelist" items="${catelist}">
                                    <c:if test="${catelist.CATE_PARENT_ID==0}">
                                        <c:if test="${catelist.CATE_ID==cate.CATE_PARENT_ID}">
                                            <option value="${catelist.CATE_ID}" selected="selected">${catelist.CATE_NAME}</option>
                                        </c:if>
                                        <c:if test="${catelist.CATE_ID !=cate.CATE_PARENT_ID}">
                                            <option value="${catelist.CATE_ID}">${catelist.CATE_NAME}</option>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>分类名称：</th>
                        <td>
                            <input class="common-text required" id="j" name="className" size="50" value="${cate.CATE_NAME}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
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