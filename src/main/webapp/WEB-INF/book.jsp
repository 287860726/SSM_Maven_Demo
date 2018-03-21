<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="<%=basePath %>/js/jquery.js"></script>
<title>测试页面</title>
</head>
<script type="text/javascript">
// 		$("#xiu").click(function(){
//			 		$.ajax(
//			 		{
			<%-- 			url:'<%=basePath%>/BookController/delOneBook.do', --%>
//			 			type:'post',
//			 			async:true,
//			 			data:{
//			 				id:$('#xiu').attr('value')
//			 			},
//			 			success:function(data){
//			 				alert('删除成功');
//			 			},
//			 			error:function(data){
//			 				alert('删除失败');
//			 			}
//			 		});
// 				});

// 		$("#del").click(function()
// 		{
// 			alert("--------------")
// 			$.ajax({
<%-- 				url:'<%=basePath%>/BookController/delOneBook.do', --%>
// 				console.info(url)
// 				type:'post',
// 				async:true,
// 				data:{
// 					id:$('#xiu').attr('value')
// 				},
// 				success:function(data){
// 					alert('删除成功');
// 				},
// 				error:function(data){
// 					alert('删除失败');
// 				}
// 			});
// 		});
		
		function deleteBook(varid){
			$.ajax({
				url:'<%=basePath%>/BookController/delOneBook.do',
				type:'post',
				async:true,
				data:{
					'id':varid
				},
				success:function(data){
					alert('删除成功');
				},
				error:function(data){
					alert('删除失败');
				}
			});
		}
</script>
<body>
	<table align="center" width="500px" border="1px">
		<thead align="center">
			<td>编号</td>
			<td>书名</td>
			<td>作者</td>
			<td>价格</td>
			<td>操作</td>
		</thead>
		<c:forEach var="book" items="${books}">
			<tr align="center">
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>
					<button id="xiu${book.id}" value="${book.id}">修改</button>
					<button id="del${book.id}" value="${book.id}" onclick="deleteBook('${book.id}')">删除</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>