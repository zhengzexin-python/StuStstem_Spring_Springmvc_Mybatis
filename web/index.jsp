<%--
  Created by IntelliJ IDEA.
  User: 25397
  Date: 2016/12/22
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        function add() {
            location.href = 'addStandard.jsp';
        }
        function check() {
            var all = $('#all');
            var inputs = $('.product');
            for (var i = 0; i < inputs.length; i++) {
                inputs[i].checked = all.attr('checked');
            }

//            alert($('.product:eq(1)').val());
        }
        function checkall() {
            var all = $('#all');
            var inputs = $('.product');
            var flag = true;
            for (var i = 0; i < inputs.length; i++) {
                if (!inputs.get(i).checked) {
                    flag = false;
                    break;
                }
            }
            all.attr('checked', flag);
        }
        $(this).ready(function () {

        })
    </script>
</head>
<body>
<c:if test="${null==requestScope.standardList}">
    <c:redirect url="GetStandardByPageServlet"></c:redirect>
</c:if>

<table border="1">
    <tr>
        <td colspan="7">
            <form action="/GetStandardByPageServlet" method="post" style="display: inline">
                <input type="text" name="select" value="${requestScope.select}"/><input type="submit" value="提交检索"/>
            </form>
            <input type="button" value="新增标准" id="add" onclick="add()"/>
            <form style="display: inline" action="/DeleteServlet" method="post">
                <input type="submit" value="删除标准"/>
        </td>

    </tr>
    <tr>
        <td><input type="checkbox" id="all" onclick="check()"/></td>
        <td>标准号</td>
        <td>中文名称</td>
        <td>版本</td>
        <td>发布日期</td>
        <td>实施日期</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.standardList}" var="standard">
        <tr>
            <td><input type="checkbox" class="product" onclick="checkall()" name="id" value="${standard.id}"/> </td>
            <td>${standard.std_num}</td>
            <td>${standard.zhname}</td>
            <td>${standard.version}</td>
            <td>${standard.release_date}</td>
            <td>${standard.impl_date}</td>
            <td><a href="/DownloadServlet?id=${standard.id}">下载</a>&nbsp;<a href="/GetStandardServlet?id=${standard.id}">修改</a></td>
        </tr>
    </c:forEach>
    </form>
</table>

<a href="GetStandardByPageServlet?pageIndex=1&select=${requestScope.select}">首页</a>
<a href="GetStandardByPageServlet?pageIndex=${requestScope.page.prevPage}&select=${requestScope.select}">上一页</a>
<a href="GetStandardByPageServlet?pageIndex=${requestScope.page.nextPage}&select=${requestScope.select}">下一页</a>
<a href="GetStandardByPageServlet?pageIndex=${requestScope.page.totalPage}&select=${requestScope.select}">末页</a>

</body>
</html>
