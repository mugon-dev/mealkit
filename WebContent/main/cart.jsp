<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<!-- Hero Area Start-->
	<div class="slider-area ">
		<div class="single-slider slider-height2 d-flex align-items-center">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap text-center">
							<h2>Cart List</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================Cart Area =================-->
	<section class="cart_area section_padding">
		<div class="container">
			<div class="cart_inner">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Product</th>
								<th scope="col">Price</th>
								<th scope="col">Quantity</th>
								<th scope="col">Total</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="sum" value="0"/>
							<c:forEach items="${listOrder }" var="order" varStatus="loop">
								<c:set var="count" value="${loop.count }"/>
								<c:set var="price" value="${order.price }"/>
								<c:set var="qty" value="${order.mat_qty }"/>
								<c:set var="total" value="${price * qty}"/>	
								<c:set var="sum" value="${sum + total }"/>
								<tr>
									<td>
										<div class="media">
											<div class="d-flex">
												<img src="assets/img/gallery/card1.png" alt="" />
											</div>
											<div class="media-body">
												<p>${order.mat_nm }</p>
											</div>
										</div>
									</td>
									<td>
										<h5 id="price${count }">${order.price }</h5>
									</td>
									<td>
										<div class="product_count">
											<span class="input-number-decrement"> <i
												class="ti-minus" id="decrement${count }"></i></span> <input class="input-number" type="text"
												id="mat${count }" value="${order.mat_qty }" min="0" max="10"> <span
												class="input-number-increment"> <i class="ti-plus" id="increment${count }"></i></span>
										</div>
									</td>
									<td>
										<h5 id="total${count }">${total }</h5>
									</td>
								</tr>
							</c:forEach>
							
							<tr class="bottom_button">
								<td><a class="btn_1" href="#">Update Cart</a></td>
								<td></td>
								<td></td>
								<td>
									<div class="cupon_text float-right">
										<a class="btn_1" href="#">Close Coupon</a>
									</div>
								</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td>
									<h5>Subtotal</h5>
								</td>
								<td>
									<h5 id="sum">${sum }</h5>
								</td>
							</tr>
							<tr class="shipping_area">
								<td></td>
								<td></td>
								<td>
									<h5>Shipping</h5>
								</td>
								<td>
									<div class="shipping_box">
										<ul class="list">
											<li>Flat Rate: $5.00 <input type="radio"
												aria-label="Radio button for following text input">
											</li>
											<li>Free Shipping <input type="radio"
												aria-label="Radio button for following text input">
											</li>
											<li>Flat Rate: $10.00 <input type="radio"
												aria-label="Radio button for following text input">
											</li>
											<li class="active">Local Delivery: $2.00 <input
												type="radio"
												aria-label="Radio button for following text input">
											</li>
										</ul>
										<h6>
											Calculate Shipping <i class="fa fa-caret-down"
												aria-hidden="true"></i>
										</h6>
										<select class="shipping_select">
											<option value="1">Bangladesh</option>
											<option value="2">India</option>
											<option value="4">Pakistan</option>
										</select> <select class="shipping_select section_bg">
											<option value="1">Select a State</option>
											<option value="2">Select a State</option>
											<option value="4">Select a State</option>
										</select> <input class="post_code" type="text"
											placeholder="Postcode/Zipcode" /> <a class="btn_1" href="#">Update
											Details</a>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="checkout_btn_inner float-right">
						<a class="btn_1" href="#">Continue Shopping</a> <a
							class="btn_1 checkout_btn_1" href="#">Proceed to checkout</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Cart Area =================-->
</main>
<script type="text/javascript">
	for(let i=1;i<10;i++){
		$('#increment'+i).on('click', function() {
			var value = $('#mat'+i).val();
			var price = $('#price'+i).html();
			var total = $('#total'+i).html();
			var sum = $('#sum').html();
			var min = 0;
			var max = 10;
			parseInt(value);
			value++;
			if (value <= max) {
				$('#mat'+i).val(value);
				total=parseInt(total)+parseInt(price);
				sum=parseInt(sum)+parseInt(price);
				$('#total'+i).html(total);
				$('#sum').html(sum);
			} else {
				alert("최대수량 초과");
			}
	
		});
		$('#decrement'+i).on('click', function() {
			var value = $('#mat'+i).val();
			var price = $('#price'+i).html();
			var total = $('#total'+i).html();
			var sum = $('#sum').html();
			var min = 0;
			var max = 10;
			parseInt(value);
			value--;
			if (value >= min) {
				$('#mat'+i).val(value);
				total=parseInt(total)-parseInt(price);
				sum=parseInt(sum)-parseInt(price);
				$('#total'+i).html(total);
				$('#sum').html(sum);
			} else {
				alert("최소값입니다.");
			}
		});
	}
</script>

<%@ include file="../include/footer.jsp"%>