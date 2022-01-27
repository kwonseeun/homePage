<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags"	prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 		prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 		prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" 	prefix="t"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/common.css" />" />
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />" ></script>
<!-- contextPath 값 취득 -->
<c:set var="varContextPath" value="${pageContext.request.contextPath }" scope="session" />

</head>

<body>
      <t:insertAttribute name="content"/>
</body>

</html>