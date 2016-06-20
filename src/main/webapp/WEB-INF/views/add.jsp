<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/19 0019
  Time: 下午 6:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/added" method="post">
    <fieldset>
        <legend>添加用户</legend>
        <p>联系人ID：<input placeholder="id" type="text" name="id"></p>
        <p>联系人姓名: <input placeholder="name" type="text" name="name" /></p>
        <p>联系人电话: <input placeholder="phoneNumber" type="text" name="phoneNumber" /></p>
        <input type="submit" value="添加"/><input type="reset" value="重置"/>
    </fieldset>
</form>
</body>
</html>
