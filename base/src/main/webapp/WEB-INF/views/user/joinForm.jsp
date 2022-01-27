<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />"></script>
<script src="<c:url value="/resources/js/utils/commons.js" />"></script>

<script type="text/javascript">

$(document).ready(function(){

	$('#email_server').change(function(){
		
		var mail_ck = $(this).val(); 
		if (mail_ck == '') {
			$('#emailSubFix').attr('readonly', false);
		}else{
			$('#emailSubFix').attr('readonly', true);
		}
		
		$('#emailSubFix').val(mail_ck);
		
	});
	
});



function fn_idChk(){
    $.ajax({
      url : "${varContextPath}/idCheckDup",
      type : "post",
      dataType : "json",
      data : {id : $("#id").val()},
      success : function(data){
        if(data == 1){
          alert("중복된 아이디 입니다 .");
        }else if(data == 0){
          $("#idChk").attr("value", "Y");
          alert("사용가능한 아이디입니다.");
        }
      }
    })
  }
  

function joinBtn() {
	
	var RegExp = /^[a-zA-Z0-9]{4,12}$/; //id와 pwassword 유효성 검사 정규식
	
    //이메일 유효성검사
    var e_RegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    
    //이름 유효성검사 
    var n_RegExp = /^[가-힣]{2,15}$/;

	var objId = document.getElementById("id");
	var objPw = document.getElementById("pw");
	var objEmail = document.getElementById("email");
	var objName = document.getElementById("name");
	
	var id = $('#id').val();
	
	var mailPreFix = $('#emailPreFix').val();
	var mailSubFix = $('#emailSubFix').val();
	
	var emailAddr = mailPreFix + '@' + mailSubFix;
	
	alert('회원가입이 완료되었습니다.');
	
	
	if (id == '') {
		alert("ID를 입력해주세요. ");
		return false;
	}
	 if(!RegExp.test(objId.value)){ //아이디 유효성검사
        alert("ID는 4~12자의 영문 대소문자와 숫자로만 입력하여 주세요.");        
        return false;
    }

	// PW 유효성 검사 
	if (objPw.value=='') {
		alert("PW를 입력해주세요. ");
		return false;
	}
	
	// NAME 유효성 검사 
	if (objName.value=='') {
		alert("NAME를 입력해주세요. ");
		return false;
	}

	// EMAIL 유효성 검사 
	if (emailAddr =='') {
		alert("EMAIL를 입력해주세요. ");
		return false;
	}

	if (!e_RegExp.test(emailAddr)) {
		alert("올바른 이메일 형식이 아닙니다. ");
		return false;
	} 
	 
	$('#email').val(emailAddr);
	
	$('#frm').attr('action', '${varContextPath}/joinRegist').submit();
}

</script>

	<form id="frm" name="frm" method="post" >
<!-- 	아이디	<input type="text" 		id="id" 	name="id" 	 placeholder="아이디를 입력해주세요"> <button type="button" id="idChk" onclick="javascript:fn_idChk();">중복체크 </button></br>	
		비밀번호	<input type="password"  id="pw" 	name="pw" 	 placeholder="비밀번호를 입력해주세요"></br>
		이름		<input type="text" 		id="name" 	name="name"  placeholder="이름 입력해주세요"></br>
		이메일	<input type="text"		id="emailPreFix" name="emailPreFix" placeholder="이메일을 입력해주세요">@<input name="emailSubFix" id="emailSubFix" type="text" style="width:120px" >
				<input type="hidden"	id="email" name="email"/>
-->

<div class="container">
	</br>
      <h2>회원가입 페이지</h2>
	
        <div class="form-group">
          <label for="id">아이디:</label>
          <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력해주세요"> <button type="button" class="btn btn-dark btn-sm" id="idChk" onclick="javascript:fn_idChk();">중복체크</button>
        </div>
        
        <div class="form-group">
          <label for="pw">비밀번호:</label>
          <input type="text" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력해주세요">
        </div>

        <div class="form-group">
          <label for="name">이름:</label>
          <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력해주세요"> 
        </div>
        
        <div class="form-group">
          <label for="email">메일:</label>
          <input type="text" class="form-control" id="emailPreFix" name="emailPreFix" placeholder="이메일 아이디를 입력해주세요"> @ <input name="emailSubFix" id="emailSubFix" type="text" >
          <input type="hidden" id="email" name="email"/>
        </div>

	        <select name="email_server" id="email_server">
				<option value="">직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="nate.com">nate.com</option>
				<option value="daum.net">hanmail.net</option>
				<option value="gmail.com">gmail.com</option>
			</select>
    </div>    			 

		<button type="button" class="btn btn-dark btn-sm" style="margin-left:160px" onclick="javascript:joinBtn();">회원가입</button>
	</form>