<!-- index.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Magic - ポケカ専門店</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
*{
  margin:0;
  padding:0;
}

.container{  padding-top: 20px;
  padding-bottom: 20px;}
body{
  background-color: #111845;
  background-image: url("img/pokemon_background04.jpg");
  
}

section{
background-image: url("img/pokemon_background04.jpg");
}


.background-img{
  background-image: url("img/pokemon_background04.jpg");
  height: 400px;
  width: 800px;
  background-repeat: no-repeat;
  background-size: cover;
  margin: 5% auto;
  padding: 20px;
  border: 1px solid #2a3cad;
  border-radius: 4px;
  box-shadow: 0px 0px 5px #2a3cad;
  position: relative;
}

.content h2{ font-size:19px;
text-align: center;
}


.box{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 300px;
  height: 300px;
  background: #111845a6;
  box-sizing: border-box;
  overflow: hidden;
  box-shadow: 0 20px 50px rgb(23, 32, 90);
  border: 2px solid #2a3cad;
  color: white;
  padding: 20px;
  text-decoration: none;
}

.box a {
  color: white; /* ボックス内のリンクテキストの色を白に指定 */
  text-decoration: none; /* ボックス内のリンクに下線を削除 */
}

.box:before{
  content: '';
  position:absolute;
  top:0;
  left:-100%;
  width:100%;
  height:100%;
  background: rgba(255,255,255,0.1);
  transition:0.5s;
  pointer-events: none;
}

.box:hover:before{
  left:-50%;
  transform: skewX(-5deg);
}


.box .content{
  position:absolute;
  top:15px;
  left:15px;
  right:15px;
  bottom:15px;
  border:1px solid #f0a591;
  padding:20px;
  text-align:center;
  box-shadow: 0 5px 10px rgba(9,0,0,0.5);
  
}

.box span{
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: block;
  box-sizing: border-box;
  
}

.box span:nth-child(1)
{
  transform:rotate(0deg);
}

.box span:nth-child(2)
{
  transform:rotate(90deg);
}

.box span:nth-child(3)
{
  transform:rotate(180deg);
}

.box span:nth-child(4)
{
  transform:rotate(270deg);
}

.box span:before
{
  content: '';
  position: absolute;
  width:100%;
  height: 2px;
  background: #50dfdb;
  animation: animate 4s linear infinite;
}

@keyframes animate {
  0% {
  transform:scaleX(0);
  transform-origin: left;
  }
  50%
  {
    transform:scaleX(1);
  transform-origin: left;
  }
  50.1%
  {
    transform:scaleX(1);
  transform-origin: right;
    
  }
  
  100%
  {
    transform:scaleX(0);
  transform-origin: right;
    
  } 
  
  .slider-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.slider {
  list-style: none;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0;
  padding: 0;
}

.slider li {
  margin-right: 10px;
}
  


</style>
<link rel="stylesheet" type="text/css" href="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/reset.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
<link rel="stylesheet" type="text/css" href="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/6-1-7/css/6-1-7.css">
<script src="../js/script.js"></script>

<jsp:include page="header.jsp" />

</head>

<body>

<main>
<section id="area-1">
	<div class="body-content">

<h1 style="text-align: center;">本日のおすすめ商品！</h1>
<div class="slider-container">
		<ul class="slider">
			<li><img src="img/A001.jpg" alt="" class="banner-img" style="width: 50%; height:auto; align: center;"></li>
			<li><img src="img/A002.jpg" alt="" class="banner-img" style="width: 50%; height:auto; align: center;"></li>
			<li><img src="img/A003.jpg" alt="" class="banner-img" style="width: 50%; height:auto; align: center;"></li>
			<li><img src="img/A004.jpg" alt="" class="banner-img" style="width: 120%; height:auto; align: center;"></li>
			<!--/slider-->
		</ul>
</div>
	</div>
	</section>
	
	
<section id="area-2">
  <div class="container">
    <div class="background-img">
      <div class="box">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <div class="content">
          <h2>ポケモンカニュース </h2>
          <p><a>新着商品情報.</a></p>
          <p><a>お得なクーポン情報.</a></p>
        </div>
      </div>
    </div>
  </div>
</section>
</main>
<jsp:include page="footer.jsp" />

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/6-1-7/js/6-1-7.js"></script>
</body>
</html>
