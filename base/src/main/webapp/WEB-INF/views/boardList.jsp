<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="pageNavigator" uri="/WEB-INF/tags/pageNavi.tld" %>
	
<script type="text/javascript">

if ('${message}' != '') {
	alert('${message}');
}

function fn_movePage(i) {
	$('#currentPage').val(i);
	$('#frm').attr('action', '${varContextPath}/boardList').submit();	
	}
	
	function insertForm(){
	$('#frm').attr('action', '${varContextPath}/insertForm').submit();
	}
	
	function detail(id) {
	$('#id').val(id);	
 	$('#frm').attr('action', '${varContextPath}/boardDetail').submit(); 
	}
</script>


<form id = "frm" name ="frm" method="post">
<input type="hidden" id="id" name="id">
<input type="hidden" id="currentPage" name="currentPage" value="1">
	<!-- 리스트 게시판 시작-->
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">내용</th>
				<th scope="col">날짜</th>
				<th scope="col">작성자</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${!empty result.list}">
			<c:forEach items = "${result.list}" var="list" varStatus="status"> 
			<tr class="reply">
				<td class="title" style="padding-left: 30px;"><pageNavigator:makePageNavigator pageInstance="${result.navigator }" statusIndex="${status.index}" viewMethod="rowSeq" /></td>
				<td> ${list.title}</td>
				<td> <a href = "javascript:detail('${list.id}');"> ${list.content}</a></td>
				<td> ${list.regDttm}</td>
				<td> ${list.regId}</td>
				<td> 
					<fmt:formatNumber  type="number" value="${list.viewCount}"/> 
				</td>				
			</tr>
		</c:forEach>			
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan ="6" > 조회된 목록이 없습니다. </td>
				</tr>
			</c:otherwise>	
		</c:choose>
		</tbody>
	</table>
	<pageNavigator:makePageNavigator pageInstance="${result.navigator}" viewMethod="Navigator" funcName="fn_movePage"></pageNavigator:makePageNavigator>
	<input type="button" class="btn btn-dark" style= "margin-left:30px" value="글쓰기" onclick="insertForm()"> 
</form>