<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/20 0020
  Time: 下午 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/deleted" method="post">
    <fieldset>
        <legend>删除用户</legend>
        <p>用户标识: <input placeholder="id" type="text" name="id" /></p>
        <input type="submit" value="删除"/>
        <input type="reset" value="重置"/>
    </fieldset>
</form>
</body>
</html>
