<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<main>
	<!--================Single Product Area =================-->
	
	<div class="product_image_area">
	<%-- <c:choose>
					<c:when test="${session_id == 'admin' }"> --%>
				<div class="dropdown show" style="color: black; float: right; margin-right: 100px;">
					<div class="dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">관리자 메뉴</div>
					<div class="dropdown-menu">
						<a class="dropdown-item" data-toggle="modal"
							data-target="#igdMoal" data-whatever="@mdo">재료 수정</a>
						<a class="dropdown-item" href="matDelete.do?mat_no=${mat.mat_no }">삭제</a>
					</div>
				</div>

				<%-- </c:when>
					</c:choose> --%>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
						<div class="single_product_img">
							<img src="images/${recipe.image }" alt="#" class="img-fluid">
						</div>
				</div>
				<div class="col-lg-12">
					<div class="single_product_text text-center">
						<h3>${mat.mat_nm }</h3>
						<form action="cart.do" method="post">
							<div class="card_area">
								<div class="container" style="width: 800px">
									<table class="table">
										<thead>
											<tr>
												<td align="right"><b>재료명</b></td>
												<td><b>수량</b></td>
												<td align="left"><b>단위</b></td>
										</thead>
										<tbody>
	
												<tr>
													<td align="right" width=30%>${mat.mat_nm }</td> <!-- 재료명 -->
													<td align="center" width=40%>
														<div class="product_count d-inline-block">
															<span id="decrement" class="product_count_item inumber-decrement"> 
															<i class="ti-minus"></i></span> <input id="mat_count" name="mat1"
																class="product_count_item input-number" type="text"
																value="1" min="0" max="10"> <span
																id="increment"
																class="product_count_item number-increment"> <i
																class="ti-plus"></i>
															</span>
														</div>
														<input type="hidden" name="material1" value="${mat.mat_no }"/>
														<input type="hidden" name="count" value="1"/>
													</td>
													<td align="left" width=30%>${mat.mat_unit }</td> <!-- 단위 -->
												</tr>
											
											

											<tr>
												<c:if test="${not empty session_no }"> <!-- add cart -->
													<td colspan="3">
														<div class="add_to_cart">
															<button type="submit" value="add to cart" class="btn_3">add
																to cart</button>
															<input type="hidden" name="session_id" value="${session_id }"/>
															<input type="hidden" name="no" value="${session_no }"/>
															
														</div>
													</td>
												</c:if>
												<c:if test="${empty session_no }"> <!--로그인 안되어있을때 add cart  -->
													<td colspan="3">
														<div class="add_to_cart">
															<button type="button" id="login" value="${mat.mat_no }" class="btn_3">로그인
															</button>
															
														</div>
													</td>
												</c:if>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->
	<!-- subscribe part here -->
	<section class="subscribe_part section_padding">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="subscribe_part_content">
						<h2>Get promotions & updates!</h2>
						<p>Seamlessly empower fully researched growth strategies and
							interoperable internal or “organic” sources credibly innovate
							granular internal .</p>
						<div class="subscribe_form">
							<input type="email" placeholder="Enter your mail"> <a
								href="#" class="btn_1">Subscribe</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- subscribe part end -->
</main>
<script type="text/javascript">
		$('#increment').on('click', function() {
			var value = $('#mat_count').val();
			var min = 0;
			var max = 10;
			parseInt(value);
			value++;
			if (value <= max) {
				$('#mat_count').val(value);
			} else {
				alert("최대수량 초과");
			}
	
		});
		$('#decrement').on('click', function() {
			var value = $('#mat_count').val();
			var min = 0;
			var max = 10;
			parseInt(value);
			value--;
			if (value >= min) {
				$('#mat_count').val(value);
			} else {
				alert("최소값입니다.");
			}
		});

	$('#login').on('click',function(){
		var value=$('#login').val();
		location.href="loginForm.do?no="+value;
	});
</script>
<%@ include file="../include/footer.jsp"%>