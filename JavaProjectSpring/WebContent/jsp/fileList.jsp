<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="common.jsp"%>
<title>vvsos1's Blog</title>


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
						<th scope="col">${param.uploader }</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="file" items="${ result }" varStatus="status">
						<tr>
							<th scope="row">${status.count }</th>
							<td><a download="${file }"
								href="http://<%=request.getLocalAddr() %>:9000/?mode=fileDownload&fileUploader=${param.uploader}&fileName=${file}&requester=${user.id}">${file}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

	<hr>

</body>

</html>