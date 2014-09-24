function muda(){	
	muda2('url', 'red');
	muda2('param', 'red');
	document.getElementById('botao').disabled = true;
}


function muda2(id, cor){	
	document.getElementById(id).style.borderColor = cor;
	document.getElementById(id).style.borderWidth = '2px';
	document.getElementById(id).style.outline = 'none';	
}

function botao(){
	if(validaUrl() && validaParam()){
		document.getElementById('botao').disabled = false;
	}else{
		document.getElementById('botao').disabled = true;
	}
}



function validaUrl(){
	var _url = document.getElementById("url").value;
		
	if(_url.length==0){		
		muda2('url', 'red');
		return false;		
	} 	
		
	if(!_url.match(/^(http[s]?:\/\/|ftp:\/\/)(www\.)?[a-zA-Z0-9-\.]/)){
		muda2('url', 'red');
		return false;		
	}else{
		muda2('url', 'blue');
		return true;
	}
}

function validaParam(){
	var _param = document.getElementById("param").value;
		
	if(_param.length==0){
		muda2('param', 'red');
		return false;		
	} else{
		muda2('param', 'blue');		
	}	
	return true;
}


