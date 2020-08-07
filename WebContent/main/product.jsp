<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<main>
        <!--================Single Product Area =================-->
        <div class="product_image_area">
            <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-12">
                <div class="product_img_slide owl-carousel">
                    <div class="single_product_img">
                        <img src="assets/img/gallery/gallery1.png" alt="#" class="img-fluid">
                    </div>
                    <div class="single_product_img">
                        <img src="assets/img/gallery/gallery01.png" alt="#" class="img-fluid">
                    </div>
                    <div class="single_product_img">
                        <img src="assets/img/gallery/gallery1.png" alt="#" class="img-fluid">
                    </div>
                </div>
                </div>
                <div class="col-lg-12">
                <div class="single_product_text text-center">
                    <h3>${dish.name } </h3>
                    <p>
                        Seamlessly empower fully researched growth strategies and interoperable internal or “organic” sources. Credibly innovate granular internal or “organic” sources whereas high standards in web-readiness. Credibly innovate granular internal or organic sources whereas high standards in web-readiness. Energistically scale future-proof core competencies vis-a-vis impactful experiences. Dramatically synthesize integrated schemas. with optimal networks.
                    </p>
                    <form action="cart.do" method="post">
                    <div class="card_area">
                        <div class="product_count_area text-center">
                            <p>메인 재료 || 돼지고기<!-- 메인재료 이름 --></p>
                            <div class="product_count d-inline-block">
                                <span id="decrement" class="product_count_item inumber-decrement"> <i class="ti-minus"></i></span>
                                <input id="mat1" class="product_count_item input-number" type="text" value="1" min="0" max="10">
                                <span id="increment" class="product_count_item number-increment"> <i class="ti-plus"></i></span>
                            </div>
                        </div>
                        <div class="product_count_area text-center">
                            <p>메인 재료 || 서브재료<!-- 메인재료 이름 --></p>
                            <div class="product_count d-inline-block">
                                <span id="decrement2" class="product_count_item inumber-decrement"> <i class="ti-minus"></i></span>
                                <input id="mat2" class="product_count_item input-number" type="text" value="2" min="0" max="10">
                                
                                <span id="increment2" class="product_count_item"> <i class="ti-plus"></i></span>
                            </div>
                        </div>
                        
                    <div class="add_to_cart">
                        <button type="submit" value="add to cart" class="btn_3"></button>
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
                            <p>Seamlessly empower fully researched growth strategies and interoperable internal or “organic” sources credibly innovate granular internal .</p>
                            <div class="subscribe_form">
                                <input type="email" placeholder="Enter your mail">
                                <a href="#" class="btn_1">Subscribe</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- subscribe part end -->
    </main>
<script type="text/javascript">
$('#increment').on('click',function(){
	var value=$('#mat1').val();
	var min=0;
	var max=10;
	parseInt(value);
	value++;
	if(value<=max){
		$('#mat1').val(value);
	}else{
		alert("최대수량 초과");
	}
	
}); 
$('#decrement').on('click',function(){
	var value=$('#mat1').val();
	var min=0;
	var max=10;
	parseInt(value);
	value--;
	if(value>=min){
		$('#mat1').val(value);
	}else{
		alert("최소값입니다.");
	}
}); 
$('#increment2').on('click',function(){
	var value=$('#mat2').val();
	var min=0;
	var max=10;
	parseInt(value);
	value++;
	if(value<=max){
		$('#mat2').val(value);
	}else{
		alert("최대수량 초과");
	}
}); 
$('#decrement2').on('click',function(){
	var value=$('#mat2').val();
	var min=0;
	var max=10;
	parseInt(value);
	value--;
	if(value>=min){
		$('#mat2').val(value);
	}else{
		alert("최소값입니다.");
	}
});

</script>

<%@ include file="../include/footer.jsp"%>