<%@page import="doa.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
     <%@page import="model.*,doa.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2" cellpadding="2" cellingspacing="2">
<thread>
<th>ID</th>
<th>NAME</th>
<th>CATEGORY</th>
<th>PRICE</th>
<th>BRAND</th>
<th>MFD</th>
<th>EDIT</th>
<th>DELETE</th>
</thread>
<% ProductDao dao =new ProductDao();
List<Product> list =dao.getAllProduct();
for(Product p:list){
%>
<tr>
<td><%=p.getProductId() %></td>
<td><%=p.getProductName() %></td>
<td><%=p.getProductCategory() %></td>
<td><%=p.getProductPrice() %></td>
<td><%=p.getProductBrand() %></td>
<td><%=p.getProductMfd() %></td>
<td><a href='EditProduct?p1=<%=p.getProductId()%>'>EDIT</a></td>
<td><a href='DeleteProduct?p1=<%=p.getProductId()%>'>DELETE</a></td>
<%} %>

</table>
</body>
</html>