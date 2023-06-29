<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="jp.co.aforce.bean.Product"%>
<%@ page import="jp.co.aforce.dao.ProductDAO"%>
<%@ page import="java.util.Comparator" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品一覧</title>
    <style>
         body::before {
        content: "";
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-image: url("../img/pokemon_background.jpg");
        background-repeat: repeat;
        background-size: contain;
        background-position: center top;
        opacity: 0.1; /* 背景画像の透明度を設定 */
        z-index: -1;
    }
    
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: white;
        }
        .sort-form {
            text-align: center;
            margin-bottom: 20px;
        }
        .sort-form label {
            font-weight: bold;
            color: white;
        }
        .sort-form select {
            margin-left: 10px;
        }
        .product-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin-bottom: 20px;
        }
        .product {
            width: calc(33.33% - 20px);
            margin-bottom: 40px;
            background-color: transparent;
            padding: 20px;
            text-align: center;
            box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.1);
            color: black;
        }
        .product img {
            max-width: 100%;
            max-height: 400px;
            margin-bottom: 10px;
        }
        .product-name {
            font-weight: bold;
            margin-bottom: 5px;
            font-size: 20px;
        }
        .product-price {
            margin-bottom: 5px;
        }
        .product-stock {
            margin-bottom: 10px;
        }
        .add-to-cart-form {
            margin-top: 10px;
        }
        .add-to-cart-form input[type="number"] {
            width: 60px;
            text-align: center;
        }
        .add-to-cart-form input[type="submit"] {
            margin-left: 10px;
        }
        p {
            color: black;
        }
        
        /* セレクトボックスのスタイル */
    select {
        padding: 8px 16px; /* パディングの調整 */
        font-size: 16px; /* フォントサイズの調整 */
        border: 1px solid #ccc; /* ボーダーのスタイル */
        border-radius: 4px; /* 角丸の設定 */
        background-color: #fff; /* 背景色 */
        color: #333; /* テキストカラー */
    }

    /* ボタンのスタイル */
    input[type="submit"] {
        padding: 8px 16px; /* パディングの調整 */
        font-size: 16px; /* フォントサイズの調整 */
        border: none; /* ボーダーの設定 */
        border-radius: 4px; /* 角丸の設定 */
        background-color: #0088cc; /* 背景色 */
        color: #fff; /* テキストカラー */
        cursor: pointer; /* カーソルをポインターに変更 */
    }
    </style>
    <jsp:include page="header.jsp" />
</head>
<body>
    <div class="container">
        <h1>商品一覧</h1>

        <form class="sort-form" action="" method="get">
            <label for="sort">並び替え:</label>
            <select name="sort" id="sort">
                <option value="">選択してください</option>
                <option value="priceAsc">価格の安い順</option>
                <option value="priceDesc">価格の高い順</option>
                <option value="nameAsc">商品名の昇順</option>
                <option value="nameDesc">商品名の降順</option>
            </select>
            <input type="submit" value="表示">
        </form>

        <div class="product-list">
            <% 
            List<Product> productList = new ProductDAO().getAllProducts();
            String sort = request.getParameter("sort");

            if (sort != null) {
                if (sort.equals("priceAsc")) {
                    productList.sort(Comparator.comparing(Product::getPrice));
                } else if (sort.equals("priceDesc")) {
                    productList.sort(Comparator.comparing(Product::getPrice).reversed());
                } else if (sort.equals("nameAsc")) {
                    productList.sort(Comparator.comparing(Product::getProductName));
                } else if (sort.equals("nameDesc")) {
                    productList.sort(Comparator.comparing(Product::getProductName).reversed());
                }
            }

            for (Product product : productList) {
            %>
                <div class="product">
                    <img src="../img/<%= product.getProductNo() %>.jpg" alt="商品画像">
                    <div class="product-name""><%= product.getProductName() %></div>
                    <div class="product-price">\ <%= product.getPrice() %></div>
                    <div class="product-stock">在庫<%= product.getStock() %></div>
                    <div class="add-to-cart-form">
                        <form action="../add-to-cart-servlet" method="post"> 
                            <input type="hidden" name="productNo" value="<%= product.getProductNo() %>">
                            <input type="hidden" name="productName" value="<%= product.getProductName() %>">
                            <input type="hidden" name="stock" value="<%= product.getStock() %>">
                            <input type="hidden" name="price" value="<%= product.getPrice() %>">
                            <label for="quantity">数量:</label>
                            <input type="number" name="quantity" id="quantity" min="1" max="<%= product.getStock() %>" value="1">
                            <input type="submit" value="カートに追加">
                        </form>
                    </div>
                </div>
            <% } %>
        </div>

        <p>表示する価格は全て税込価格です</p>
        <jsp:include page="footer.jsp" />
    </div>
</body>
</html>