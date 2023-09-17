<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드작성</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/root/resources/board/js/writeForm.js" type="text/javascript" ></script>
<link href="/root/resources/board/css/writeForm.css" rel="stylesheet">
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
	<c:import url="../default/header.jsp" />
		<div id="Con">
			<div>
				<h1>글쓰기</h1>
			</div>
			<div>
				<form action="writeSave" method="post" enctype="multipart/form-data">
					<label for="id">작성자</label><br>
					<input id="id" name="id" value="${user}" type="text" readonly>
					<hr>
					
					<label for="title">제목</label><br>
					<input id="title" name="title" type="text">
					<hr>
					
					<label for="content">내용</label><br>
					<textarea rows="18" cols="60" name="content" id="content"></textarea>
					<hr>
					
					<b>이미지파일 첨부</b><br>
					<input type="file" name="imageFileName" onchange="readURL(this)"/><br>
					<img id="preview" src="" width=100 height=100 alt="선택된 이미지가 없습니다" /><br>
					<hr>
					<input type="submit" value="글쓰기">
					<button type="button" onclick="list()">목록보기</button>
					
				</form>
				
			</div>
		</div>
	<c:import url="../default/footer.jsp" />

</body>
</html>