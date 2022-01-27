<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/common.css" />" />
<script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />"></script>
<script src="<c:url value="/resources/js/utils/commons.js" />"></script>

<!-- contextPath 값 취득 -->
<c:set var="varContextPath" value="${pageContext.request.contextPath }"
	scope="session" />
<!-- contextPath 값 취득 -->
</head>
<body>
	<script type="text/javascript">
		$(document).ready(
				function() {

					//   var params = {
					//       id : "asdfasd"
					//       , pw : "sdfsdfsd"
					//   };
					//   $.post( "${varContextPath}/testAjax", JSON.stringify( params ), function( data ) {

					//     $("body").append( data.id + "   " + data.pw );
					//   });

					//   $.ajax({
					//       type: "post" //요청 메소드 방식
					//     , url:"${varContextPath}/testAjax"
					//     , data : JSON.stringify( params )
					//     , dataType:"json" //서버가 요청 URL을 통해서 응답하는 내용의 타입
					//     , contentType : "application/json; charset=UTF-8"
					//     , success : function( data ){
					//       //서버의 응답데이터가 클라이언트에게 도착하면 자동으로 실행되는함수(콜백)
					//       //result - 응답데이터
					//       //$('#result').text(result);
					//        $("body").append( data.id + "   " + data.pw );
					//     }
					//     , error : function(a, b, c){
					//       //통신 실패시 발생하는 함수(콜백)
					//       console.log(a);
					//       console.log(b);
					//       console.log(c);
					// //       alert(a + b + c);
					//     }
					//   });
					// 메인화면 이동
					$("#mainBtn").click(function() {
						$("#frm").attr({
							"action" : "${varContextPath}/main"
						}).submit();
					});
 
					//   var params = {
					//       id : "asdfasd"
					//       , pw : "sdfsdfsd"
					//   };

					//   $.ajaxPOST( "${varContextPath}/testAjax", params, fn_test );

					//   $.post( "${varContextPath}/testAjax",  params , fn_test );

					// console.log( JSON.stringify( $( "#frm" ).serialize() ) );

					$.post("${varContextPath}/notice/view/testAjax", $("#frm").serialize(), fn_test);

				});
		
		// document.ready end

		function fn_test(datas) {
			console.log(datas);
			alert("--------");
		}
		
		function joinBtn() {
			$('#frm').attr('action', '${varContextPath}/join').submit();
		}
	</script>
	
	<form id="frm" name="frm" method="post">
		<h2>Login</h2>
		<input type="text" id="id" name="id" value="아이디를 입력해주세요">
		<input type="text" id="pw" name="pw" value="비밀번호를 입력해주세요">
		<button type="button" onclick="javascript:joinBtn();">회원가입</button>
	</form>
</body>
</html>