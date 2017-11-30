<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="myInfoModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">내 정보</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<!--Modal 회원가입 폼-->
			<form name="myInfoForm" id="myInfoForm">
				<div class="modal-body">
					<!--아이디-->
					<div class="form-group">
						<label for="id">아이디</label> <input type="text"
							class="form-control" id="id2" placeholder="Enter ID" name="id"
							required readonly="readonly" value="${user.id }">
					</div>
					<!--현재 비밀번호-->
					<div class="form-group">
						<label for="password">현재 비밀번호</label> <input type="password"
							class="form-control" id="oldPassword" placeholder="Password"
							name="oldPassword" required>
					</div>
					<!--신규 비밀번호-->
					<div class="form-group">
						<label for="password">신규 비밀번호</label> <input type="password"
							class="form-control" id="newPassword" placeholder="Password"
							name="newPassword">
					</div>
					<!--반-->
					반 &nbsp; <select class="custom-select mb-2 mr-sm-2 mb-sm-0"
						name="class2">
						<c:forEach var="i" begin="1" end="6">
							<c:if test="${user.classroom eq i }">
								<option value="${i }" selected="selected">${i }반</option>
							</c:if>
							<c:if test="${user.classroom ne i }">
								<option value="${i }">${i }반</option>
							</c:if>
						</c:forEach>

					</select> <br> <br>
					<!--학년-->
					학년 &nbsp;
					<c:forEach var="i" begin="1" end="3">
						<c:if test="${user.grade eq i }">
							<label class="custom-control custom-radio"> <input
								id="radio${i }" name="grade2" type="radio"
								class="custom-control-input" value="${i }" checked> <span
								class="custom-control-indicator"></span> <span
								class="custom-control-description">${i }학년</span>
							</label>
						</c:if>
						<c:if test="${user.grade ne i }">
							<label class="custom-control custom-radio"> <input
								id="radio${i }" name="grade2" type="radio"
								class="custom-control-input" value="${i }"> <span
								class="custom-control-indicator"></span> <span
								class="custom-control-description">${i }학년</span>
							</label>
						</c:if>
					</c:forEach>
					<!--번호-->
					<div class="form-group">
						<label class="form-control-label" for="studentId">번호</label> <input
							type="number" class="form-control" id="studentId2" name="studentId"
							required value="${user.number }">
					</div>
					<!--이름-->
					<div class="form-group">
						<label class="form-control-label" for="studentName">이름</label> <input
							type="text" class="form-control" id="studentName2"
							name="studentName" required value="${user.name }">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">닫기</button>
					<button type="submit" class="btn btn-primary">수정하기</button>
				</div>
			</form>
		</div>
	</div>
</div>