<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="pageNavigator" uri="/WEB-INF/tags/pageNavi.tld" %>

<script type="text/javascript">
	function fn_movePage(i) {
		$('#currentPage').val(i)
		$('#frm').attr('action','${varContextPath}/userList')	
	}
	function fn_movePage(i) {
		$('#currentPage').val(i);
		$('#frm').attr('action', '${varContextPath}/userList').submit();	
		}
	
	function detail(id) {
		$('#id').val(id)
		$('#frm').attr('action', '${varContextPath}/userView').submit(); 
	}
	
</script>

<form id="frm" name="frm" method="post"> 
	<input type="hidden" id="id" name="id">
	<input type="hidden" id="currentPage" name="currentPage" value="1">
<table class="table table-hover table-striped text-center" style="border:1px solid">
	<tbody>
		<tr>
			<th scope="col">번호</th>
			<th scope="col">아이디</th>
			<th scope="col">가입일자</th>
			<th scope="col">메일</th>
			<th scope="col">이름</th>
			<th scope="col">회원상태</th>
			<th scope="col">삭제여부</th>
			<th scope="col">마지막 로그인 일자</th>
		</tr>
<c:choose>

<c:when test="${!empty result.list}">
	<c:forEach items="${result.list}" var="user" varStatus="status">			
		<tr class="reply">
		<td class="title" style="padding-left: 30px;"><pageNavigator:makePageNavigator pageInstance="${result.navigator }" statusIndex="${status.index}" viewMethod="rowSeq" /></td>
			<td>${user.id}</td>
			<td>${user.joinDttm}</td>
			<td>${user.email}</td>
			<td><a href="javascript:detail('${user.id}');">${user.name}</a></td> 
			<td>${user.status}</td> 
			<td>${user.delYn}</td> 
			<td>${user.lastLoginDttm}</td>
		</tr>	
	</c:forEach>
  </c:when>
<c:otherwise>
		<tr>
			<td colspan = "7"> 회원 목록이 없습니다.</td>
		</tr>	
		</c:otherwise>
	</c:choose>	
	</tbody>
</table>
</form>
</br>

	<pageNavigator:makePageNavigator pageInstance="${result.navigator}" viewMethod="Navigator" funcName="fn_movePage"></pageNavigator:makePageNavigator>
</br>
