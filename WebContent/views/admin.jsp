<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.co.aforce.bean.Product"%>
<%@ page import="jp.co.aforce.dao.ProductDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者サイト</title>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
}

h1 {
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: #f5f5f5;
}

form {
	margin-top: 20px;
}

label {
	display: inline-block;
	width: 100px;
}

input[type="text"], input[type="number"] {
	width: 200px;
	padding: 5px;
	margin-bottom: 10px;
}

input[type="submit"] {
	padding: 8px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}

p {
	margin-top: 10px;
}

.success {
	color: green;
}

.error {
	color: red;
}
</style>

<script>
	function confirmRegistration() {
		var confirmed = confirm("商品を登録しますか？");
		if (confirmed) {
			return true; // フォームを送信
		} else {
			return false; // フォーム送信をキャンセル
		}
	}
</script>
</head>
<body>
	<h1>商品一覧</h1>

	<table>
		<thead>
			<tr>
				<th>商品番号</th>
				<th>商品名</th>
				<th>在庫数</th>
				<th>価格</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Product> productList = new ProductDAO().getAllProducts();
			for (Product product : productList) {
			%>
			<tr>
				<td><%=product.getProductNo()%></td>
				<td><%=product.getProductName()%></td>
				<td><%=product.getStock()%></td>
				<td><%=product.getPrice()%>円</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<h2>新商品登録</h2>
	<form action="addservlet" method="post"
		onsubmit="return confirmRegistration()">
		<label for="productNo">商品番号:</label> <input type="text" id="productNo"
			name="productNo" required><br> <label for="productName">商品名:</label>
		<input type="text" id="productName" name="productName" required><br>
		<label for="stock">在庫数:</label> <input type="number" id="stock"
			name="stock" required><br> <label for="price">価格:</label>
		<input type="number" id="price" name="price" required><br>
		<input type="submit" value="登録">
		
		
		<%-- 商品登録成功メッセージの表示 --%>
		<%
		String successMessage = (String) request.getAttribute("successMessage");
		if (successMessage != null) {
		%>
		<p>
			<font color="green"><%=successMessage%></font>
		</p>
		<%
		}
		%>
		<%-- 商品登録エラーメッセージの表示 --%>
		<%
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (errorMessage != null) {
		%>
		<p>
			<font color="red"><%=errorMessage%></font>
		</p>
		<%
		}
		%>
	</form>

	<h3>商品内容更新</h3>
	<form action="../updateProductServlet" method="post"
		onsubmit="return confirmRegistration()">
		<label for="updateProductNo">商品番号:</label> <input type="text"
			id="updateProductNo" name="productNo"><br> <label
			for="updateProductName">商品名:</label> <input type="text"
			id="updateProductName" name="productName"><br> <label
			for="updateStock">在庫数:</label> <input type="number" id="updateStock"
			name="stock"><br> <label for="updatePrice">価格:</label> <input
			type="number" id="updatePrice" name="price"><br> <input
			type="submit" value="更新">
		
		<%-- 商品登録成功メッセージの表示 --%>
		<%
		String successMessage1 = (String) request.getAttribute("successMessage1");
		if (successMessage1 != null) {
		%>
		<p>
			<font color="green"><%=successMessage1%></font>
		</p>
		<%
		}
		%>
		<%-- 商品登録エラーメッセージの表示 --%>
		<%
		String errorMessage1 = (String) request.getAttribute("errorMessage1");
		if (errorMessage1 != null) {
		%>
		<p>
			<font color="red"><%=errorMessage1%></font>
		</p>
		<%
		}
		%>
	
</body>
</html>