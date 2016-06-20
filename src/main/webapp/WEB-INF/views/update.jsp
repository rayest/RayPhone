<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/19 0019
  Time: 下午 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/updated" method="post">
    <fieldset>
        <legend>编辑联系人</legend>
        <p>标识：<input placeholder="id" type="text" name="id"/></p>
        <p>姓名: <input placeholder="name" type="text" name="name" /></p>
        <p>电话: <input placeholder="phoneNumber" type="text" name="phoneNumber" /></p>
        <input type="submit" value="编辑"/>
        <input type="reset" value="重置"/>
    </fieldset>
</form>

</body>
</html>
