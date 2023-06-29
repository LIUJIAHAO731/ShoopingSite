<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>買い物かご</title>
    <jsp:include page="header2.jsp" />
</head>
<body>
    <div class="background-img">
        <div class="cart-container">
            <h1 class="cart-title">買い物かご</h1>

            <table class="cart-table">
    <thead>
        <tr>
            <th>商品画像</th>
            <th>商品名</th>
            <th>価格</th>
            <th>数量</th>
            <th>小計</th>
            <th>操作</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach var="product" items="${sessionScope.cart}">
            <tr>
                <td><img src="../img/${product.productNo}.jpg" alt="商品画像" style="width: 100px; height: 100px;"></td>
                <td>${product.productName}</td>
                <td>${product.price}円(税込)</td>
                <td>${product.quantity}個</td>
                <td>${product.price * product.quantity}円(税込)</td>
                <td>
                    <form action="../removeFromCartServlet" method="post" onsubmit="return confirmDelete();">
                        <input type="hidden" name="productName" value="${product.productName}">
                        <input type="submit" value="削除" class="btn-delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
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
</table>

            <form action="../clear-cart-servlet" method="post"  onsubmit="return confirmClearCart();">
                <input type="submit" value="カートを空にする" class="btn-clear">
            </form>
            <form action="purchaseServlet" method="post">
                <input type="submit" value="購入する" onclick="return confirmPurchase();" class="btn-purchase">
            </form>
            <%-- カートが空の場合に表示するメッセージ --%>
            <c:if test="${empty sessionScope.cart}">
                <p style="font-size: 30px; color: #F00;">カートは空です</p>
            </c:if>
        </div>
    </div>

<style>
   /* 全体のスタイル */
        body {
            margin: 0;
            padding: 0;
        }

        /* 背景イメージ */
        .background-img ::before {
        content: "";
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-image: url("../img/pokemon_background02.jpg");
        background-repeat: repeat;
        background-size: contain;
        background-position: center top;
        opacity: 0.1; /* 背景画像の透明度を設定 */
        z-index: -1;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        /* カートコンテナ */
        .cart-container {
            background-color: ;
            padding: 20px;
        }

        /* カートタイトル */
        .cart-title {
            font-size: 32px;
            text-align: center;
            margin-top: 0;
            color: #E74C3C;
        }

        /* カートテーブル */
        .cart-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .cart-table th,
        .cart-table td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ccc;
        }

        .cart-table th {
            background-color: ;
        }

        /* ボタン */
        .btn-delete,
        .btn-clear,
        .btn-purchase {
            display: inline-block;
            padding: 8px 16px;
            background-color: #E74C3C;
            color: #fff;
            border: none;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-clear {
            background-color: #FFA500;
            margin-top: 20px;
        }

        .btn-purchase {
            background-color: #4CAF50;
        }

        .btn-delete:hover,
        .btn-clear:hover,
        .btn-purchase:hover {
            background-color: #C0392B;
        }
    </style>

    <script>
        function confirmPurchase() {
            return confirm("購入確認画面へ進みますが、よろしいでしょうか？");
        }

        function confirmDelete() {
            return confirm("この商品をカートから削除しますか？");
        }

        function confirmClearCart() {
            return confirm("カート内の商品を全て削除しますか？");
        }
    </script>

   <jsp:include page="footer2.jsp" />
</body>
</html>