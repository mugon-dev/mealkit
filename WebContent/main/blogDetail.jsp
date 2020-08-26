<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section class="login_part section_padding ">
	<div class="container">
		<div class="row align-items-center">
			<form class="row contact_form" name="form" method="post" > 
				<input type="hidden" name="session_id" value="${session_id }"/>
				<input type="hidden" name="milNo" value="${blog.milNo }" />
				<input type="hidden" name="image" value="${blog.image }" />
				<input type="hidden" name="test" value="1" />
				<div class="col-lg-6 col-md-6">
					<div class="login_part_text text-center" >
						<div class="login_part_text_iner">
							<img src="images/${blog.image }" width="450" height="300">
							<p></p><p></p><br>
							<h2>No.${blog.milNo } ${blog.id }님의 레시피 <br>${blog.title }</h2>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="login_part_form">
						<div class="login_part_form_iner">
							<div class="col-md-12 form-group p_star" >
								<div class="row">
									제목: &nbsp;<input type="text" id="title" name="title" class="form-control" value="${blog.title }" >
								</div>
							</div>
							<div class="col-md-12 form-group p_star" >
								<div class="row">
									음식 종류: &nbsp;&nbsp;
									<select name="cookIdx" data-trigger="" name="choices-single-defaul">
										<c:choose>
											<c:when test="${blog.cookIdx == 1 }"> 
												<option value="1" selected>한식</option>
												<option value="2">중식</option>
												<option value="3">일식</option>
												<option value="4">양식</option>
											</c:when>
											<c:when test="${blog.cookIdx == 2 }"> 
												<option value="1">한식</option>
												<option value="2" selected>중식</option>
												<option value="3">일식</option>
												<option value="4">양식</option>
											</c:when>
											<c:when test="${blog.cookIdx == 3 }"> 
												<option value="1">한식</option>
												<option value="2">중식</option>
												<option value="3" selected>일식</option>
												<option value="4">양식</option>
											</c:when>
											<c:when test="${blog.cookIdx == 4 }"> 
												<option value="1">한식</option>
												<option value="2">중식</option>
												<option value="3">일식</option>
												<option value="4" selected>양식</option>
											</c:when>
										</c:choose>
									</select>
									&nbsp;&nbsp; 조리 방식: &nbsp;&nbsp;
									<select name="cookType" data-trigger="" name="choices-single-defaul">
										<c:choose>
											<c:when test="${blog.cookType == 1 }"> 
												<option value="1" selected>구이</option>
												<option value="2">찜</option>
												<option value="3">탕</option>
												<option value="4">생식</option>
												<option value="5">기타</option>
											</c:when>
											<c:when test="${blog.cookType == 2 }"> 
												<option value="1">구이</option>
												<option value="2" selected>찜</option>
												<option value="3">탕</option>
												<option value="4">생식</option>
												<option value="5">기타</option>
											</c:when>
											<c:when test="${blog.cookType == 3 }"> 
												<option value="1">구이</option>
												<option value="2">찜</option>
												<option value="3" selected>탕</option>
												<option value="4">생식</option>
												<option value="5">기타</option>
											</c:when>
											<c:when test="${blog.cookType == 4 }"> 
												<option value="1">구이</option>
												<option value="2">찜</option>
												<option value="3">탕</option>
												<option value="4" selected>생식</option>
												<option value="5">기타</option>
											</c:when>
											<c:when test="${blog.cookType == 5 }"> 
												<option value="1">구이</option>
												<option value="2">찜</option>
												<option value="3">탕</option>
												<option value="4">생식</option>
												<option value="5" selected>기타</option>
											</c:when>
										</c:choose>
									</select>
								</div>
							</div>
							<div class="col-md-12 form-group p_star" >
								<div class="row">
									인원 수: &nbsp;&nbsp;
									<select name="plate" data-trigger="" name="choices-single-defaul">
										<c:choose>
											<c:when test="${blog.plate == 1 }"> 
												<option value="1" selected>1~2인</option>
												<option value="2">3~4인</option>
												<option value="3">5인 이상</option>
											</c:when>
											<c:when test="${blog.plate == 2 }"> 
												<option value="1">1~2인</option>
												<option value="2" selected>3~4인</option>
												<option value="3">5인 이상</option>
											</c:when>
											<c:when test="${blog.plate == 3 }"> 
												<option value="1">1~2인</option>
												<option value="2">3~4인</option>
												<option value="3" selected>5인 이상</option>
											</c:when>
										</c:choose>
									</select>
									&nbsp;&nbsp; 조리시간: &nbsp;&nbsp;
									<select name="hour" data-trigger="" name="choices-single-defaul">
										<c:choose>
											<c:when test="${blog.hour == 1 }"> 
												<option value="1" selected>1시간 이하</option>
												<option value="2">2시간 이하</option>
												<option value="3">2시간 이상</option>
											</c:when>
											<c:when test="${blog.hour == 2 }"> 
												<option value="1">1시간 이하</option>
												<option value="2" selected>2시간 이하</option>
												<option value="3">2시간 이상</option>
											</c:when>
											<c:when test="${blog.hour == 3 }"> 
												<option value="1">1시간 이하</option>
												<option value="2">2시간 이하</option>
												<option value="3" selected>2시간 이상</option>
											</c:when>
										</c:choose>
									</select>
								</div>
							</div>
							
							<div class="col-md-12 form-group p_star">
								<div class="row">
									난이도: &nbsp;&nbsp;
									<select name="level" data-trigger="" name="choices-single-defaul">
										<c:choose>
											<c:when test="${blog.level == 1 }"> 
												<option value="1" selected>상</option>
												<option value="2">중</option>
												<option value="3">하</option>
											</c:when>
											<c:when test="${blog.level == 2 }"> 
												<option value="1">상</option>
												<option value="2" selected>중</option>
												<option value="3">하</option>
											</c:when>
											<c:when test="${blog.level == 3 }"> 
												<option value="1">상</option>
												<option value="2">중</option>
												<option value="3" selected>하</option>
											</c:when>
										</c:choose>
									</select>
								</div>
							</div>
							<div class="col-md-12 form-group p_star">
								<div class="row">
									<div class="col-md-3 form-group">
										재료1:
									</div>
									<div class="col-md-3 form-group">
										<div class="input-select">
											<!-- 여기서 재료 리스트 받아서 forEach로 입력 -->
											<select name="matNo1" data-trigger="" name="choices-single-defaul">
												<option selected value="0" > 선택1 </option>
												<c:forEach items="${list }" var="list">
												<c:if test="${list.mat_no==blog.matNo1 }">
													<option value="${list.mat_no }" selected>${list.mat_nm }</option>
												</c:if>
												<c:if test="${list.mat_no!=blog.matNo1 }">
													<option value="${list.mat_no }">${list.mat_nm }</option>
												</c:if>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3 form-group">
										수량1: 
									</div> 
									<div class="col-md-3 form-group">
										<input type="text" id="matQty1" name="matQty1" value="${blog.matQty1 }" class="form-control">
									</div>
								</div>
								<div class="row">
									<div class="col-md-3 form-group">
										재료2: 
									</div>
									<div class="col-md-3 form-group">
										<div class="input-select">
											<!-- 여기서 재료 리스트 받아서 forEach로 입력 -->
											<select name="matNo2" data-trigger="" name="choices-single-defaul">
												<option selected value="0" > 선택2 </option>
												<c:forEach items="${list2 }" var="list">
												<c:if test="${list.mat_no == blog.matNo2 }">
													<option value="${list.mat_no }" selected>${list.mat_nm }</option>
												</c:if>
												<c:if test="${list.mat_no!=blog.matNo2 }">
													<option value="${list.mat_no }">${list.mat_nm }</option>
												</c:if>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3 form-group">
										수량2:
									</div> 
									<div class="col-md-3 form-group">
										<input type="text" id="matQty2" name="matQty2" value="${blog.matQty2 }" class="form-control">
									</div>
								</div>
								<div class="row">
									<div class="col-md-3 form-group">
										재료3:
									</div>
									<div class="col-md-3 form-group">
										<div class="input-select">
											<!-- 여기서 재료 리스트 받아서 forEach로 입력 -->
											<select name="matNo3" data-trigger="" name="choices-single-defaul">
												<option selected value="0" > 선택3 </option>
												<c:forEach items="${list3 }" var="list">
												<c:if test="${list.mat_no==blog.matNo3 }">
													<option value="${list.mat_no }" selected>${list.mat_nm }</option>
												</c:if>
												<c:if test="${list.mat_no!=blog.matNo3 }">
													<option value="${list.mat_no }">${list.mat_nm }</option>
												</c:if>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-3 form-group">
										수량3: 
									</div> 
									<div class="col-md-3 form-group">
										<input type="text" id="matQty3" name="matQty3" value="${blog.matQty3 }" class="form-control">
									</div>
								</div>
							</div>
							<div class="col-md-12 form-group p_star">
								기타 재료: <input type="text" id="matEtc" name="matEtc" value="${blog.matEtc }" class="form-control">
							</div>
							<div class="col-md-12 form-group p_star">
								내용: <textarea type="text" class="form-control" name="content" id="content" rows="5"> ${blog.content } </textarea>
							</div>
							
							<div class="col-md-12 from-froup p_star" >
								<div class="row">
									<c:if test="${session_no == blog.no }"> 
										<div class="col-md-4 form-group">
											<button type="submit" id="btnUpdate" name="btnUpdate" class="btn_3" onclick="javascript: form.action='updateBlog.do';form.enctype='multipart/form-data'">수정</button>
										</div>
										<div class="col-md-4 form-group">
											<button type="button" id="btnDelete" name="btnDelete" class="btn_3" onclick="location.href='deleteBlog.do?milNo=${blog.milNo }'">삭제</button>
										</div>
									</c:if>
									<div class="col-md-4 form-group">
										<button type="submit" id="btnCart" name="btnCart" class="btn_3" onclick="javascript: form.action='cart.do'">구매</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<!-- 리플 -->
			
			<form name="form" action='replyAdd.do' > 
				<input type="hidden" name="no" value="${session_no }"/>
				<input type="hidden" name="milNo" value="${blog.milNo }"/>
				<div class="comments-area" id="replylist" >
					<h4> ${blog.replyCount } Comments</h4>
					<div class="comment-list">
						<div class="single-comment justify-content-between d-flex">
							<div class="user justify-content-between d-flex">
								<div class="thumb"> </div>
								<div class="desc">
									<c:forEach items="${replyList }" var="replyList">
										<h3> ${replyList.id } </h3> 
										<p class="comment" name="reply" id="reply"> ${replyList.replys }" </p>
										<div class="d-flex justify-content-between">
											<div class="d-flex align-items-center">
												<h5><a href="#">${replyList.no }</a></h5>
												<p class="date">${replyList.rgstDt }</p>
											</div>
											<div class="reply-btn">
												<a href="replyDelete.do?reNo=${replyList.reNo }&milNo=${replyList.milNo }" class="btn-reply text-uppercase">삭제</a>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<p><p><br>
						<div class="col-12"><!-- 리플입력폼 -->
							<div class="form-group">
								<textarea class="form-control w-100" name="replys" id="replys" cols="30" rows="9" placeholder="Write Comment"></textarea>
							</div>
						</div>
						<div class="form-group">
							<button type="submit" id="btnReplyAdd" name="btnRelpyAdd" class="button button-contactForm btn_1 boxed-btn" onclick="javascript: form.action='replyAdd.do';">Send Message</button>
						</div><!-- 리플입력폼 끝-->
					</div>
				</div> 
			</form>
		</div> <!-- 리플 끝 -->
	</div>
	
</section>

<script type="text/javascript">

</script>
<%@ include file="../include/footer.jsp"%>