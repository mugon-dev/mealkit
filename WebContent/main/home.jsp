<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>



<main>
	<!--? slider Area Start -->
	<div class="container">
		<div class="s010">
			<form action="search.do" method="post">
				<div class="inner-form">
					<div class="basic-search">
						<div class="input-field">
							<input id="search" type="text" placeholder="Type Keywords" />
							<div class="icon-wrap">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24">
                  <path
										d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
                </svg>
							</div>
						</div>
					</div>
					<div class="advance-search">
						<span class="desc">ADVANCED SEARCH</span>
						<div class="row">
							<div class="input-field">
								<div class="input-select">
									<select name="type1" data-trigger=""
										name="choices-single-defaul">
										<option value="1">한식</option>
										<option value="2">중식</option>
										<option value="3">일식</option>
										<option value="4">양식</option>
									</select>
								</div>
							</div>
							<div class="input-field">
								<div class="input-select">
								<!-- 여기서 재료 리스트 받아서 forEach로 입력 -->
									<select name="type2" data-trigger=""
										name="choices-single-defaul">
										<c:forEach items="${list }" var="list">
										<option value="${list.mat_no }">${list.mat_nm }</option>
										</c:forEach>
									</select>

								</div>
							</div>
							<div class="input-field">
								<div class="input-select">
									<select name="type3" data-trigger=""
										name="choices-single-defaul">
										<option value="1">구이</option>
										<option value="2">찜</option>
										<option value="3">탕</option>
										<option value="4">생식</option>
										<option value="5">기타</option>
									</select>
								</div>
							</div>
						</div>

						<div class="row third">
							<div class="input-field">
								<div class="result-count">
									<span>108 </span>results
								</div>
								<div class="group-btn">
									<button class="btn-delete" id="delete">RESET</button>
									<button type="submit" class="btn-search">SEARCH</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- slider Area End-->
	<!-- ? New Product Start -->
	<section class="new-product-area section-padding30">
		<div class="container">
			<!-- Section tittle -->
			<div class="row">
				<div class="col-xl-12">
					<div class="section-tittle mb-70">
						<h2>신규 밀키트</h2>
					</div>
				</div>
			</div>
			<div class="row">
			<c:forEach items="${recipe1 }" var="recipe1" begin="0" end="2">
				<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
					<div class="single-new-pro mb-30 text-center">
						<div class="product-img">
						<a href="product.do?no=${recipe1.mil_no }">
							<img src="images/${recipe1.image }" alt="" />
							</a>
						</div>
						<div class="product-caption">
							<h3>
								<a href="product.do?no=${recipe1.mil_no }">${recipe1.title }</a>
							</h3>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!--  New Product End -->
	<!--? Gallery Area Start -->
	<div class="container">
		<div class="row">
			<div class="col-xl-12">
				<div class="section-tittle mb-70">
					<h2>신규 레시피</h2>
				</div>
			</div>
		</div>
		<div class="gallery-area">
			<div class="container-fluid p-0 fix">
				<div class="row">
					<div class="col-xl-6 col-lg-4 col-md-6 col-sm-6">
					<div OnClick="location.href='blogDetail.do?milNo=${recipe2[0].mil_no }';" style="cursor:pointer;">
						<div class="single-gallery mb-30">
							<div class="gallery-img big-img" 
								style="background-image: url(images/${recipe2[0].image });"></div>
						</div>
						</div>
					</div>
					<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
					<div OnClick="location.href='blogDetail.do?milNo=${recipe2[1].mil_no }';" style="cursor:pointer;">
						<div class="single-gallery mb-30">
							<div class="gallery-img big-img" 
								style="background-image: url(images/${recipe2[1].image });"></div>
								</div>
						</div>
					</div>
					<div class="col-xl-3 col-lg-4 col-md-12">
						<div class="row">
							<div class="col-xl-12 col-lg-12 col-md-6 col-sm-6">
							<div OnClick="location.href='blogDetail.do?milNo=${recipe2[2].mil_no }';" style="cursor:pointer;">
								<div class="single-gallery mb-30">
									<div class="gallery-img small-img" 
										style="background-image: url(images/${recipe2[2].image });"></div>
										</div>
								</div>
							</div>
							<div class="col-xl-12 col-lg-12 col-md-6 col-sm-6">
							<div OnClick="location.href='blogDetail.do?milNo=${recipe2[3].mil_no }';" style="cursor:pointer;">
								<div class="single-gallery mb-30">
									<div class="gallery-img small-img" 
										style="background-image: url(images/${recipe2[3].image }); "></div>
										</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Gallery Area End -->
</main>
<script src="js/main_search/js/extention/choices.js"></script>
<script>
	const customSelects = document.querySelectorAll("select");
	const deleteBtn = document.getElementById('delete')
	const choices = new Choices('select', {
		searchEnabled : false,
		itemSelectText : '',
		removeItemButton : true,
	});
	for (let i = 0; i < customSelects.length; i++) {
		customSelects[i].addEventListener('addItem', function(event) {
			if (event.detail.value) {
				let parent = this.parentNode.parentNode
				parent.classList.add('valid')
				parent.classList.remove('invalid')
			} else {
				let parent = this.parentNode.parentNode
				parent.classList.add('invalid')
				parent.classList.remove('valid')
			}
		}, false);
	}
	deleteBtn.addEventListener("click", function(e) {
		e.preventDefault()
		const deleteAll = document.querySelectorAll('.choices__button')
		for (let i = 0; i < deleteAll.length; i++) {
			deleteAll[i].click();
		}
	});
	
</script>

<%@ include file="../include/footer.jsp"%>