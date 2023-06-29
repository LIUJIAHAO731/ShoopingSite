<!-- footer.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Magic - ポケカ専門店</title>
    <style>
        /* Footer Styles */
        footer ::before {
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
    }

        .footer-center {
            margin-top: 10px;
            text-align: center;
        }

        .footer-logo {
            font-size: 18px;
            font-weight: bold;
            color: #333;
        }

        .admin-login-link {
            color: #333;
            text-decoration: none;
            border-bottom: 1px dotted #333;
        }

        .admin-login-link:hover {
            border-bottom: none;
        }

        .footer-image {
            width: 60px;
            height: auto;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <footer>
        <div class="footer-center">
            <p class="footer-logo">&copy; 2023, Magic</p>
            <p><a class="admin-login-link" href="/ShoppingSite/views/login-admin.jsp">管理者ログイン</a></p>
            <img class="footer-image" src="../img/pokemon_logo.png" alt="Pokemon Logo">
        </div>
    </footer>
</body>
</html>