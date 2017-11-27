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
	<div class="jumbotron">
		<div class="container">
			<form action="${contextPath }/upload.do" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="exampleFormControlFile1">File 1</label> <input
						type="file" class="form-control-file" id="exampleFormControlFile1"
						name="file1" required="required"> <label
						for="exampleFormControlFile2">File 2</label> <input type="file"
						class="form-control-file" id="exampleFormControlFile2"
						name="file2" required="required">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>

	<hr>

</body>

</html>