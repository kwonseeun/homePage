<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript">

var id = $('#id').val();


$(document).ready(function(){
	commentList();	
	
});

function updtBtn(){	
	$('#frm').attr('action', '${varContextPath}/boardUpdateFrm').submit();
}	

function delBtn(){
	if(confirm("정말 삭제하시겠습니까?"))
	$('#frm').attr('action','${varContextPath}/boardList').submit();
}

function listBtn(){
	$('#frm').attr('action','${varContextPath}/boardList').submit();
}

function commentInsert(){
	var content= $('#content').val();
	var bid = $('#id').val();
	
	var params = {
				'content' : content,
				'bid' : bid
				}
	
		$.ajax({
			url: "${varContextPath}/commentInsert",
			type: "post",
			data: params,
			success: function(data){
				
			console.log (data);
		
			if (data.resultCode == '0000'){
				alert('등록이 완료되었습니다.');
				commentList();
				$('#content').val("");
			}else{
				alert(data.resultMsg);
			}
			commentList();
		}
	})	
}
	//댓글 목록 
	function commentList(){ 
		var bid = $("#id").val();
		var content = $("#content").val();
		
	    $.ajax({
	        url : '${varContextPath}/commentList',
	        type : 'post',
	        data : {
	        		'bid':bid
	        		
	        		},
	        success : function(data){
	            var a =''; 
	            $.each(data, function(key, value){ 
	                a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
	                a += '<div class="commentInfo'+value.cno+'">'+'작성자 : '+value.regId;
	                a += '<button type="button" style="margin-left:20px" class="btn btn-primary btn-sm" onclick="updateCmt('+value.cno+');"> 수정 </button> &nbsp;';
	                a += '<button type="button" class="btn btn-dark btn-sm" onclick="commentDelete('+value.cno+');"> 삭제 </button> </div>';
	                a += '<div class="commentContent'+value.cno+'">'; 
	               	a += '<p id="p_com_'+value.cno+'"> 내용 : '+value.content +'</p></br>';
	               	a += '<p id="p_input_'+value.cno+'" style="display: none;"> <input type="text" name="comm_input" id="comm_'+value.cno+'"/>&nbsp;<button type="button" class="btn btn-dark btn-sm" onclick="commentUpdate('+value.cno+');">수정완료 </button></p>';
	                a += '</div></div>';
	            })
	            
	          $(".commentList").html(a);
	      }
	});
}
	
function updateCmt(cno) {
	if ($("#p_com_"+cno).is(':visible')) {
		$("#p_com_"+cno).hide();
		$("#p_input_"+cno).show();
	} else {
		$("#p_com_"+cno).show();
		$("#p_input_"+cno).hide();
	}
}
 // 댓글 수정 
function commentUpdate(cno){
	var content = $("#comm_"+cno).val();
    	 
		$.ajax({
	        url : '${varContextPath}/commentUpdate',
	        type : 'post',
	        data : {
	        		'cno': cno,
	        		'content': content 
	        		},
	        success : function(data){
	        console.log (data) ;
	        
	        if (data.resultCode == '0000') {
				alert('수정이 완료되었습니다.');
				commentList();
			}else{
				alert(data.resultMsg);
			}     
   	 	}
    }); 
} 
 
// 댓글 삭제
function commentDelete(cno){ 
	
		if(confirm("정말 삭제하시겠습니까?"))
	     $.ajax({
	        url : '${varContextPath}/commentDelete',
	        type : 'post',
	        data : {'cno': cno},
	        success : function(data){
	        console.log (data) ;
	        
	        if (data.resultCode == '0000') {
				alert('삭제가 완료되었습니다.');
				commentList();
			}else{
				alert(data.resultMsg);
			}     
	      }
	   }); 
	}
</script>

<style type="text/css"><!-- Simple Css -->
			html, body{ margin:0; padding:0}
			body{ width:1000px; margin:0 auto; }
</style>


<form id ="frm" name="frm" method="post">
<input type="hidden" id="id" name="id" value= "${board.id}">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr><!-- BOARD TITLE -->
			</br>
				<td colspan="6" align="center">
					<h2>게시글 상세조회</h2>
				</td>
			</tr>
			<tr height="100">
			
			<!-- BOARD CONTENTS -->
				<th>제목</th>
				<td>${board.title}</td>
				<th>작성자</th>
				<td>${board.regId}</td>
				<th>등록일자</th>
				<td>${board.regDttm}</td>
			</tr>
			<tr height="200">
				<th>내용</th>
				<td>${board.content}</td>
			</tr>
</table>

<c:if test="${loginUserInfo.id eq board.regId or !empty adminInfo}">
	<div style="margin-top: 20px">xxx
		<button type="button" class="btn btn-dark btn-sm btn-block mt-2" style="margin-right:10px" onclick="javascript:updtBtn();">수정</button>	
		<button type="button" class="btn btn-dark btn-sm btn-block mt-2" onclick="javascript:delBtn();" >삭제</button>
	</div> 
</c:if> <button type="button" class="btn btn-sm btn-block btn-dark mt-2" onclick="javascript:listBtn();">목록</button></br>
</form> 
 <!--  댓글  -->
    <div class="container">
        <label for="content"><b>comment</b></label>
            <div class="input-group">
            	<input type="hidden" id="writer" name="writer" value="${loginUserInfo.id}">
               <input type="text" class="form-control" id="content" name="content" placeholder="내용을 입력하세요.">
               <span class="input-group-btn">
                    <button class="btn btn-dark" style="margin-left:30px" type="button" id="commentInsert" name="commentInsert"
                    onclick="commentInsert();">등록</button></br>
               </span>
          </div>
	</div></br>
	
<div class="container">
   <div class="commentList"></div>
</div>
