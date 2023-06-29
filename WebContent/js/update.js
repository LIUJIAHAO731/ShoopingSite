let idInput = document.querySelector("#id");
let formBtn = document.querySelector("#formBtn");

formBtn.addEventListener("click", () => {
	if(!isFinite(idInput.value) || idInput.value.trim() === "") {
		alert("数値を入力してください。");
	} else {
		document.selectForm.submit();
	}
	
})/**
 * 
 */