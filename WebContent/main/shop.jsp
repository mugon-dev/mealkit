<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section class="popular-items latest-padding">
	<div class="container">
		<div class="row product-btn " style="height: 60px">
			<div
				class="properties__button justify-content-between mb-40 col-lg-5">
				<!--Nav Button  -->
				<nav>
					<div class="nav nav-tabs" id="nav-tab" role="tablist">
						<a class="nav-item nav-link active" id="nav-tab0"
							data-toggle="tab" href="#type1_0" role="tab" aria-controls="nav0"
							aria-selected="true">전체</a>

						<c:forEach var="type1" begin="1" end="4" varStatus="loop">
							<c:choose>
								<c:when test="${loop.count==1 }">
									<c:set var="cook_idx" value="한식"/>
								</c:when>
								<c:when test="${loop.count==2 }">
									<c:set var="cook_idx" value="중식"/>
								</c:when>
								<c:when test="${loop.count==3 }">
									<c:set var="cook_idx" value="일식"/>
								</c:when>
								<c:when test="${loop.count==4 }">
									<c:set var="cook_idx" value="양식"/>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
							<a class="nav-item nav-link" id="nav-tab${loop.count }"
								data-toggle="tab" href="#type1_${loop.count }" role="tab"
								aria-controls="nav${loop.count }" aria-selected="false">${cook_idx }</a>
						</c:forEach>

					</div>
				</nav>
			</div>
			<div class="col-lg-4"></div>
			<!-- Header Right -->
			<div class="col-lg-3">
				<div class="dropdown show" style="color: black;">
					<div class="dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">관리자 메뉴</div>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="MyPageForm.do">Mealkit 등록</a>
					</div>

				</div>

			</div>

			<!--End Nav Button  -->
		</div>
	</div>


	<div class="container">
		<div class="tab-content" id="nav-tabContent">
			<!-- 한식 -->
			<div class="tab-pane fade show active" id="type1_0" role="tabpanel"
				aria-labelledby="nav0">
				<div><span style="font-size:30px;color:'BLUE';">MD추천</span>&nbsp;<span style="font-size:10px;color:'GRAY'"><a href="shop.do">|+더보기|</a></span></div>
				<div class="row">
					<c:forEach var="recipe" items="${recipe }">
						<c:if test="${recipe.rec_idx == 1 }">
							<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
								<div class="single-popular-items mb-50 text-center">
									<div class="popular-img">
										<img src="images/${recipe.image }" alt="">
										<div class="img-cap">
											<span>Add to cart</span>
										</div>
										<div class="favorit-items">
											<span class="flaticon-heart"></span>
										</div>
									</div>
									<div class="popular-caption">
										<h3>
											<a href="product.do?no=${recipe.mil_no }">${recipe.title }</a>
										</h3>
										<span>${recipe.rgst_dt }</span>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div><span style="font-size:30px;color:'BLUE';">커뮤니티 추천</span>&nbsp;<span style="font-size:10px;color:'GRAY'">|+더보기|</span></div>
				<div class="row">
					<c:forEach var="recipe" items="${recipe }">
						<c:if test="${recipe.rec_idx == 2 }">
							<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
								<div class="single-popular-items mb-50 text-center">
									<div class="popular-img">
										<img src="assets/img/gallery/popular1.png" alt="">
										<div class="img-cap">
											<span>Add to cart</span>
										</div>
										<div class="favorit-items">
											<span class="flaticon-heart"></span>
										</div>
									</div>
									<div class="popular-caption">
										<h3>
											<a href="product.do?no=${recipe.mil_no }">${recipe.title }</a>
										</h3>
										<span>${recipe.rgst_dt }</span>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<c:forEach var="type1" begin="1" end="4" varStatus="loop">
				<div class="tab-pane fade" id="type1_${loop.count }" role="tabpanel"
					aria-labelledby="nav${loop.count }">
					<div><span style="font-size:30px;color:'BLUE';">MD추천</span>&nbsp;<span style="font-size:10px;color:'GRAY'">|+더보기|</span></div>
					<div class="row">
						<c:forEach var="recipe" items="${recipe }">
							<c:if
								test="${(recipe.cook_idx == loop.count) && (recipe.rec_idx==1) }">

								<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
									<div class="single-popular-items mb-50 text-center">
										<div class="popular-img">
											<img src="assets/img/gallery/popular1.png" alt="">
											<div class="img-cap">
												<span>Add to cart</span>
											</div>
											<div class="favorit-items">
												<span class="flaticon-heart"></span>
											</div>
										</div>
										<div class="popular-caption">
											<h3>
												<a href="product.do?no=${recipe.mil_no }">${recipe.title }</a>
											</h3>
											<span>${recipe.rgst_dt }</span>
										</div>
									</div>
								</div>


							</c:if>
						</c:forEach>
					</div>
					<div><span style="font-size:30px;color:'BLUE';">커뮤니티 추천</span>&nbsp;<span style="font-size:10px;color:'GRAY'">|+더보기|</span></div>
					<div class="row">
						<c:forEach var="recipe" items="${recipe }">
							<c:if
								test="${(recipe.cook_idx == loop.count) && (recipe.rec_idx==2) }">

								<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
									<div class="single-popular-items mb-50 text-center">
										<div class="popular-img">
											<img src="assets/img/gallery/popular1.png" alt="">
											<div class="img-cap">
												<span>Add to cart</span>
											</div>
											<div class="favorit-items">
												<span class="flaticon-heart"></span>
											</div>
										</div>
										<div class="popular-caption">
											<h3>
												<a href="product.do?no=${recipe.mil_no }">${recipe.title }</a>
											</h3>
											<span>${recipe.rgst_dt }</span>
										</div>
									</div>
								</div>


							</c:if>
						</c:forEach>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
	<!-- End Nav Card -->
</section>

<div class="modal fade" id="igdMoal" tabindex="-1"
	aria-labelledby="igdMoalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="igdMoalLabel">재료 등록</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="#" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">재료명</label> <input
							type="text" class="form-control" id="recipient-name">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">단위</label> <input
							type="text" class="form-control" id="recipient-name">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">가격</label> <input
							type="text" class="form-control" id="recipient-name">
					</div>
					<div class="form-group">
						<label for="message-text" class="col-form-label">사진등록</label> <input
							type=file id="filename" name="filename" class="form-control">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn_3" data-dismiss="modal"
					style="padding: 10px;">닫기</button>
				<button type="button" class="btn_3" style="padding: 10px;">등록</button>
			</div>
		</div>
	</div>
</div>


<%@ include file="../include/footer.jsp"%>