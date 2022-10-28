/**
 * console.log 입력 소스탭 
 */

// id를 입력 후, 중복체크 버튼을 눌렀을 때 동작 할 함수
function checkId(){
	if(!document.frm.userid.value){
		alert('아이디를 입력하여 주세요.');	// 경고창 띄우기
		return;							// 함수 종료
	}
	if(document.frm.userid.value.length < 5){
		alert('아이디를 5자 이상 입력해야 합니다.');	// 경고창 띄우기
		return;							// 함수 종료
	}
	var url = "checkId.do?userid=" + document.frm.userid.value; 
	window.open(url, "_black_1", "menubar=no, resizable=no, width=450, height=200");
}

// idCheck.jsp 에서 사용 버튼 클릭 시, 동작할 함수
function idOk(){
	// 중복체크 창에 입력된 아이디 값을 회원가입 창에 입력
	opener.frm.userid.value = document.frm2.userid.value;	
	opener.frm.checkid.value = document.frm2.userid.value;
	self.close();		// 생성된 창 닫기
}

function checkLogin(){
	if(!document.frm.userId.value){
		alert('아이디를 입력해주세요.')
		frm.userId.focus();
		return false;
	}
	if(!document.frm.userPwd.value){
		alert('패스워드를 입력해주세요.')
		frm.userPwd.focus();
		return false;
	}
	return true;
}
// 입력된 양식에 정상 데이터가 포함되었는지 확인
function checkJoin(){
	if(!document.frm.name.value){
		alert('이름을 입력해주세요.')
		frm.name.focus();
		return false;
	}
	if(!document.frm.userid.value){
		alert('아이디를 입력해주세요.')
		frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value.length < 5){
		alert('아이디를 5자 이상 입력해야 합니다.')
		frm.userid.focus();
		return false;
	}
	if(!document.frm.pwd.value){
		alert('패스워드를 입력해주세요.')
		frm.pwd.focus();
		return false;
	}
	if(!document.frm.pwd_check.value){
		alert('패스워드를 확인해주세요.')
		frm.pwd_check.focus();
		return false;
	}
	if(document.frm.pwd.value !== document.frm.pwd_check.value){
		alert('비밀번호가 일치하지 않습니다.')
		frm.pwd.focus();
		return false;
	}
	if(!document.frm.checkid.value){
		alert('중복 체크를 하지 않았습니다.')
		frm.userid.focus();
		return false;
	}
	return alert(document.frm.name.value + '님 회원가입을 축하합니다.');
}
		
	// 입력된 양식에 정상 데이터가 포함되었는지 확인
function checkJoin2(){
	if(!document.frm3.pwd.value){
		alert('패스워드를 입력해주세요.')
		frm3.pwd.focus();
		return false;
	}
	if(!document.frm3.pwd_check.value){
		alert('패스워드를 확인해주세요.')
		frm3.pwd_check.focus();
		return false;
	}
	if(document.frm3.pwd.value !== document.frm3.pwd_check.value){
		alert('비밀번호가 일치하지 않습니다.')
		frm3.pwd_check.focus();
		return false;
	}	
	if(document.frm3.pwd.value == document.frm3.beforeid.value){
		alert('이전 비밀번호와 같습니다.')
		frm3.pwd.focus();
		return false;
	}
	if(!document.frm3.email.value){
		alert('이메일을 입력해주세요.')
		frm3.pwd.focus();
		return false;
	}
	if(!document.frm3.phone.value){
		alert('전화번호를 입력해주세요.')
		frm3.pwd.focus();
		return false;
	}		
	return alert(document.frm3.name.value + '님 회원정보가 수정되었습니다. \r\n로그인을 다시 시도하여 주십시오.');
}