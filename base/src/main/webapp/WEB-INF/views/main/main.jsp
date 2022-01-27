<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css"
 integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<script type="text/javascript">
	function userList(){
		$('#frm').attr('action', '${varContextPath}/userList').submit();
	}
	function userBtn(){
		$('#frm').attr('action', '${varContextPath}/userList').submit();
	}
	function boardBtn(){
		$('#frm').attr('action', '${varContextPath}/boardList').submit();
	}
	function logoutBtn(){
		$('#frm').attr('action', '${varContextPath}/logout').submit();
	}
	
	function myBtn(){
		$('#frm').attr('action', '${varContextPath}/myPageFrm').submit();
	}
	
	function Message(){
		$('#frm').attr('action', '${varContextPath}/messageBox').submit();
	}
</script>
<style>
 *{
 	@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap');
    font-family: 'Ubuntu', sans-serif;
      }
</style>
<form id="frm" name="frm" method="post">   
<input type="hidden" id="id" name="id" value= "${user.id}">
<input type="hidden" id="email" name="email" value= "${user.email}">

<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand"  href="/base/main"><i class="bi bi-apple"></i> HOME</a>
			 <div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active">
						<a class="btn btn-dark btn-sm" style="color:white" onclick="logoutBtn();">로그아웃</a>
						<a class="btn btn-dark btn-sm" style="color:white" onclick="myBtn();">마이페이지</a>
						<a class="btn btn-dark btn-sm" style="color:white" onclick="Message();">쪽지함</a>
					</li>					
					<c:if test="empty ${loginUserInfo} ">		
						<li class="nav-item">	
							<a class="nav-link" href="/user/joinForm">회원가입</a>
						</li>
					</c:if>	
				</ul>
			</div>
		</div>
	</nav>
<!--jombotron 시작 -->
	<div class="jumbotron">
	  <h1 class="display-4">Hello, world!</h1>
	 	 <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
	  		<hr class="my-4">
	  			<p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
	  			<p class="lead">
	   		 	<a class="btn btn-dark btn-lg" style="color:white"  role="button"	onclick="javascript:boardBtn();">BOARD</a> 	
	   		 	<a class="btn btn-dark btn-lg" style="color:white"  role="button"	onclick="javascript:myBtn();">MYPAGE</a>
	   		 	
		   	<c:if test="${!empty adminInfo}"> 
		   		<a class="btn btn-dark btn-lg" style="color:white" role="button" 	onclick="javascript:userBtn();">USERLIST</a>
		   	</c:if>	 
	 	 </p>
	</div>
<!-- jonbotron 끝  -->
</form>
	