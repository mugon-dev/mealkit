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
			<form action="purchase.do" method="post">
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
												<img src="images/mat/${order.mat_image }" alt="" />
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
												id="mat${count }" name="qty_${count }" value="${order.mat_qty }" min="0" max="10"> <span
												class="input-number-increment"> <i class="ti-plus" id="increment${count }"></i></span>
										</div>
										<input type="hidden" name="ord_${count }" value="${order.order_no }"/>
										
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
							
						</tbody>
					</table>
					<div class="checkout_btn_inner float-right">
						<a class="btn_1" href="shop.do">쇼핑 계속하기</a> 
						<input type="hidden" name="count" value="${count }"/>
						<button type="submit" class="btn_1 checkout_btn_1">구매하기</button>
						<!-- <a
							class="btn_1 checkout_btn_1" href="#">Proceed to checkout</a> -->
							
					</div>
				</div>
				</form>
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