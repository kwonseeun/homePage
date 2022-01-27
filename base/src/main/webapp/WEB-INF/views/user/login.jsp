<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" 
integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<script type="text/javascript">
if ('${message}' != '') {
	alert('${message}');
}

function joinBtn() {
	$('#frm').attr('action', '${varContextPath}/joinForm').submit();
}

function logBtn() {	
	$('#frm').attr('action', '${varContextPath}/login').submit();
}
</script>	
	
<form id="frm" name="frm" method="post">
	<div class="container" style="margin-top:150px">
		<div class="row">
			<div class="col-lg-4"></div>
				<%-- 입력폼 그리드 --%>
				<div class="col-lg-4">
					&nbsp;&nbsp;&nbsp;<h2>LOGIN</h2>
					<!-- ID입력 -->
					<div class="input-group my-2 mb-1">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">ID</span>
						</div>
						<input type="text" id="id" name="id" class="form-control" placeholder="아이디를 입력해주세요" aria-label="id" aria-describedby="basic-addon1" required>
					</div>
					<!-- PW입력 -->
					<div class="input-group my-2 mb-1">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">PW</span>
						</div>
						<input type="password" name="pw" class="form-control" placeholder="비밀번호를 입력해주세요" aria-label="pw" aria-describedby="basic-addon1" required>
					</div>
						<!-- 로그인 버튼 -->
						<button type="button" class="btn btn-dark btn-sm btn-block mt-1" onclick="javascript:logBtn();"> 로그인 </button>
						<!-- 회원가입 버튼 -->
						<button type="button" class="btn btn-dark btn-sm btn-block mt-1" onclick="javascript:joinBtn();">회원가입 </button>
					</div>
			<div class="col-lg-4"></div>
		</div>
	</div>			
</form>	