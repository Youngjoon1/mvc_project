<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function daumPost() {
    	new daum.Postcode({
        	oncomplete: function(data) {
            	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            	// 예제를 참고하여 다양한 활용법을 확인해 보세요.
        		const addr1 = document.getElementById("addr1");
                const addr2 = document.getElementById("addr2");
                const addr3 = document.getElementById("addr3");
                let addr="";
                if(data.userSelectedType === "R") {
                	addr = data.roadAddress;
                }else {
                	addr = data.jibunAddress;
                }
                addr1.value = data.zonecode;
                addr2.value = addr;
                addr3.focus();
        	}
    		}).open();
    }
    
</script>

<style type="text/css">
	#Con {
		text-align: center;
	}
</style>
</head>
<body>
	<c:import url="../default/header.jsp" />
	<div id="Con">
		<h1>회원 등록</h1>
		
		<form action="join" method="post">
			id : <br> 
			<input type="text" name="id"><br>
			pw : <br>
			<input type="text" name="pw"><br>
			name : <br>
			<input type="text" name="name"><br>
			addr : <br>  
					<input type="text" name="numberaddr" id="addr1"><br>
					<input type="text" name="roadaddr" id="addr2"><br>
					<input type="text" name="detailaddr" id="addr3"><br>
					<button type="button" onclick="daumPost()">주소록 검색</button><br>
			email : <br>
			<input type="email" name="email"><br><br>
			<input type="submit" value="가입하기">
		</form>
		
	</div>
	<c:import url="../default/footer.jsp" />
</body>
</html>