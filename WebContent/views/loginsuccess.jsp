<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>ログイン成功画面</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
    }

    .container {
      max-width: 500px;
      margin: 0 auto;
      padding: 20px;
      background-color: #ffffff;
      border: 1px solid #dddddd;
      border-radius: 4px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    h2 {
      font-size: 24px;
      color: #333333;
      margin-top: 0;
    }

    p {
      font-size: 16px;
      color: #666666;
      margin-bottom: 20px;
    }

    .btn {
      display: inline-block;
      padding: 10px 20px;
      font-size: 16px;
      font-weight: bold;
      text-align: center;
      text-decoration: none;
      background-color: #337ab7;
      color: #ffffff;
      border-radius: 4px;
      transition: background-color 0.3s ease;
    }

    .btn:hover {
      background-color: #23527c;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>ログイン成功</h2>
    <p>ログインに成功しました。</p>
    <p>
      <input type="button" value="ログアウト" onclick="location.href='/ShoppingSite/logout'" class="btn">
      <input type="button" value="TOPへ" onclick="location.href='/ShoppingSite/index.jsp'" class="btn">
    </p>
  </div>
</body>
</html>