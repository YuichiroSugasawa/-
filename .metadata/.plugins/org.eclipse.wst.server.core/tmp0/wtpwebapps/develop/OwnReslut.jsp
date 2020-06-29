<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/base_style.css">
<link rel="stylesheet" href="css/reslut.css">
<title>Insert title here</title>
</head>
<body>
	<!-- 拡張for文を使ってDaoあるitemメソッドのデータを一つづつ取り出し表示する -->
	<c:forEach var="item" items="${ownBookList }">
	<div class="result"><br>${item.title }<br>${item.writer }<br>${item.company}<br></div>
	<form action ="delete" method = "GET">
		<input type="submit" name="submit" value="削除"><br>
		<input type="hidden" name="id" value="${item.id }">
	</form>
	</c:forEach>
	</table>
	<form>
		<div><a href="main.jsp">メインページへ戻る</a></div>
		<div><a href ="ownBooks.jsp">蔵書検索へ</a></div>
	</form>
	
	
</body>
</html>