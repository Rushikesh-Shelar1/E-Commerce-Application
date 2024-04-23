<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="skyblue">
<form action="saveProduct" method="post">
	<label for="pname">Enter Product Name</label>
	<input type="text" name="t1"><br>
	
	<label for="pcategory">Enter Product category</label>
	<select name="t2">
	<option value ="electronics">Electronics</option>
		<option value ="cloths">Cloths</option>
			<option value ="sports">Sports</option>
	</select><br>
	
	<label for="price">Enter Price</label>
	<input type="text" name="t3"><br>
	
		<label for="pbrand">Enter Product Brand/label>
	<select name="t4">
	<option value ="lg">LG</option>
		<option value ="sony">Sony</option>
			<option value ="samsung">Samsung</option>
			<option value ="peter-egland">PeterEngland</option>
			<option value ="max">Max</option>
	</select><br>
	
		<label for="date">Enter date</label>
	<input type="date" name="t5"><br>
	<input type="submit" value="ADD PRODUCT">
</form>

</body>
</html>