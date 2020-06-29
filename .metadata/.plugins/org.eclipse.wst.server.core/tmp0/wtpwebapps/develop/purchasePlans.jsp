<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/base_style.css">
<link rel="stylesheet" href="css/purchasePlan.css">
<title>欲しい本</title>
</head>
<body>
	<header><h0>購入予定図書</h0>
		<form>
			<br><a href="main.jsp">メインページへ</a>
			<br><a href="ownBooks.jsp">所有図書の検索</a>
			<br><a href="inputBooks.jsp">蔵書登録</a>
		</form>
	</header>
	</div>
	<h2>購入予定図書の登録</h2>
	<!-- PurchasePlan.javaのdoPOSTファイルにフロント側で受け取った情報と処理を任せる -->
	<form action="PurchasePlan"method="POST">
		<p class=input>本の名前:<input type="text" name="bookTitlePlan"></p>
		<p class=input>本の著者：<input type="text" name="bookWriterPlan"></p>
		<p class=input>出版社   ： <input type="text" name="bookCompanyPlan"></p>
		<input type="submit" name="submit" value="登録">
	</form>

</body>
</html>