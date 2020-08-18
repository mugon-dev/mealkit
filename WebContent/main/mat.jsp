<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section class="popular-items latest-padding">
	<div class="container">
		<div class="row product-btn ">
			<div
				class="properties__button justify-content-between mb-40 col-lg-5">
				<!--Nav Button  -->
				<nav>
					<div class="nav nav-tabs" id="nav-tab" role="tablist">
						<a class="nav-item nav-link active" id="nav-whole-tab"
							data-toggle="tab" href="#nav-whole" role="tab"
							aria-controls="nav-whole" aria-selected="true">전체</a> <a
							class="nav-item nav-link" id="nav-korean-tab" data-toggle="tab"
							href="#nav-korean" role="tab" aria-controls="nav-korean"
							aria-selected="false">육류</a> <a class="nav-item nav-link"
							id="nav-chinese-tab" data-toggle="tab" href="#nav-chinese"
							role="tab" aria-controls="nav-chinese" aria-selected="false">채소</a>
						<a class="nav-item nav-link" id="nav-japanese-tab"
							data-toggle="tab" href="#nav-japanese" role="tab"
							aria-controls="nav-japanese" aria-selected="false">소스</a>
					</div>
				</nav>
			</div>
			<div class="col-lg-4"></div>
			<!-- Header Right -->
			<div class="col-lg-3">
				<%-- <c:choose>
					<c:when test="${session_id == 'admin' }"> --%>
				<div class="dropdown show" style="color: black;">
					<div class="dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">관리자 메뉴</div>
					<div class="dropdown-menu">
						<a class="dropdown-item" data-toggle="modal"
							data-target="#igdMoal" data-whatever="@mdo">재료 등록</a>
					</div>

				</div>

				<%-- </c:when>
					</c:choose> --%>
			</div>

			<!--End Nav Button  -->
		</div>
		<!-- Grid and List view -->
		<!-- <div class="grid-list-view"></div> -->
		<!-- Select items -->
		<!--      <div class="select-this">
                        <form action="#">
                            <div class="select-itms">
                                <select name="select" id="select1">
                                    <option value="">40 per page</option>
                                    <option value="">50 per page</option>
                                    <option value="">60 per page</option>
                                    <option value="">70 per page</option>
                                </select>
                            </div>
                        </form>
                    </div> -->
	</div>

	<div class="container">
		<div class="tab-content" id="nav-tabContent">
			<!-- 전체 -->
			<div class="tab-pane fade show active" id="nav-whole" role="tabpanel"
				aria-labelledby="nav-whole-tab">
				<h4>전체</h4>

				<div class="row">
					<c:forEach items="${list }" var="mat">
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
										<a href="product_details.html">${mat.mat_nm }</a>
									</h3>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<h4>커뮤니티 추천</h4>
				<div class="row">
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
									<a href="product_details.html">Thermo Ball Etip Gloves</a>
								</h3>
								<span>$ 45,743</span>
							</div>
						</div>
					</div>

				</div>
				<nav class="blog-pagination justify-content-center d-flex">
					<ul class="pagination">
						<li class="page-item"><a href="#" class="page-link"
							aria-label="Previous"> <i class="ti-angle-left"></i>
						</a></li>
						<li class="page-item"><a href="#" class="page-link">1</a></li>
						<li class="page-item active"><a href="#" class="page-link">2</a>
						</li>
						<li class="page-item"><a href="#" class="page-link"
							aria-label="Next"> <i class="ti-angle-right"></i>
						</a></li>
					</ul>
				</nav>
			</div>
			<!-- 중식 -->
			<div class="tab-pane fade" id="nav-chinese" role="tabpanel"
				aria-labelledby="nav-chinese-tab">
				<div class="row">
					<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
						<div class="single-popular-items mb-50 text-center">
							<div class="popular-img">
								<img src="assets/img/gallery/popular6.png" alt="">
								<div class="img-cap">
									<span>Add to cart</span>
								</div>
								<div class="favorit-items">
									<span class="flaticon-heart"></span>
								</div>
							</div>
							<div class="popular-caption">
								<h3>
									<a href="product_details.html">Thermo Ball Etip Gloves</a>
								</h3>
								<span>$ 45,743</span>
							</div>
						</div>
					</div>
				</div>
				<nav class="blog-pagination justify-content-center d-flex">
					<ul class="pagination">
						<li class="page-item"><a href="#" class="page-link"
							aria-label="Previous"> <i class="ti-angle-left"></i>
						</a></li>
						<li class="page-item"><a href="#" class="page-link">1</a></li>
						<li class="page-item active"><a href="#" class="page-link">2</a>
						</li>
						<li class="page-item"><a href="#" class="page-link"
							aria-label="Next"> <i class="ti-angle-right"></i>
						</a></li>
					</ul>
				</nav>
			</div>


			<!-- 일식 -->
			<div class="tab-pane fade" id="nav-japanese" role="tabpanel"
				aria-labelledby="nav-japanese-tab">
				<div class="row">
					<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
						<div class="single-popular-items mb-50 text-center">
							<div class="popular-img">
								<img src="assets/img/gallery/popular6.png" alt="">
								<div class="img-cap">
									<span>Add to cart</span>
								</div>
								<div class="favorit-items">
									<span class="flaticon-heart"></span>
								</div>
							</div>
							<div class="popular-caption">
								<h3>
									<a href="product_details.html">Thermo Ball Etip Gloves</a>
								</h3>
								<span>$ 45,743</span>
							</div>
						</div>
					</div>
				</div>
				<nav class="blog-pagination justify-content-center d-flex">
					<ul class="pagination">
						<li class="page-item"><a href="#" class="page-link"
							aria-label="Previous"> <i class="ti-angle-left"></i>
						</a></li>
						<li class="page-item"><a href="#" class="page-link">1</a></li>
						<li class="page-item active"><a href="#" class="page-link">2</a>
						</li>
						<li class="page-item"><a href="#" class="page-link"
							aria-label="Next"> <i class="ti-angle-right"></i>
						</a></li>
					</ul>
				</nav>
			</div>


			<!-- 양식 -->
			<div class="tab-pane fade" id="nav-western" role="tabpanel"
				aria-labelledby="nav-western-tab">
				<div class="row">
					<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
						<div class="single-popular-items mb-50 text-center">
							<div class="popular-img">
								<img src="assets/img/gallery/popular6.png" alt="">
								<div class="img-cap">
									<span>Add to cart</span>
								</div>
								<div class="favorit-items">
									<span class="flaticon-heart"></span>
								</div>
							</div>
							<div class="popular-caption">
								<h3>
									<a href="product_details.html">Thermo Ball Etip Gloves</a>
								</h3>
								<span>$ 45,743</span>
							</div>
						</div>
					</div>
				</div>
				<nav class="blog-pagination justify-content-center d-flex">
					<ul class="pagination">
						<li class="page-item"><a href="#" class="page-link"
							aria-label="Previous"> <i class="ti-angle-left"></i>
						</a></li>
						<li class="page-item"><a href="#" class="page-link">1</a></li>
						<li class="page-item active"><a href="#" class="page-link">2</a>
						</li>
						<li class="page-item"><a href="#" class="page-link"
							aria-label="Next"> <i class="ti-angle-right"></i>
						</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<!-- End Nav Card -->
</section>
<!-- Latest Products End -->
<!-- Latest Products End -->
<!--? Shop Method Start-->
<div class="shop-method-area">
	<div class="container">
		<div class="method-wrapper">
			<div class="row d-flex justify-content-between">
				<div class="col-xl-4 col-lg-4 col-md-6">
					<div class="single-method mb-40">
						<i class="ti-package"></i>
						<h6>Free Shipping Method</h6>
						<p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
					</div>
				</div>
				<div class="col-xl-4 col-lg-4 col-md-6">
					<div class="single-method mb-40">
						<i class="ti-unlock"></i>
						<h6>Secure Payment System</h6>
						<p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
					</div>
				</div>
				<div class="col-xl-4 col-lg-4 col-md-6">
					<div class="single-method mb-40">
						<i class="ti-reload"></i>
						<h6>Secure Payment System</h6>
						<p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Shop Method End-->
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
				<form action="mat.do" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">mat_no</label>
						<input type="text" class="form-control" id="mat_no" name="mat_no">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">mat_idx</label>
						<input type="text" class="form-control" id="mat_idx"
							name="mat_idx">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">재료명</label> <input
							type="text" class="form-control" id="mat_nm" name="mat_nm">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">단위</label> <input
							type="text" class="form-control" id="mat_unit" name="mat_unit">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">가격</label> <input
							type="text" class="form-control" id="mat_price" name="mat_price">
					</div>
					<div class="form-group">
						<label for="message-text" class="col-form-label">사진등록</label> <input
							type=file id="filename" name="filename" class="form-control">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn_3" data-dismiss="modal"
							style="padding: 10px;">닫기</button>
						<button type="submit" class="btn_3" style="padding: 10px;">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


<%@ include file="../include/footer.jsp"%>