<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="common.jsp"%>
<title>vvsos1's Blog</title>
</head>

<body>

	<!-- NavBar -->
	<%@include file="nav.jsp"%>


	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">

			<iframe
				src="http://<%=request.getLocalAddr() %>:9000/html/chatting.html?ID=${user.id}"
				width="800px" height="510px" style="border: 0"></iframe>
		</div>
	</div>

	<hr>

</body>

</html>