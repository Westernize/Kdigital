/**
 *  member.js
 *  ./   : 현재 디렉토리 기준
 *  ../  : 한 단계 위 디렉토리를 가리킴
 */

function loginCheck(){
	if(document.frm.userid.value.length == 0){
		alert('아이디를 입력해 주세요');
		return false;
	}
	
	if(document.frm.pwd.value == ""){
		alert("암호는 반드시 입력해야 합니다");
		return false;
	}
	
	return true;
}



function idCheck(){
	
	if(document.frm.userid.value==""){
		alert("아이디를 입력해 주세요");
		document.frm.userid.focus();
		return;
	}
	
	var url ="idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", 
		"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	
}



function joinCheck(){
	if(document.frm.name.value.length == 0){
		alert("이름을 써 주세요");
		frm.name.focus();
		return false;
	}	
	
	if(document.frm.userid.value.length == 0){
		alert('아이디를 써 주세요');
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.userid.value.length < 4){
		alert('아이디는 4글자 이상이어야 합니다.');
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.pwd.value == ""){
		alert('암호는 반드시 입력해야 합니다');
		frm.pwd.focus();
		return false;
	}
	
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert('암호가 일치하지 않습니다.');
		frm.pwd.focus();
		return false;
	}
	
	if(document.frm.rdid.value.length == 0){
		alert("중복 체크를 하지 않았습니다");
		frm.userid.focus();
		return false;
	}
	
	return true;
}

function idok() {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
	
	
}






