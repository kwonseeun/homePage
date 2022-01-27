<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">

$(document).ready(function(){
});
// document.ready end

// 페이지 이동
function fn_menu( menuCode )
{

  var url = "${varContextPath}/";

  if( menuCode == "01" )	// 메인화면
    {
      url = "${varContextPath}/main";
    }
  else if( menuCode == "02" )	// 게시판 목록
    {
      url = "${varContextPath}/boardList";
    }
  else if( menuCode == "03" )	// 로그인 화면
    {
      url = "${varContextPath}/";
    }
  else if( menuCode == "05" )	// 로그아웃
  {
    url = "${varContextPath}/logout";
  }
  else if( menuCode == "06" )	//회원관리 페이지 
  {
    url = "${varContextPath}/userList";
  }

  // post 방식 화면 전환용 동적 form 생성 및 submit
  var mFrm = $("<form></form"); 
  mFrm.attr("method","post");
  mFrm.attr("action",url);
  mFrm.appendTo("body");
  mFrm.submit();
}

</script>
<style> 

/* navbar */
.navbar-default {
    background-color: #F8F8F8;
    border-color: #E7E7E7;
}
</style>

<!-- 네비게이션바 -->
<nav class="navbar navbar-expand-lg navbar-light border-bottom navbar-fixed-top" style="color:dark">
    <a class="navbar-brand" href="/base"> HOME </a>
   <c:if test="${!empty loginUserInfo}">   
    <div class="collapse navbar-collapse flex-grow-0" id="navbarNav">
        <ul class="navbar-nav">
	            <li class="nav-item ">
	                 <span onclick="fn_menu('02');" >게시판</span>
	            </li>
	           <li class="nav-item ">
	                 <span onclick="fn_menu('05');" >&nbsp; 로그아웃</span>
	            </li>
	            
           </ul> 
    </div>
   </c:if> 
   
   <c:if test="${!empty adminInfo}">   
    <div class="collapse navbar-collapse flex-grow-0" id="navbarNav">
        <ul class="navbar-nav">
	           <li class="nav-item ">
	                 <span onclick="fn_menu('06');" >&nbsp; 회원관리</span>
	            </li>
           </ul> 
    </div>
   </c:if> 
</nav>

<%-- <div>
 <c:if test="${!empty loginUserInfo}"> 
	  <span onclick="fn_menu('01');" >메인</span>
	  <span onclick="fn_menu('02');" >게시판</span>
 	  <span onclick="fn_menu('05');" >logout</span>
</c:if>
<c:if test="${!empty adminInfo}">
	  <span onclick="fn_menu('01');" >메인</span>
	  <span onclick="fn_menu('02');" >게시판</span>
	  <span onclick="fn_menu('05');" >logout</span>
	  <span onclick="fn_menu('06');" >회원관리</span> 
</c:if>	  
</div> --%>
