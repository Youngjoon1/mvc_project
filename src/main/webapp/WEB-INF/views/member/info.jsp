<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 페이지</title>
<style type="text/css">
	#Con {
		margin-left: 800px;
	}
	
</style>

</head>
<body>
	<c:import url="../default/header.jsp" />
	
	<div id="Con">
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>지번주소</th>
				<th>도로명주소</th>
				<th>상세주소</th>
				<th>이메일</th>
			</tr>
			<tr>
				<th>${userInfo.id}</th>
				<th>${userInfo.pw}</th>
				<th>${userInfo.name}</th>
				<th>${userInfo.numberaddr}</th>
				<th>${userInfo.roadaddr}</th>
				<th>${userInfo.detailaddr}</th>
				<th>${userInfo.email}</th>
			</tr>
		</table>
		<hr>
		<a href="modifyForm?id=${userInfo.id}">수정하기</a>
	</div>

	<c:import url="../default/footer.jsp" />
</body>
</html>