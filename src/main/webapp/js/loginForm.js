(function(){
	var totalCount = 7;
	var style = document.getElementsByTagName('body')[0].style;
	var num = Math.ceil( Math.random() * totalCount ); 
	style.background = "fixed url('img/backgrounds/bg"+num+".jpg') no-repeat top center";
	style.backgroundSize = "cover";
})();
function changeForm(){
	var formContainer = document.getElementsByClassName('b-login-form active');
	console.log(formContainer[0]);
	if (formContainer[0] === undefined){
		console.log("entered IF");
		formContainer = document.getElementsByClassName('b-register-form active');
		formContainer[0].className = 'b-register-form';
		formContainer = document.getElementsByClassName('b-login-form');
		formContainer[0].className = 'b-login-form active';
	} else{
		formContainer[0].className = 'b-login-form';
		formContainer = document.getElementsByClassName('b-register-form');
		formContainer[0].className = 'b-register-form active';
	}
}