<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h2>게시물 목록</h2>
	</div>
	<table class="table">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
		</tr>
		<c:forEach items="${list}" var="b">
		<tr>
			<td>${b.bno}</td> 
			<td>
				<a href="detail?bno=${b.bno}">${b.title}</a>
			</td>
			<td>${b.writer}</td>
		</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../layout/footer.jsp" %>