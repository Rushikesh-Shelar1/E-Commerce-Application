<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<center>
<h2>Kindly Give Your Personel Information</h2>
<body bgcolor='green'>
<form action="AdminReg" method="post">
<label for="adminId">Enter Admin Id</label>
<input type="text" name="id"><br>

<label for="adminName">Enter Admin Name</label>
<input type="text" name="name"><br>

<label for="adminAddress">Enter Admin Address</label>
<textarea rows-"10" cols="10" name="address"></textarea><br>

<label for="adminEmail">Enter Admin Email</label>
<input type="text" name="mail"><br>

<label for="adminId">Enter Admin Phone</label>
<input type="text" name="phone"><br>

<label for="adminDOB">Enter Admin Date of Birth</label>
<input type="date" name="dob"><br>
<input type="submit" value="signup">
</form>
</body>
</center>
</html>