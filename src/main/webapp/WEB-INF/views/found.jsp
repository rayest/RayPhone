<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/20 0020
  Time: 下午 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>查找联系人</legend>
    <table>
        <thead>
        <tr>
            <td>标识</td>
            <td>姓名</td>
            <td>电话</td>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.phoneNumber}</td>
        </tr>
        </tbody>
        <tr>

        </tr>
    </table>
</fieldset>
</body>
</html>
