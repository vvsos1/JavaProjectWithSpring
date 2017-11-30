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

<%@include file="common.jsp"%>
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
						<th scope="col">업로더</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="uploader" items="${ result }"
						varStatus="status">
						<tr>
							<th scope="row">${status.count }</th>
							<td><a
								href="${contextPath }/file/list.do?uploader=${uploader}">${uploader}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
	</div>

	<hr>

</body>

</html>