/**
 *	[공통] javascript utils
 */
$.ajaxPOST = function ( url, params, fn)
{
  $.ajax({
        url: url
      , type: "POST" //요청 메소드 방식
      , data : JSON.stringify( params )
      , dataType:"JSON" //서버가 요청 URL을 통해서 응답하는 내용의 타입
      , contentType : "application/json; charset=UTF-8"
      , success : function( data ){
         fn(data);
      }
      , error : function( a, b, c ){
        //통신 실패시 발생하는 함수(콜백)
        console.log(a);
        console.log(b);
        console.log(c);
      }
  });
}
