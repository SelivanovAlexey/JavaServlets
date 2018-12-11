<%--
  Created by IntelliJ IDEA.
  User: Alexey Selivanov
  Date: 10.12.2018
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Get Information</title>
    <link rel="stylesheet" href="styles/infoStyle.css">
</head>
<body>
<form action="getInfo" method="GET" style="text-align: center; height: 100%; top: 25%">
    <input type="submit" value="Get Information"/>

    <p>Local time : ${time}</p>
    <p>Your browser: ${userAgent}</p>
</form>
</body>
</html>
