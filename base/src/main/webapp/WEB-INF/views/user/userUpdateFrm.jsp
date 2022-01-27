<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

	function updtFrm(){
		$('#frm').attr('action','${varContextPath}/userUpdate').submit();
	}
</script>

<form id="frm" name="frm" method="post">   
<input type="hidden" id="id" name="id" value="${user.id}" > 
<input type="hidden" id="email" name="email" value="${user.email}" > 

 <div class="container">
      <h2>회원정보 수정</h2>

        <div class="form-group">
          <label for="id">아이디:</label>
          <input type="text" class="form-control" id="id" value="${user.id}" disabled>
        </div>

        <div class="form-group">
          <label for="pw">가입일자:</label>
          <input type="text" class="form-control" id="joinDttm" value="${user.joinDttm}"disabled>
        </div>
        
        <div class="form-group">
          <label for="email">메일:</label>
          <input type="text" class="form-control" id="email" value="${user.email}" disabled>
        </div>
        
        <div class="form-group">
          <label for="name">이름:</label>
          <input type="text" class="form-control" id="name" value="${user.name}" disabled>
        </div>
        
        <div class="form-group">
          <label for="status">회원상태:</label>
          <input type="text" class="form-control" id="status" value="${user.status}">
        </div>
        
        <div class="form-group">
          <label for="delYn">삭제여부:</label>
          <input type="text" class="form-control" id="delYn" value="${user.delYn}">
        </div>
        
        <div class="form-group">
          <label for="lastLoginDttm">마지막 로그인 일자:</label>
          <input type="text" class="form-control" id="lastLoginDttm" value="${user.lastLoginDttm}" disabled>
        </div>

        <button type="button" class="btn btn-dark" onclick="javascript:updtFrm();">수정</button>
    </div>    
</form>  
