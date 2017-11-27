<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

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

<body>

	<!-- NavBar -->
	<%@include file="nav.jsp"%>


	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="container"
		style="border-radius: .3rem; padding: 10rem 2rem; transform: scale(1.2);">
		<form method="post" action="${contextPath }/freeboard/modify.do">
			<input type="hidden" name="articleNumber" value="${article.article.number}">
			<div class="form-group">
				<label for="exampleFormControlInput1">제목</label> <input
					type="text" class="form-control" id="exampleFormControlInput1"
					placeholder="title" name="title" value="${article.article.title }">
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">내용</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="15" name="content">${article.articleContent.content }</textarea>
			</div>
			<button type="submit" class="btn btn-dark">수정하기</button>
		</form>

	</div>

	<hr>

</body>

</html>