<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section class="popular-items latest-padding">
	<div class="container">
		<div class="row product-btn justify-content-between mb-40">
			<div class="properties__button">
				<!--Nav Button  -->
				<nav>
					<div class="nav nav-tabs" id="nav-tab" role="tablist">
						<div class="nav-item nav-link active" id="nav-korean-tab"
							data-toggle="tab" role="tab"
							aria-controls="nav-korean" aria-selected="true">${type1 } ||</div> <div
							class="nav-item nav-link" id="nav-chinese-tab" data-toggle="tab"
							role="tab" aria-controls="nav-chinese"
							aria-selected="false">${type2 } ></div> <div class="nav-item nav-link"
							id="nav-japanese-tab" data-toggle="tab" 
							role="tab" aria-controls="nav-japanese" aria-selected="false">${type3 }</div>
						
					</div>
				</nav>
				<!--End Nav Button  -->
			</div>
			<!-- Grid and List view -->
			<div class="grid-list-view"></div>

		</div>


		<div class="tab-content" id="nav-tabContent">
			<!-- 한식 -->
			<div class="tab-pane fade show active" id="nav-korean"
				role="tabpanel" aria-labelledby="nav-korean-tab">
				<h4>MD추천</h4>

				<div class="row">
					<c:forEach var="recipe" items="${list }">
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
									<a href="product.do">Thermo Ball Etip Gloves</a>
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
<%@ include file="../include/footer.jsp"%>