<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아직도 한가득 남았네</title>
<style type="text/css">
	#Con {
		margin-left: 1000px;
	}
</style>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
	<c:import url="../default/header.jsp" />
	<div id="Con">
		<div>
			<h1>개인 정보</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th>글번호</th>
					<td>${content.number}</td>
					<th>작성자</th>
					<td>${content.id}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${content.title}</td>
					<th>등록일자</th>
					<td>${content.boarddate}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${content.content}</td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="4">
						<button type="button">수정하기</button>
						<button type="button">삭제하기</button>
						<button type="button">답글달기</button>
						<button type="button">리스트로 돌아가기</button>
					</td>
				</tr>
			</table>	
		</div>
	</div>
	<c:import url="../default/footer.jsp" />
</body>
</html>