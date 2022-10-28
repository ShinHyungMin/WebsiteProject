/**
 * 
 */

function checkQna()	{
	if(document.frm.bbsTitle.value.length===0) {
		alert("제목을 입력하세요.")
		frm.bbsTitle.focus();
		return false;
	}
	if(document.frm.bbsContent.value.length===0) {
		alert("내용을 입력하세요.")
		frm.bbsContent.focus();
		return false;
	}
	return true;
}

function clickDelete() {
	if(confirm("정말 삭제하시겠습니까?") == true) {
		alert("삭제되었습니다");
	} else {
		return false;
	}
}

function clickempty() {
	if(document.search.column.value==0) {
		alert("검색 범위를 선택하세요.")
		search.column.focus();
		return false;
	}
		if(!document.search.keyword.value) {
		alert("검색어를 입력하세요.")
		search.column.focus();
		return false;
	}
}