<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>vvsos1's Blog</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

</head>

<!-- 웹페이지 처음 로딩때도 세션이 있는지 확인-->

<body>

	<!-- NavBar -->
	<%@include file="nav.jsp"%>


	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="container"
		style="border-radius: .3rem; padding: 10rem 2rem; transform: scale(1.2);">
		<div class="articleList">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성 날짜</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="article" items="${ result.article }"
						varStatus="status">
						<tr>
							<th scope="row">${status.count }</th>
							<td><a
								href="${contextPath }/freeboard/read.do?number=${article.number}">${article.title }</a></td>
							<td>${article.writer.id }</td>
							<td>${article.regDate }</td>
							<td>${article.readCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="pagination" style="display: inline;">
			<c:if test="${ result != null }">
				<ul class="pagination justify-content-center">
					<c:if test="${ result.currentPage > 1 }">
						<li class="page-item"><a class="page-link"
							href="${contextPath}/freeboard/list.do?page=${ result.currentPage - 1}"
							tabindex="-1">Previous</a></li>
					</c:if>
					<c:if test="${ result.currentPage == 1 }">
						<li class="page-item disabled"><a class="page-link"
							tabindex="-1">Previous</a></li>
					</c:if>
					<c:forEach var="item" begin="1" end="${ result.totalPage }"
						varStatus="status">
						<c:if test="${ status.count == result.currentPage }">
							<li class="page-item active"><a class="page-link"
								href="${contextPath}/freeboard/list.do?page=${ status.count}">${status.count}</a></li>
						</c:if>
						<c:if test="${ status.count != result.currentPage }">
							<li class="page-item"><a class="page-link"
								href="${contextPath}/freeboard/list.do?page=${ status.count}">${status.count}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${ result.currentPage >= result.totalPage  }">
						<li class="page-item disabled"><a class="page-link"
							tabindex="-1">Next</a></li>
					</c:if>
					<c:if test="${ result.currentPage < result.totalPage }">
						<li class="page-item"><a class="page-link"
							href="${contextPath}/freeboard/list.do?page=${ result.currentPage + 1}"
							tabindex="-1">Next</a></li>
					</c:if>
				</ul>
			</c:if>
		</div>
		<button type="button" class="btn btn-dark"
			onclick="location.href='${contextPath}/freeboard/write.do'"
			style="transform: scale(0.8); float: right; display: inline;">글쓰기</button>
	</div>

	<hr>

</body>

</html>