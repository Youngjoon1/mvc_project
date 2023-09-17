<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link href="/root/resources/member/css/login.css" rel="stylesheet">
</head>
<body>
	
	<c:import url="../default/header.jsp" />
	
	<div id="loginForm">
		<h1>로그인 페이지 입니다.</h1>
		<form action="loginCk" method="post">
			<input type="text" name="id" placeholder="아이디"><br><br>
			<input type="text" name="pw" placeholder="비밀번호"> <br><br>
			<input type="submit" value="로그인"><br><br>
		</form>
		<a href="joinForm">회원가입</a>
	</div>
	
	<c:import url="../default/footer.jsp" />
	
		
		
		
</body>
</html>