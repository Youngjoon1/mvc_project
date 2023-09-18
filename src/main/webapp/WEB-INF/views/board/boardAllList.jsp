<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
<style type="text/css">
	#Con {
		margin-left: 1000px;
	}
	#title {
		text-align: center;
	}
</style>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
	<c:import url="../default/header.jsp" />
	<div>
		<div id="title">
			<h1>게시판</h1><br>
		</div>
		<div>
			<table border="1" id="Con">
				<tr>
					<th>번호</th>
					<th>id</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
					<th>image_file_name</th>
				</tr>
				<c:choose>
					<c:when test="${list.size() == 0}">
						<tr>
							<th colspan="6">등록된 글이 없습니다.</th>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="bList" items="${list}">
								<tr>
									<td>${bList.number}</td>
									<td>${bList.id}</td>
									<td><a href="contentView?number=${bList.number}">${bList.title}</a></td>
									<td>${bList.boarddate}</td>
									<td>${bList.hit}</td>
									<td>${bList.imageFileName}</td>
								</tr>
						</c:forEach>	
					</c:otherwise>
				</c:choose>
				
				<tr>
					<th colspan="6"><a href="${contextPath}/board/writeForm">글작성</a></th>
				</tr>
			</table>
		</div>
	</div>
	<c:import url="../default/footer.jsp" />
	
</body>
</html>