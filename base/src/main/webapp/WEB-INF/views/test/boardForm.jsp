<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>


<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">


<title>board</title>

<script>

	$(document).on('click', '#btnSave', function(e){
		e.preventDefault();
		$("#form").submit();
	});

	$(document).on('click', '#btnList', function(e){
		e.preventDefault();
		location.href="${varContextPath}/board/getBoardList";
	});

	$(document).ready(function(){
			var mode = '<c:out value="${mode}"/>';
			if ( mode == 'edit'){
			
				//입력 폼 셋팅
				$("#reg_id").prop('readonly', true);
				$("input:hidden[name='bid']").val(<c:out value="${boardContent.bid}"/>);
				$("input:hidden[name='mode']").val('<c:out value="${mode}"/>');
				$("#reg_id").val('<c:out value="${boardContent.reg_id}"/>');
				$("#title").val('<c:out value="${boardContent.title}"/>');
				$("#content").val('<c:out value="${boardContent.content}"/>');
				$("#tag").val('<c:out value="${boardContent.tag}"/>');
			}
		});
</script>

<style>
body {

  padding-top: 70px;
  padding-bottom: 30px;
}

</style>

	<article>
		<div class="container" role="main">
				<h2>게시글 작성</h2>
			<form:form name="form" id="form" role="form" modelAttribute="testDTO" method="post" 
			action="${varContextPath}/board/saveBoard">
			<form:hidden path="bid"/>
			<input type="hidden" name="mode"/>
			
				<div class="mb-3">
					<label for="title">제목</label>
					<form:input path="title" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요"/>
				</div>
	
				<div class="mb-3">
					<label for="reg_id">작성자</label>
					<form:input path="reg_id" class="form-control" name="reg_id" id="reg_id" placeholder="이름을 입력해 주세요"/>
				</div>

				
				<div class="mb-3">
					<label for="content">내용</label>
					<form:textarea path="content" class="form-control" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요" />
				</div>


				<div class="mb-3">
					<label for="tag">TAG</label>
					<form:input path="tag" class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요"/>
				</div>
			</form:form>

			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnSave" onclick="javascript:btnSave();">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList" onclick="javascript:btnList();">목록</button>
			</div>
		</div>
	</article>