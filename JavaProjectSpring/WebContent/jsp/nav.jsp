<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<li class="nav-item"><a class="nav-link "
				href="${contextPath}/freeboard/list.do">Board</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${contextPath}/jsp/chatting.jsp">Chatting</a></li>
			<li class="nav-item"><a class="nav-link "
				href="${contextPath}/file/list.do">Download</a></li>
		</ul>

		<div>

			<c:if test="${sessionScope.user != null }">
					${sessionScope.user.name }님 로그인 중
					<button class="btn btn-outline-dark" data-toggle="modal"
					data-target="#myInfoModal">MyPage</button>
				<button type="submit" class="btn btn-outline-dark"
					onclick="logout()">Logout</button>
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
	
</nav>