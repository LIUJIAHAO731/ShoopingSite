<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>会員情報登録成功</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }
    
    .container {
      max-width: 600px;
      margin: 0 auto;
      padding: 40px;
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    
    h2 {
      color: #333;
      font-size: 24px;
      margin-bottom: 20px;
    }
    
    p {
      color: #555;
      font-size: 16px;
      margin-bottom: 20px;
    }
    
    input[type="submit"] {
      padding: 10px 20px;
      background-color: #337ab7;
      color: #fff;
      border: none;
      border-radius: 4px;
      font-size: 16px;
      cursor: pointer;
    }
    
    input[type="submit"]:hover {
      background-color: #286090;
    }
    
    .button-container {
      margin-top: 30px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>会員情報登録成功</h2>
    <p>登録に成功しました。</p>

    <div class="button-container">
      <input type="submit" value="ログイン画面へ" onclick="location.href='/ShoppingSite/views/login.jsp'">
      <br><br>
      <input type="submit" value="TOPへ" onclick="location.href='/ShoppingSite/index.jsp'">
    </div>
  </div>
</body>
</html>
