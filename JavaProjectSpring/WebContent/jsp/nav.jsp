<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<script>
	var contextPath = '${contextPath}'
</script>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-md navbar-light fixed-top bg-light">
	<a class="navbar-brand" href="index.html">Blog</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="${contextPath}/jsp/index.jsp">Home <span class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="${contextPath}/jsp/hobby.jsp">Hobby</a></li>
			<li class="nav-item"><a class="nav-link "
				href="${contextPath}/freeboard/list.do">Board</a></li>
			<li class="nav-item"><a class="nav-link "
				href="${contextPath}/jsp/dream.html">Dream</a></li>
		</ul>

		<div>

			<c:if test="${sessionScope.user != null }">
					${sessionScope.user.name }님 로그인 중
					<button class="btn btn-outline-dark" data-toggle="modal"
					data-target="#myInfoModal">MyPage</button>
					<button type="submit" class="btn btn-outline-dark" onclick="logout()">Logout</button>
			</c:if>
			<c:if test="${sessionScope.user == null }">
				<form class="form-inline my-2 my-lg-0" id="loginForm"
					style="display: inline;">
					<input class="form-control mr-sm-2" type="text" placeholder="ID"
						aria-label="id" id="loginId" name="id" required> <input
						class="form-control mr-sm-2" type="password"
						placeholder="Password" aria-label="Password" id="loginPassword"
						name="pwd" required>
					<button class="btn btn-outline-dark" type="submit">Login</button>
					&nbsp;
				</form>
				<button class="btn btn-outline-dark" data-toggle="modal"
					data-target="#regModal">Sign Up</button>
			</c:if>
		</div>

	</div>
	<script src="${contextPath }/js/myblog.js"></script>
</nav>

<!-- 회원가입 Modal -->
<%@include file="regModal.jsp"%>
<!-- Alert Modal-->
<%@include file="alertModal.jsp"%>
<!-- 내 정보 Modal -->
<%@include file="myInfoModal.jsp"%>
<c:if test="${ error != null }">
	<script>
		alertModal('error', "${error.message}");
	</script>
</c:if>