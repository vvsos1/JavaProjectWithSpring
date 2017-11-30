<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" href="${contextPath }/css/bootstrap.min.css" />

<script>
	var contextPath = '${contextPath}'
</script>

<script src="${contextPath }/js/jquery-3.2.1.min.js"></script>
<script src="${contextPath }/js//popper.min.js"></script>
<script src="${contextPath }/js/bootstrap.min.js"></script>
<script src="${contextPath }/js/myblog.js"></script>
<!-- 회원가입 Modal -->
<%@include file="regModal.jsp"%>
<!-- Alert Modal-->
<%@include file="alertModal.jsp"%>
<!-- 내 정보 Modal -->
<%@include file="myInfoModal.jsp"%>
<c:if test="${ error != null }">
	<script>
		alertModal('error', "${error}");
	</script>
</c:if>