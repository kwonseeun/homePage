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
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/common.css" />" />
<script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />" ></script>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">


<!-- contextPath 값 취득 -->
<c:set var="varContextPath" value="${pageContext.request.contextPath }" scope="session" />
<!-- contextPath 값 취득 -->

</head>

<body>
  <div class="header_bg" >
    <t:insertAttribute name="header"/>
  </div>
  <div class="bg_body" >
      <t:insertAttribute name="content"/>
  </div>
  <div class="bg_footer" >
      <t:insertAttribute name="footer"/>
  </div>
</body>
</html>