<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section class="popular-items latest-padding">
	<div class="container">
		


		<div class="tab-content" id="nav-tabContent">
			<!-- 한식 -->
			<div class="tab-pane fade show active" id="nav-korean"
				role="tabpanel" aria-labelledby="nav-korean-tab">
				<div>
					<span style="font-size:30px;color:'BLUE';">MD추천</span>&nbsp;
					<a href="shop.do?cook_idx=${cook_idx }&mat_no1=${mat_no1 }&cook_type=${cook_type }" class="badge badge-secondary">|+더보기|</a>
				</div>
				

				<div class="row">
					<c:forEach var="recipe1" items="${list_MD }">
						<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
							<div class="single-popular-items mb-50 text-center">
								<div class="popular-img" >
									<a href="product.do?no=${recipe1.mil_no }">
									<img src="images/${recipe1.image }" alt="" style="width:360px; height:250px"></a>
									<div class="img-cap">
										<span>Add to cart</span>
									</div>
									<div class="favorit-items">
										<span class="flaticon-heart"></span>
									</div>
								</div>
								<div class="popular-caption">
									<h3>
										<a href="product.do?no=${recipe1.mil_no }">${recipe1.title }</a>
									</h3>
									<span>${recipe1.rgst_dt }</span>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

				<div>
					<span style="font-size:30px;color:'BLUE';">커뮤니티추천</span>&nbsp;
					<a href="shop.do?cook_idx=${cook_idx }&mat_no1=${mat_no1 }&cook_type=${cook_type }" class="badge badge-secondary">|+더보기|</a>
				<div class="row">
					<c:forEach var="recipe2" items="${list_COMM }">
						<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
							<div class="single-popular-items mb-50 text-center">
								<div class="popular-img" >
									<img src="images/${recipe2.image }" alt="" style="width:360px; height:250px">
									<div class="img-cap">
										<span>Add to cart</span>
									</div>
									<div class="favorit-items">
										<span class="flaticon-heart"></span>
									</div>
								</div>
								<div class="popular-caption">
									<h3>
										<a href="product.do?no=${recipe2.mil_no }">${recipe2.title }</a>
									</h3>
									<span>${recipe2.rgst_dt }</span>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
				
			</div>
			
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
<%@ include file="../include/footer.jsp"%>