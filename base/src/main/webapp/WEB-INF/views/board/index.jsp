<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- contextPath 값 취득 -->
<c:set var="varContextPath" value="${pageContext.request.contextPath }" scope="session" />

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>


<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!--메뉴바 추가 부분-->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Expand at sm</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

 <div class="collapse navbar-collapse" id="navbarsExample03">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">BOARD<span class="sr-only">(current)</span></a>
      </li>

      <li class="nav-item">
        <a class="nav-link" href="#">Q&A</a>
      </li>
    </ul>

    <form class="form-inline my-2 my-md-0">
      <input class="form-control" type="text" placeholder="Search">
    </form>
  </div>
</nav>

<style>


body {

	padding-top: 0px;

	padding-bottom: 30px;

}

</style>

<script>
	// 글 작성 
	function btnWriteForm(){
		$('#frm').attr('action','${varContextPath}/board/boardForm').submit();	
	}
	
	// 글 조회
	function fn_contentView(bid){
		$('#bid').val(bid);
		$('#frm').attr('action','${varContextPath}/board/getBoardContent').submit();			
	}
	
	
	// 검색
	$(document).on('click', '#btnSearch', function(e){
		e.preventDefault();
		var url = "${varContextPath}/board/getBoardList";
		url = url + "?searchType=" + $('#searchType').val();
		url = url + "&keyword=" + $('#keyword').val();

		location.href = url;
		console.log(url);
	});	
	
	
	//이전 버튼 이벤트

	function fn_prev(page, range, rangeSize) {
			var page = ((range - 2) * rangeSize) + 1;
			var range = range - 1;
			var url = "${varContextPath}/board/getBoardList";
			url = url + "?page=" + page;
			url = url + "&range=" + range;

			location.href = url;
		}

	  //페이지 번호 클릭   

		function fn_pagination(page, range, rangeSize, searchType, keyword) {
			var url = "${varContextPath}/board/getBoardList";
			url = url + "?page=" + page;
			url = url + "&range=" + range;

			location.href = url;	
		}

		//다음 버튼 이벤트

		function fn_next(page, range, rangeSize) {
			var page = parseInt((range * rangeSize)) + 1;
			var range = parseInt(range) + 1;			
			var url = "${varContextPath}/board/getBoardList";
			url = url + "?page=" + page;
			url = url + "&range=" + range;

			location.href = url;
		}
	
</script>

<form id ="frm" name="frm" method="post">
<input type="hidden" id="bid" name="bid" value="0" />
	<article>
		<div class="container"> 
   			<h2>board list</h2>
	 <div class="table-responsive"> 
		<table class="table table-striped table-sm">
			<colgroup>
					<col style="width:auto;" />
					<col style="width:auto;" />
					<col style="width:auto;" />
					<col style="width:auto;" />
					<col style="width:auto;" />
					<col style="width:20%;" />
			</colgroup>
		<thead>
			<tr>
				<th>NO</th>
				<th>글제목</th>
				<th>내용 </th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty boardList }" >
					<tr><td colspan="6" align="center">데이터가 없습니다.</td></tr>
				</c:when> 
				<c:when test="${!empty boardList}">
					<c:forEach var="list" items="${boardList}">
						<tr>
							<td>
								<c:out value="${list.bid}"/>
							</td>							
						<td>
							<a href="javascript:fn_contentView('<c:out value="${list.bid}"/>')">							
								<c:out value="${list.title}"/>
							</a>		
						</td>
							<td><c:out value="${list.reg_id}"/></td>
							<td><c:out value="${list.content}"/></td>
							<td><c:out value="${list.view_cnt}"/></td>
							<td><c:out value="${list.reg_dt}"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
	 	 </tbody>
   	  </table>
   </div>
<div>
	<button type="button" class="btn btn-sm btn-primary" id="writeForm" onClick="btnWriteForm();">글쓰기</button>
</div>	

<ul class="pagination">
	<li class="page-item">...</li class="page-item">
</ul>

<!-- pagination{s} -->
	<div id="paginationBox">
		<ul class="pagination">
			<c:if test="${pagination.prev}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
			</c:if>

			<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
				<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a></li>
			</c:forEach>

			<c:if test="${pagination.next}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', 
				'${pagination.range}', '${pagination.rangeSize}')" >Next</a></li>
			</c:if>
		</ul>
	</div>
<!-- pagination{e} -->


<!-- search{s} -->
		<div class="form-group row justify-content-center">
			<div class="w100" style="padding-right:10px">
				<select class="form-control form-control-sm" name="searchType" id="searchType">
					<option value="title">제목</option>
					<option value="Content">본문</option>
					<option value="reg_id">작성자</option>
				</select>
			</div>
			<div class="w300" style="padding-right:10px">
				<input type="text" class="form-control form-control-sm" name="keyword" id="keyword">
			</div>
			<div>
				<button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch">검색</button>
			</div>
		</div>
<!-- search{e} -->
 </div>
</article>

</form>

