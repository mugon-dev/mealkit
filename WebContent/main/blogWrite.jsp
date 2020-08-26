<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section class="login_part section_padding ">
	<div class="container">
		<div class="row align-items-center">
			<form class="row contact_form" action="blogWrite.do" method="post" enctype="multipart/form-data"> 
				<c:if test="${session_no == 1}" >
					<input type="hidden" name="recIdx" value="1">
				</c:if>
				<c:if test="${session_no != 1}" >
					<input type="hidden" name="recIdx" value="2">
				</c:if>
				<input type="hidden" name="no" value="${session_no }" >
				
				<div class="col-lg-6 col-md-6">
					<div class="login_part_text text-center" >
						<div class="login_part_text_iner">
							<div class="col-xs-10 col-lg-10">
								<input type="file" id="filename" name="filename" class="form-control" >
							</div>
							<p></p><p></p><br>
							<h2>레시피의 사진을 등록해보세요</h2>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="login_part_form">
						<div class="login_part_form_iner">
							<div class="col-md-12 form-group p_star" >
								<div class="row">
									제목: &nbsp;<input type="text" id="title" name="title" class="form-control">
								</div>
							</div>
							<div class="col-md-12 form-group p_star" >
								<div class="row">
									음식 종류: &nbsp;&nbsp;
									<select name="cookIdx" data-trigger="" name="choices-single-defaul">
										<option value="1" selected>한식</option>
										<option value="2">중식</option>
										<option value="3">일식</option>
										<option value="4">양식</option>
									</select>
									&nbsp;&nbsp; 조리 방식: &nbsp;&nbsp;
									<select name="cookType" data-trigger="" name="choices-single-defaul">
										<option value="1" selected>구이</option>
										<option value="2">찜</option>
										<option value="3">탕</option>
										<option value="4">생식</option>
										<option value="5">기타</option>
									</select>
								</div>
							</div>
							<div class="col-md-12 form-group p_star" >
								<div class="row">
									인원 수: &nbsp;&nbsp;
									<select name="plate" data-trigger="" name="choices-single-defaul">
										<option value="1" selected>1~2인</option>
										<option value="2">3~4인</option>
										<option value="3">5인 이상</option>
									</select>
									&nbsp;&nbsp; 조리시간: &nbsp;&nbsp;
									<select name="hour" data-trigger="" name="choices-single-defaul">
										<option value="1" selected>1시간 이하</option>
										<option value="2">2시간 이하</option>
										<option value="3">2시간 이상</option>
									</select>
								</div>
							</div>
							
							<div class="col-md-12 form-group p_star">
								<div class="row">
									난이도: &nbsp;&nbsp;
									<select name="level" data-trigger="" name="choices-single-defaul">
										<option value="1" selected>상</option>
										<option value="2">중</option>
										<option value="3">하</option>
									</select>
								</div>
							</div>
							<div class="col-md-12 form-group p_star">
								<div class="row">
									<div class="col-md-3 form-group">
										재료1:
									</div>
									
									<div class="col-md-3 form-group">
										<div class="input-select" >
											<select name="matNo1" data-trigger="" >
												<option selected disabled value="0" > 선택1 </option>
												<c:forEach items="${list }" var="list">
												<option value="${list.mat_no }">${list.mat_nm }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3 form-group">
										수량1: 
									</div> 
									<div class="col-md-3 form-group">
										<input type="text" id="matQty1" name="matQty1" class="form-control" value="0">
									</div>
								</div>
								<div class="row">
									<div class="col-md-3 form-group">
										재료2: 
									</div>
									<div class="col-md-3 form-group">
										<div class="input-select">
											<select name="matNo2" data-trigger="" >
												<option selected value="0" > 선택2 </option>
												<c:forEach items="${list }" var="list">
													<option value="${list.mat_no }">${list.mat_nm }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3 form-group">
										수량2:
									</div> 
									<div class="col-md-3 form-group">
										<input type="text" id="matQty2" name="matQty2" class="form-control" value="0">
									</div>
								</div>
								<div class="row">
									<div class="col-md-3 form-group">
										재료3:
									</div>
									<div class="col-md-3 form-group">
										<div class="input-select">
											<select name="matNo3" data-trigger="">
												<option selected value="0" > 선택3 </option>
												<c:forEach items="${list }" var="list">
													<option value="${list.mat_no }">${list.mat_nm }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3 form-group">
										수량3: 
									</div> 
									<div class="col-md-3 form-group">
										<input type="text" id="matQty3" name="matQty3" class="form-control" value="0">
									</div>
								</div>
							</div>
							<div class="col-md-12 form-group p_star">
								기타 재료: <input type="text" id="matEtc" name="matEtc" class="form-control">
							</div>
							<div class="col-md-12 form-group p_star">
								내용: <textarea type="text" class="form-control" id="content" rows="5" name="content"> </textarea>
							</div>
							<div class="col-md-12 from-froup p_star" >
								<div class="row">
									<div class="col-md-4 form-group">
										<button type="submit" id="btnInsert" class="btn_3">등록</button>
									</div>
									<div class="col-md-4 form-group">
										<button type="reset" id="btnReset" class="btn_3">취소</button>
									</div>
									<div class="col-md-4 form-group">
										<button type="button" id="btnBlog" class="btn_3">목록</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>

<script type="text/javascript">
	$("#btnInsert").on('click', function(){
		var title = $("#title").val();
		if(title == "") {
			alert("title을 입력하세요");
			$("title").focus();
			return false;
		}
		return true;
	});
	$("#btnBlog").on('click', function(){
		location.href = "blogForm.do";
	});
</script>

<%@ include file="../include/footer.jsp"%>