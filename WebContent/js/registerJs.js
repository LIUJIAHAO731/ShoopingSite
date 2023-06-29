let btn = document.querySelector("#btn");
let id = document.querySelector("#id");
let address = document.querySelector("#address");
let phone = document.querySelector("#phone");
let mail = document.querySelector("#mail");
let pass = document.querySelector("#pass");

btn.addEventListener("click", () => {
  if (id.value.trim() === "") {
    alert("会員番号を入力してください。");
    return;
  }

  if (address.value.trim() === "") {
    alert("住所を入力してください。");
    return;
  }
  
  if (pass.value.trim() === "") {
    alert("パスワードを入力してください。");
    return;
  }

  var phonePattern = /^\d{10,11}$/;
  if (!phonePattern.test(phone.value.trim())) {
    alert("電話番号の入力が不正です。");
    return;
  }

  var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailPattern.test(mail.value.trim())) {
    alert("メールアドレスの入力が不正です。");
    return;
  }

  document.querySelector("form").submit();
});
	

/**
 * 
 */