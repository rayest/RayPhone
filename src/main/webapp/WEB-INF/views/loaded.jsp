<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/19 0019
  Time: 下午 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        th {
            text-align: left;
        }
    </style>
</head>
<body>
<fieldset>
    <legend>联系人信息</legend>
    <table>
        <thead>
        <tr>
            <th>标识</th>
            <th>姓名</th>
            <th>电话</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${person}" var="person">
            <tr>

                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.phoneNumber}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</fieldset>
</body>
</html>
