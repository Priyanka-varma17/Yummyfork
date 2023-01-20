var uname=document.form['form']['uname'];
var pwd=document.form['form']['pwd'];

var uname_err=document.getElementById('uname_err');
var pwd_err=document.getElementById('pwd_err');

function validate(){
	if(uname.value.length<5){
		uname.style.border="1px solid red";
		uname_err.style.display="block";
		uname.focus();
		return false;
	}
	
		if(pwd.value.length<9){
		pwd.style.border="1px solid red";
		pwd_err.style.display="block";
		pwd.focus();
		return false;
	}
}