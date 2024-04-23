<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%User user=(User)session.getAttribute("loginInfo"); %>
<h3><font color='blue'>Hello<%=user.getUserName()%>!!!</font></h3>
<h3><font color='red'>you logged in as<%=user.getUserType()%></font> </h3>
<a href="addProduct">ADD PRODUCT</a><br>
<a href="ViewProduct">VIEW ALL PRODUCT</a><br>
<a href="viewById">VIEW BY PRODUCT ID</a><br>
</body>
</html>