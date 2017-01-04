<%--
  Created by IntelliJ IDEA.
  User: 25397
  Date: 2016/12/24
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/FileUploadServlet" method="post" enctype="multipart/form-data">
    <input type="text" name="name"/>
    <input type="password" name="password"/>
    <input type="file" name="file"/>
    <input type="submit" value="上传"/>
</form>

</body>
</html>
