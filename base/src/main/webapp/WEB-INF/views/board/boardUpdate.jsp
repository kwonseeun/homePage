<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function updtFrm(){
	$('#frm').attr('action', '${varContextPath}/boardUpdate').submit();
}
</script>
<form id="frm" name="frm" method="post">
<input type="hidden" id="id" name="id" value="${board.id}" > 
	<h2> 게시글 수정 </h2>
			<label>제 목 </label>
			<input type="text" name="title" id="title" class="form-control mt-3 mb-2" value="${board.title}"/>		
	<div class="form-group"> 
			<label>내 용 </label>
			<textarea class=" form-control" row="9" name="content" id="content" class="form-control" value="${board.content}" /></textarea>		
	</div>
	<div class="mb-3">
			<input type="hidden" name="updtId" id="updtId" value="${board.updtId}" readonly="readonly"/>		
	</div>	
	
			<input type="hidden" class="form-control" id="regDttm" name="regDttm"/>		
			<input type="button" value="수정 " onclick="javascript:updtFrm();">
</form>	