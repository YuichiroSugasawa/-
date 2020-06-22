<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>蔵書検索</title>
</head>
<body>
	<header>蔵書検索
		<form>
			<br><a href="main.jsp">メインページへ</a>
			<br><a href="purchasePlans.jsp">購入予定図書</a>
			<br><a href="inputBooks.jsp">蔵書登録</a>
		</form>
	</header>
	<form action="Own"method="get" >
		<p>本の名前:<input type="text" name="bookTitleSearch"></p>
		<p>本の著者：<input type="text" name="bookWriterSearch"></p>
		<p>出版社：   <input type="text" name="bookCompanySearch"></p>
		<input type="submit" name="submit" value="検索">
	</form>

</body>
</html>