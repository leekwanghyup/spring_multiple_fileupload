<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">	
		<h2>첨부파일 여러개 파일 업로드</h2>	
	</div>
	<div class="card">
		<div class="card-header">
			<span class="badge badge-primary">번호 ${b.bno}</span>
			<span class="badge badge-info">${b.writer}</span>
			<span class="ml-3">${b.title}</span>
		</div>
		<div class="card-body" style="min-height:350px">
			${b.title}
		</div>
		<div class="card-footer">Footer</div>
	</div>
	
	<c:if test="${not empty attachList}">
		<c:forEach items="${attachList}" var="attach">
			<c:if test="${attach.fileType == 'IMAGE'}">
				<div class="media border p-3 my-2">
					<div class="media-body d-flex justify-content-between">
						<div>
							<img src="${contextPath}/resources/images/fileicon.png" style="width:20px;">
							${attach.fileName}
						</div>
						<div>
							<a href="#" class="btn btn-primary">다운로드</a>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${attach.fileType == 'OTHER' }">
				<div class="media border p-3 my-2">
					<div class="media-body d-flex justify-content-between">
						<div>
							<img src="${contextPath}/resources/images/fileicon.png" style="width:20px;">
							${attach.fileName}
						</div>
						<div>
							<a href="#" class="btn btn-primary">다운로드</a>
						</div>
					</div>
				</div>
			</c:if>	
		</c:forEach>
	</c:if>
	<c:if test="${empty attachList}">
		<div class="media border p-3 my-2">
			<div class="media-body">
				<b>등록된 첨부파일이 없습니다.</b>
			</div>
		</div>
	</c:if>
	
</div>
<%@ include file="../layout/footer.jsp" %>


