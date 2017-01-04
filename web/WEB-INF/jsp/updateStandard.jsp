<%--
  Created by IntelliJ IDEA.
  User: 25397
  Date: 2016/12/22
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

</head>
<body>
<form action="/UpdateServlet" method="post" enctype="multipart/form-data">
    <input type="text" hidden name="id" value="${requestScope.standard.id}"/>
    标准号：<input type="text" readonly="readonly" id="std_num" name="std_num"  value="${requestScope.standard.std_num}"/><br/>
    中文名称：<input type="text" id="zhname" name="zhname" value="${requestScope.standard.zhname}"/><br/>
    版本：<input type="text" id="version" name="version" value="${requestScope.standard.version}"/><br/>
    关键字：<input type="text" id="skeys" name="skeys" value="${requestScope.standard.skeys}"/><br/>
    发布日期(yyyy-MM-dd)： <input type="text" class="Wdate" id="release_date" name="release_date"
                             onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" size="21"
                             value="${requestScope.standard.release_date}" /><br/>
    实施日期(yyyy-MM-dd)：<input type="text" class="Wdate" id="impl_date" name="impl_date"
                            onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" size="21"
                            value="${requestScope.standard.impl_date}" /><br/>
    附件：<input type="file" name="package_path"/><br/>
    <input type="submit" value="保存"/>&nbsp;
    <input type="reset" value="取消"/>
</form>

</body>
</html>
