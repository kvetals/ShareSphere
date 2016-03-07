function shareButtonMenuActivator(element){
	var i;
	var formContainer = element.getElementsByClassName('share-button-menu active');
	console.log(formContainer[0]);
	if (formContainer[0] === undefined){
		console.log("entered IF");
		formContainer = element.getElementsByClassName('share-button-menu');
		console.log("IF formContainer length = " + formContainer.length)
		for(i = 0; i < formContainer.length; i++){
			formContainer[i].className = 'share-button-menu active';
		}
		
	} else{
		console.log("ELSE formContainer length = " + formContainer.length);
		for(i = formContainer.length - 1; i >= 0 ; i--){
			formContainer[i].className = 'share-button-menu';
			console.log("+1 with i = " + i);
		}
		console.log(i);
		console.log(formContainer.length);
		
	}
}