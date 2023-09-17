<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link href="/root/resources/member/css/header.css" rel="stylesheet">

</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
	
   	<div id="careCon">
   		<h1 id="care">CARE LAB</h1>
   	</div>
   	<div id="userCon">
   		<c:if test="${user != null }">
   			<b>${user} 님 환영합니다</b>
   		</c:if>
   	
   	</div>
   	
   	<div id="menu">
   		
   		
   		
   		<c:choose>
   			<c:when test="${user == null }">
	   			<a href="${contextPath}">HOME</a> &nbsp;
	   			<a href="${contextPath}/member/login">로그인</a> &nbsp;
	   			<a href="${contextPath}/board/boardAllList">게시판</a>
   			</c:when>
   			<c:otherwise>
   				<a href="${contextPath}">HOME</a> &nbsp;
   				<a href="${contextPath}/member/info?id=${user}">내 정보 보기</a> &nbsp;
   				<a href="${contextPath}/member/logout">로그아웃</a> &nbsp;
   				<a href="${contextPath}/board/boardAllList">게시판</a> &nbsp;
   				<a href="${contextPath}/member/del">탈퇴하기</a>
   			</c:otherwise>
   		</c:choose>
   		
   		
   	</div>
   	
   	<hr>
   
   
</body>
</html>