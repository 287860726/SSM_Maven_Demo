<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试页面</title>
</head>
<body>
	<table align="center" width="500px" border="1px">
		<thead align="center">
			<td>书名</td>
			<td>作者</td>
			<td>价格</td>
		</thead>
		<c:forEach var="book" items="${books}">
			<tr align="center">
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>