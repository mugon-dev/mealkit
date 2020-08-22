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
						<a class="nav-item nav-link active" id="nav-whole-tab"
							data-toggle="tab" href="#nav-whole" role="tab"
							aria-controls="nav-whole" aria-selected="true">전체</a> 
							
							<c:forEach var="type1" begin="1" end="4" varStatus="loop">
							<c:set var="type1_${loop.count }" value="${loop.count }"/>
							<a
							class="nav-item nav-link" id="nav-tab${loop.count }" data-toggle="tab"
							href="#type1${loop.count }" role="tab" aria-controls="nav${loop.count }"
							aria-selected="false">${loop.count }</a>
							</c:forEach>
			
			<!-- 				 <a class="nav-item nav-link"
							id="nav-chinese-tab" data-toggle="tab" href="#nav-chinese"
							role="tab" aria-controls="nav-chinese" aria-selected="false">중식</a>
						<a class="nav-item nav-link" id="nav-japanese-tab"
							data-toggle="tab" href="#nav-japanese" role="tab"
							aria-controls="nav-japanese" aria-selected="false">일식</a> <a
							class="nav-item nav-link" id="nav-last-tab" data-toggle="tab"
							href="#nav-western" role="tab" aria-controls="nav-western"
							aria-selected="false">양식</a>-->
					</div>
				</nav>
			</div>
			<div class="col-lg-4"></div>
			<!-- Header Right -->
		<!-- 	<div class="col-lg-3">
				<div class="dropdown show" style="color: black;">
					<div class="dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">관리자 메뉴</div>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="MyPageForm.do">Mealkit 등록</a> 						
					</div>
					
				</div>

			</div>-->

			<!--End Nav Button  -->
		</div>
	</div>
	<div class="container">
		<div class="row product-btn " style="height: 60px">
			<div
				class="properties__button justify-content-between mb-40 col-lg-11">
				<!--Nav Button  -->
				<nav>
					<div class="nav nav-tabs" id="nav-tab" role="tablist">
						<a class="nav-item nav-link active" id="nav-whole-tab"
							data-toggle="tab" href="#nav-whole" role="tab"
							aria-controls="nav-whole" aria-selected="true">전체</a> 
							
							<c:forEach var="type2" items="${list }" varStatus="loop2">
							<a
							class="nav-item nav-link" id="nav-tab${loop2.count }" data-toggle="tab"
							href="#type1${loop2.count }" role="tab" aria-controls="nav${loop2.count }"
							aria-selected="false">${type2.mat_nm }</a>
							</c:forEach>
							</div></nav></div></div></div>
	
	

	<div class="container">
	<div class="tab-content" id="nav-tabContent">
		<!-- 한식 -->
		<div class="tab-pane fade show active" id="nav-korean" role="tabpanel"
			aria-labelledby="nav-korean-tab">
			<h4>MD추천</h4>

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
<div class="modal fade" id="igdMoal" tabindex="-1" aria-labelledby="igdMoalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="igdMoalLabel">재료 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="#" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">재료명</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">단위</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">가격</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">사진등록</label>
            <input type=file id="filename" name="filename" class="form-control">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn_3" data-dismiss="modal" style="padding:10px;">닫기</button>
        <button type="button" class="btn_3" style="padding:10px;">등록</button>
      </div>
    </div>
  </div>
</div>


<%@ include file="../include/footer.jsp"%>