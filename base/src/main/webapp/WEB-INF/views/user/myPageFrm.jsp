<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

	function updtFrm(){
		$('#frm').attr('action','${varContextPath}/myPage').submit();
	}
</script>

<form id="frm" name="frm" method="post">   
<input type="hidden" id="id" name="id" value="${user.id}">
 <div class="container">
      <h2>내정보 수정</h2>
	
        <div class="form-group">
          <label for="id">아이디:</label>
          <input type="text" class="form-control" id="userId" name="userId" value="${user.id}" disabled>
        </div>

        <div class="form-group">
          <label for="pw">가입일자:</label>
          <input type="text" class="form-control" id="joinDttm" name="joinDttm" value="${user.joinDttm}"disabled>
        </div>
        
        <div class="form-group">
          <label for="email">메일:</label>
          <input type="text" class="form-control" id="email" name="email" value="${user.email}" >
        </div>
        
        <div class="form-group">
          <label for="name">이름:</label>
          <input type="text" class="form-control" id="name" name="name" value="${user.name}" >
        </div>

        <div class="form-group">
          <label for="lastLoginDttm">마지막 로그인 일자:</label>
          <input type="text" class="form-control" id="lastLoginDttm" name="lastLoginDttm" value="${user.lastLoginDttm}" disabled>
        </div>

        <button type="button" class="btn btn-dark" onclick="javascript:updtFrm();">수정</button>
    </div>    
</form>  
