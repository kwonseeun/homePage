<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript">
function updtBtn() {
	$('#frm').attr('action', '${varContextPath}/userUpdateFrm').submit();	
}
function delBtn(){

	 if (confirm("정말 삭제하시겠습니까??") == true){    //확인
	     document.frm.submit();
	 }else{   //취소
	     return false;
	 }
	 alert('삭제가 완료되었습니다.')

	$('#frm').attr('action', '${varContextPath}/userDelInfo').submit();	
}
function listBtn(){
	$('#frm').attr('action', '${varContextPath}/userList').submit();
} 

</script>

<form id="frm" name="frm" method="post">   
<input type="hidden" id="id" name="id" value= "${user.id}">
	<div class="row">
		<div class="col-xs-2 col-md-2"></div>
		<div class="col-xs-8 col-md-8">
		  <h2 class="text-center">회원정보 보기</h2><p>&nbsp;</p>
	    	<div class="table table-responsive">
	       		 <table class="table">
			        <tr>
			            <th class="success">이름</th>
			            <td>${user.name}</td>
			        </tr>   
			        <tr>
			            <th class="success">가입일</th>
			            <td>${user.joinDttm}</td>
			        </tr> 
			        <tr>
			            <th class="success">이메일</th>
			            <td colspan="3">${user.email}</td>
			        </tr>
			        <tr>
			            <th class="success">삭제여부</th>
			            <td colspan="3">${user.delYn}</td>
			        </tr>
			        <tr>
			            <th class="success">가입일자</th>
			            <td colspan="3">${user.lastLoginDttm}</td>
			        </tr>  
			       		<tr>
			            	<td colspan="4" class="text-center">
								<button type="button" class="btn btn-dark" onclick="javascript:updtBtn();">수정</button>	
								<button type="button" class="btn btn-dark" onclick="javascript:delBtn();" >삭제</button>
								<button type="button" class="btn btn-dark" onclick="javascript:listBtn();">목록</button>
			            	</td>
			        	</tr>         
	        		</table>
	   			 </div>  
	    	</div>
		</div>
</form>
