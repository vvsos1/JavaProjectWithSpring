<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="regModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">회원가입</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<!--Modal 회원가입 폼-->
			<form name="regForm" id="regForm">
				<div class="modal-body">
					<!--아이디-->
					<div class="form-group">
						<label for="id1">아이디</label> <input type="text"
							class="form-control" id="id1" placeholder="Enter ID" name="id"
							required>
					</div>
					<!--비밀번호-->
					<div class="form-group">
						<label for="password1">비밀번호</label> <input type="password"
							class="form-control" id="password1" placeholder="Password"
							name="password" required>
					</div>
					<!--반-->
					반 &nbsp; <select class="custom-select mb-2 mr-sm-2 mb-sm-0"
						name="class1">
						<option value="1">1반</option>
						<option value="2">2반</option>
						<option value="3">3반</option>
						<option value="4">4반</option>
						<option value="5">5반</option>
						<option value="6">6반</option>
					</select> <br> <br>
					<!--학년-->
					학년 &nbsp; <label class="custom-control custom-radio"> <input
						id="radio1" name="grade1" type="radio" class="custom-control-input"
						value="1" checked> <span class="custom-control-indicator"></span>
						<span class="custom-control-description">1학년</span>
					</label> <label class="custom-control custom-radio"> <input
						id="radio2" name="grade1" type="radio" class="custom-control-input"
						value="2"> <span class="custom-control-indicator"></span>
						<span class="custom-control-description">2학년</span>
					</label> <label class="custom-control custom-radio"> <input
						id="radio3" name="grade1" type="radio" class="custom-control-input"
						value="3"> <span class="custom-control-indicator"></span>
						<span class="custom-control-description">3학년</span>
					</label>
					<!--번호-->
					<div class="form-group">
						<label class="form-control-label" for="studentId1">번호</label> <input
							type="number" class="form-control" id="studentId1" name="studentId"
							required>
					</div>
					<!--이름-->
					<div class="form-group">
						<label class="form-control-label" for="studentName1">이름</label> <input
							type="text" class="form-control" id="studentName1"
							name="studentName" required>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="submit" class="btn btn-primary">가입하기</button>
				</div>
			</form>
		</div>
	</div>
</div>