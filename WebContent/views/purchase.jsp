<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="jp.co.aforce.bean.Member"%>
<%@ page import="jp.co.aforce.dao.MemberDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認</title>
<style>
  

    body::before {
        content: "";
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-image: url("../img/pokemon_background05.jpg");
        background-repeat: repeat;
        background-size: contain;
        background-position: center top;
        opacity: 0.3; /* 背景画像の透明度を設定 */
        z-index: -1;
    }
    
  h1 {
    font-size: 24px;
    margin-bottom: 20px;
  }
  h2 {
    font-size: 20px;
    margin-top: 30px;
    margin-bottom: 10px;
  }
  table {
    border-collapse: collapse;
    width: 100%;
  }
  th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }
  th {
    background-color: #f2f2f2;
  }
  tfoot td {
    font-weight: bold;
  }
  p {
    margin: 5px 0;
  }
  form {
    margin-top: 20px;
  }
  .btn-purchase, .btn-continue-shopping {
    padding: 10px 20px;
    background-color: #4CAF50;
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin-right: 10px;
    cursor: pointer;
  }
  .btn-purchase:hover, .btn-continue-shopping:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>

  <h1>購入確認</h1>
  
  <h2>ご購入された商品</h2>
  <table>
  <tr>
  <th>商品名</th>
  <th>購入数</th>
  <th>価格</th>
  <th>小計</th>
  </tr>
  <%--カート内の商品を表示する --%>
  <c:forEach var="product" items="${sessionScope.cart}">
    <tr>
     <td>${product.productName }</td>
     <td>${product.quantity }</td>
     <td>${product.price}円</td>
     <td>${product.price * product.quantity}円</td>
     </tr>
     </c:forEach>
  </table>
  
  <tfoot>
            <tr>
                <td colspan="3">合計</td>
                <td>
                    <c:set var="totalPrice" value="0" />
                    <c:forEach var="product" items="${sessionScope.cart}">
                        <c:set var="subtotal" value="${product.price * product.quantity}" />
                        <c:set var="totalPrice" value="${totalPrice + subtotal}" />
                    </c:forEach>
                    ${totalPrice}円
                </td>
                <td></td>
            </tr>
        </tfoot>
  
<h2>お届け先</h2>
  <form action="purchaseServlet" method="post">
 <p>お名前: ${sessionScope.login.id }</p>
<p>
      <label for="address">住所：</label>
      <input type="text" id="address" name="address" required>
    </p>
    <p>
      <label for="phone">電話番号：</label>
      <input type="text" id="phone" name="phone" required>
    </p>
    
    
  <h2>支払方法</h2>
  <form action="purchaseServlet" method="post">
  <input type="radio" name="paymentMethod" value="cash" >届いてからの現金決済
  <br>
  <input type="radio" name="paymentMethod" value="credit" >クレジット決済
  
		<%-- 商品登録エラーメッセージの表示 --%>
		<%
		String errorMessage3 = (String) request.getAttribute("errorMessage3");
		if (errorMessage3 != null) {
		%>
		<p>
			<font color="red"><%=errorMessage3%></font>
		</p>
		<%
		}
		%>
  <br><br>
  <input type="submit" value="購入確定" onclick="return confirmPurchase();" class="btn-purchase">
  </form>
  
  <form action="product_list.jsp" method="get">
  <input type="submit" value="お買い物を続ける" class="btn-continue-shopping">
  </form>
  <script>
        function confirmPurchase() {
            return confirm("以上でよろしいでしょうか？");
        }
    </script>
    <footer>
</body>
</html>