<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript">
	$("#nav-meat-tab").on("click", function() {
		location.href = "matForm.do?mat_idx=10";
	});
</script>
<section class="popular-items latest-padding">
	<div class="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-white">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item">
        <a class="nav-link" href="matForm.do?idx=0">전체</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="matForm.do?idx=10">메인</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="matForm.do?idx=20">서브</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="matForm.do?idx=30">소스</a>
      </li>
      <%-- <c:choose>
					<c:when test="${session_id == 'admin' }"> --%>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          관리자 메뉴
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" data-toggle="modal" data-target="#igdMoal" data-whatever="@mdo">등록</a>
        </div>
      </li>
      <%-- </c:when>
					</c:choose> --%>
    </ul>
    
  </div>
</nav>
	</div>
	<div class="container">
		<!-- 전체 -->
		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="nav-whole" role="tabpanel"
				aria-labelledby="nav-whole-tab">
				<div class="row">
					<c:forEach items="${list }" var="mat">
						<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
							<div class="single-popular-items mb-50 text-center">
								<div class="popular-img">
									<a href="matDetail.do?no=${mat.mat_no }"> <img
										src="images/mat/${mat.mat_image }" style="width:360px; height:250px" alt="">
									</a>
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
			</div>

		</div>
		<nav class="blog-pagination justify-content-center d-flex">
			<!-- 페이징 시작  -->
			<ul class="pagination">
				<li class='page-item <c:out value="${pageM.prev == true ? ' ' : 'disabled' }"></c:out>'>
					<a href="matForm.do?pageNum=${pageM.startPage - pageM.pageSize }"
					class="page-link" aria-label="Previous"> <i class="ti-angle-left"></i>
				</a>
				</li>
				<c:forEach var="i" begin="${pageM.startPage }" end="${pageM.endPage }">
					<li
						class='page-item <c:out value="${pageM.currentPage == i ? 'active' : ' ' }"></c:out>'>
						<a href="matForm.do?pageNum=${i }" class="page-link">${i }</a>
					</li>
				</c:forEach>
				<li
					class='page-item <c:out value="${pageM.next == true ? ' ' : 'disabled' }"></c:out>'>
					<a href="matForm.do?pageNum=${pageM.endPage+1 }" class="page-link"
					aria-label="Next"> <i class="ti-angle-right"></i>
				</a>
				</li>
			</ul>
		</nav>
	</div>
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
						<label for="recipient-name" class="col-form-label">mat_idx(메인:10,서브:20,소스:30)</label>
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