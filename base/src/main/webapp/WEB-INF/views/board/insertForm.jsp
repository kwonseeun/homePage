<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function insertFrm() {
		$('#frm').attr('action', '${varContextPath}/insert').submit();
	}
</script>

<form id="frm" name="frm" method="post"> 
</br>
	<h2>글쓰기 </h2>

	<input type="text" name="title" class="form-control mt-3 mb-2" placeholder="제목을 입력해주세요." required>
	<input type="text" name="regId" class="form-control mt-3 mb-2" value="${loginUserInfo.id}" placeholder="작성자를 입력해주세요" hidden>
	
	<div class="form-group">
		<textarea class="form-control" rows="9" name="content" placeholder="내용을 입력해주세요" required></textarea>
	</div>
	
	<input type="hidden" class="form-control" id="regDttm" name="regDttm"/>		
	<input type="button" class="btn btn-secondary mb-3" value="등록" onclick="insertFrm()">
</form>	

