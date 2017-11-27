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
	<div role="main" class="container"
		style="border-radius: .3rem; padding: 10rem 2rem; transform: scale(1.2); align: center;">

		<div class="row">

			<div class="col-sm-8 blog-main">

				<div class="blog-post">
					<h2 class="blog-post-title">${result.article.title }</h2>
					<p class="blog-post-meta">
						${result.article.regDate } by <a href="#">${result.article.writer.id }</a>
					</p>

					<p>${result.articleContent.content }</p>
				</div>
				<!-- /.blog-post -->

				<nav class="blog-pagination">
					<c:if test="${result.previousNumber != 0 }">
						<a class="btn btn-outline-primary"
							href="${contextPath }/freeboard/read.do?number=${result.previousNumber }">Older</a>
					</c:if>
					<c:if test="${result.nextNumber != 0 }">
						<a class="btn btn-outline-primary"
							href="${contextPath }/freeboard/read.do?number=${result.nextNumber }">Newer</a>
					</c:if>
				</nav>
				<button type="button" class="btn btn-dark"
					onclick="location.href='${contextPath }/freeboard/modify.do?articleNumber=${result.article.number}'"
					style="transform: scale(0.8); float: right; display: inline;">수정하기</button>
				<button type="button" class="btn btn-dark"
					onclick="location.href='${contextPath }/freeboard/delete.do?articleNumber=${result.article.number}'"
					style="transform: scale(0.8); float: right; display: inline;">삭제하기</button>
			</div>
			<!-- /.blog-main -->

		</div>
		<!-- /.row -->
	</div>

	<hr>

</body>

</html>