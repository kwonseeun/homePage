<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <!-- contextPath 값 취득 -->
<c:set var="varContextPath" value="${pageContext.request.contextPath}" scope="session" />
    
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    
<title>board</title>

<script>
	$(document).on('click', '#btnList', function(){
		location.href = "${varContextPath}/board/getBoardList";
	});

	$(document).on('click', '#btnUpdate', function(){
		var url = "${varContextPath}/board/editForm";
		url = url + "?bid="+${boardContent.bid};
		url = url + "&mode=edit";
		
		location.href = url;
	});
	
	function btnDelete(){
		if(confirm('정말 삭제하시겠습니까?'))
		$('#frm').attr('action','${varContextPath}/board/deleteBoard').submit();
	}
	
	// 댓글 목록 
	function showReplyList(){
		var url = "${varContextPath}/board/getReplyList";
		var paramData = {"bid" : "${boardContent.bid}"};

		$.ajax({
            type: 'POST',
            url: url,
            data: paramData,
            dataType: 'json',
            success: function(result) {
               	var htmls = "";
			if(result.length < 1){
				htmls += '<div colspan="6" align="center" 등록된 댓글이 없습니다.></div>';
			} else {
	                    $(result).each(function(){
	                     htmls += '<div class="media text-muted pt-3" id="rid' + this.rid + '">';
	                     htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
	                     htmls += '<title>Placeholder</title>';
	                     htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
	                     htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';
	                     htmls += '</svg>';
	                     htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
	                     htmls += '<span class="d-block">';
	                     htmls += '<strong class="text-gray-dark">' + this.reg_id + '</strong>';
	                     htmls += '<span style="padding-left: 7px; font-size: 9pt">';
	                     htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.rid + ', \'' + this.reg_id + '\', \'' + this.content + '\' )" style="padding-right:5px">수정</a>';
	                     htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.rid + ')" >삭제</a>';
	                     htmls += '</span>';
	                     htmls += '</span>';
	                     htmls += this.content;
	                     htmls += '</p>';
	                     htmls += '</div>';
	                });	//each end
			}
				$("#replyList").html(htmls);
            }// Ajax success end
		});	// Ajax end
	}
	
	$(document).ready(function(){
		showReplyList();
	});

	
	//댓글 저장 버튼 클릭 이벤트 

	$(document).on('click', '#btnReplySave', function(){
		var replyContent = $('#content').val();
		var replyReg_id = $('#reg_id').val();
		var paramData = JSON.stringify({"content": replyContent
				, "reg_id": replyReg_id
				, "bid":'${boardContent.bid}'
		});

		var headers = {"Content-Type" : "application/json"
				, "X-HTTP-Method-Override" : "POST"};

		$.ajax({
			url:"${varContextPath}/board/saveReply"
			, headers : headers
			, data : paramData
			, type : 'POST'
			, dataType : 'text'
			, success: function(result){
				showReplyList();
				$('#content').val('');
				$('#reg_id').val('');
			}
			, error: function(error){
				console.log("에러 : " + error);
			}
		});
	});

	
	// 댓글 수정 
	//댓글 저장 버튼 클릭 이벤트

	$(document).on('click', '#btnReplySave', function(){
		var replyContent = $('#content').val();
		var replyReg_id = $('#reg_id').val();
		var paramData = JSON.stringify({"content": replyContent
				, "reg_id": replyReg_id
				, "bid":'${boardContent.bid}'
		});

		var headers = {"Content-Type" : "application/json"
				, "X-HTTP-Method-Override" : "POST"};
		$.ajax({
			url: "${varContextPath}/board/saveReply"
			, headers : headers
			, data : paramData
			, type : 'POST'
			, dataType : 'text'
			, success: function(result){
				showReplyList();

				$('#content').val('');
				$('#reg_id').val('');
			}
			, error: function(error){
				console.log("에러 : " + error);
			}
		});
	});
	
	function fn_updateReply(rid, reg_id){
		var replyEditContent = $('#editContent').val();
		var paramData = JSON.stringify({"content": replyEditContent
				, "rid": rid
		});

		
		var headers = {"Content-Type" : "application/json"
				, "X-HTTP-Method-Override" : "POST"};

		$.ajax({
			url: "${varContextPath}/board/updateReply"
			, headers : headers
			, data : paramData
			, type : 'POST'
			, dataType : 'text'
			, success: function(result){
                                console.log(result);
				showReplyList();
			}
			, error: function(error){
				console.log("에러 : " + error);
			}
		});
	}
	
	
	function fn_editReply(rid, reg_id, content){
		var htmls = "";
		htmls += '<div class="media text-muted pt-3" id="rid' + rid + '">';
		htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
		htmls += '<title>Placeholder</title>';
		htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
		htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';
		htmls += '</svg>';
		htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
		htmls += '<span class="d-block">';
		htmls += '<strong class="text-gray-dark">' + reg_id + '</strong>';
		htmls += '<span style="padding-left: 7px; font-size: 9pt">';
		htmls += '<a href="javascript:void(0)" onclick="fn_updateReply(' + rid + ', \'' + reg_id + '\')" style="padding-right:5px">저장</a>';
		htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소<a>';
		htmls += '</span>';
		htmls += '</span>';		
		htmls += '<textarea name="editContent" id="editContent" class="form-control" rows="3">';
		htmls += content;
		htmls += '</textarea>';
		htmls += '</p>';
		htmls += '</div>';

		$('#rid' + rid).replaceWith(htmls);
		$('#rid' + rid + ' #editContent').focus();
	}
	
	
	function fn_deleteReply(rid){

		var paramData = {"rid": rid};
		if (confirm('삭제하시겠습니까?'))
		$.ajax({
			url: "${varContextPath}/board/deleteReply"
			, data : paramData
			, type : 'POST'
			, dataType : 'text'
			, success: function(result){
				showReplyList();
			}
			, error: function(error){
				console.log("에러 : " + error);
			}
		});
	}

</script>

<style>
.board_title {
	font-weight : 700;
	font-size : 22pt;
	margin : 10pt;
}

.board_info_box {
	color : #6B6B6B;
	margin : 10pt;
}

.board_author {
	font-size : 10pt;
	margin-right : 10pt;
}

.board_date {
	font-size : 10pt;
}

.board_content {
	color : #444343;
	font-size : 12pt;
	margin : 10pt;
}

.board_tag {
	font-size : 11pt;
	margin : 10pt;
	padding-bottom : 10pt;
}
</style>

<form id="frm" name="frm" method="post">
<input type="hidden" id="bid" name="bid" value="${boardContent.bid}"/> 
	<article>
		<div class="container" role="main"> 
			<h2>board Content</h2>
			<div class="bg-white rounded shadow-sm">
				<div class="board_title"><c:out value="${boardContent.title}"/></div>
				<div class="board_info_box">
					<span class="board_author"><c:out value="${boardContent.reg_id}"/>,</span><span class="board_date"><c:out value="${boardContent.reg_dt}"/></span>
				</div>
				<div class="board_content">${boardContent.content}</div>
				<div class="board_tag">TAG : <c:out value="${boardContent.tag}"/></div>
			</div>
			<div style="margin-top : 20px">
				<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
				<button type="button" class="btn btn-sm btn-primary" id="Delete" onclick="btnDelete();">삭제</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
			
			
			<!-- Reply Form {s} -->
			<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
				<form:form name="form" id="form" role="form" modelAttribute="CommentDTO" method="post">
				<form:hidden path="bid" id="bid"/>

				<div class="row">
					<div class="col-sm-10">
						<form:textarea path="content" id="content" class="form-control" rows="3" placeholder="댓글을 입력해 주세요"></form:textarea>
					</div>

					<div class="col-sm-2">
						<form:input path="reg_id" class="form-control" id="reg_id" placeholder="댓글 작성자"></form:input>
						<button type="button" class="btn btn-sm btn-primary" id="btnReplySave" style="width: 100%; margin-top: 10px"> 저 장 </button>
					</div>
				</div>
				</form:form>
			</div>
			<!-- Reply Form {e} -->

			<!-- Reply List {s}-->
			<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
				<h6 class="border-bottom pb-2 mb-0">Reply list</h6>
				<div id="replyList"></div>
			</div> 
			<!-- Reply List {e}-->

		</div>
	</article>	
</form>	