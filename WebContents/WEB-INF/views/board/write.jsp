<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">	
		<h2>첨부파일 여러개 파일 업로드</h2>	
	</div>
	<form action="${contextPath}/board/write" enctype="multipart/form-data" method="post">
		<input type="text" name="title" class="form-control" placeholder="제목">
		<textarea rows="10" name="content" class="form-control" placeholder="내용"></textarea>
		<input type="text" name="writer" class="form-control" placeholder="작성자">
		<div class="fileForm my-2">
			<div>
				<button type="button" class="btn btn-info add">폼추가</button>
				<button type="button" class="btn btn-danger del">폼삭제</button>
			</div>
			<input type="file" name="attachFile" class="form-control attachFile">
		</div>
		
		<button class="btn btn-primary btn-xs">전송</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp" %>


