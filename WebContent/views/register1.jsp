<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録</title>
</head>
<style>
	 {
  font-family: 'Maven Pro', sans-serif;
  box-sizing: border-box;
}

body,html {
  height: 100%;
  width: 100%;
  margin: 0;
  padding: 0;
  background-image: linear-gradient(180deg, #37375A 70%, #31315A);
  text-align: center;
  font-family: 'Segoe UI';
}

form {
  width: 40%;
  margin-left: 30%;
  padding-top: 10%;
}

input {
  width: 100%;
  background: transparent;
  border-bottom: solid 1px #7053c4;
  border-top: none;
  border-left: none;
  border-right: none;
  font-size: 1rem;
  padding: 0.5em 0.4em;
  transition: all 0.4s;
  color: #BDBDBD;;
  margin: 0.7rem 0;
}
input:focus {
  background: #7035c4;
  transform: scale3d(1.06,1.06,1.06);
}

button {
  background: transparent;
  width: 50%;
  margin-top: 2.5rem;
  font-size: 1rem;
  border: solid 1px #7053c4;
  padding: 1em 0;
  color: #bdc3c7;
  transition: all 0.6s;
}
button:hover {
  cursor:pointer;
  background: #7035c4;
}

h1 {
  color: #bdc3c7;
  border-bottom: solid 1px #7035c4;
  padding: 0 0 0.8em 0;
  width: 50%;
  margin-left: 25%;
  margin-bottom: 1em;
}
@media (max-width: 550px) {
  form {
  width: 90%;
  margin-left: 3%;
  padding-top: 5%;
}
  input {
    font-size: 1em;
  }
}

a {
  text-decoration: none;
}
a:hover {
  text-decoration: underline;
}
a{
color:white;
}
</style>
<body>
	<h1>会員情報登録</h1>
	<form action="../registerServlet" name="myform" method="POST">
		
					<input type="text" name="id" id="id" placeholder="会員番号">
			
					<input type="text" name="address" id="address" placeholder="住所">
			
					<input type="text" name="phone" id="phone" placeholder="電話番号">
			
			
					<input type="text" name="mail" id="mail" placeholder="メールアドレス">
			
				
					<input type="password" name="pass" id="pass" placeholder="パスワード">
			
		<input type="button" id="btn" value="登録">
	</form>
	<div>
		<button onclick="document.myform.reset()">リセット</button>
		<button><a href="../index.jsp">ホーム画面へ戻る</a></button>
	</div>
	<script src="/ShoppingSite/js/registerJs.js"></script>
</body>
</html>