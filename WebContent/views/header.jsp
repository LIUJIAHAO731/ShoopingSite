<!-- header.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<title>Magic - ポケカ専門店</title>
	<style>
		/* ヘッダーの共通スタイル */
		
		/* 新しいスタイルルール */

    .header::before {
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

		.header-logo {
			font-size: 24px;
			font-weight: bold;
			color: #000;
			margin: 0;
			text-shadow: 2px 2px 4px #ffd700;
		}

		.header-nav {
			margin-top: 20px;
		}

		.header-list {
			list-style: none;
			padding: 0;
			margin: 0;
			text-align: center;
		}

		.header-item {
			display: inline-block;
			margin-right: 10px;
			
			
		}

		.header-item a {
			text-decoration: none;
			color: #000;
			padding: 5px;
			border-radius: 20px;
			background-color: #ffd700;
			
		}

		.header-item a:hover {
			background-color: #f3c500;
			color: #fff;
		}
		
		
	</style>
</head>

<body>
	<header class="header">
		<h1 class="header-logo">Magic - ポケカ専門店</h1>
		<nav class="header-nav">
			<ul class="header-list">
				<li class="header-item"><a href="../index.jsp">ホーム</a></li>
				<li class="header-item"><a href="product_list.jsp">ショップ</a></li>
				<li class="header-item"><a href="cart.jsp">買い物かご</a></li>
				<li class="header-item"><a href="register1.jsp">会員情報登録</a></li>
				<li class="header-item"><a href="update.jsp">会員情報更新</a></li>
				<li class="header-item header-item--login"><a href="login.jsp">ログイン</a></li>
			</ul>
		</nav>
	</header>
</body>

</html>
