<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了</title>
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 20px;
    
  }
  h1 {
    font-size: 24px;
    margin-bottom: 20px;
  }
  p {
    margin: 5px 0;
  }
  .btn {
    padding: 10px 20px;
    background-color: #4CAF50;
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    cursor: pointer;
  }
  .btn:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>
<h1>購入が完了しました。</h1>
<p>ご購入いただき、ありがとうございました。</p>
<p><input type="button" value="TOPへ" onclick="location.href='/ShoppingSite/index.jsp'" class="btn"></p>
</body>
</html>