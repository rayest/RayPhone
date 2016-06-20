<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/20 0020
  Time: 下午 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/found" method="post">
    <fieldset>
        <legend>查找用户</legend>
        <p>
            <label for="name">
                用户姓名: <input placeholder="name" type="text" id="name" name="name" />
            </label>
        </p>
        <input type="submit" value="查找"/>
        <input type="reset" value="重置"/>
    </fieldset>
</form>
</body>
</html>
