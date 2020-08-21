<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Watch shop | eCommers</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="manifest" href="site.webmanifest" />
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico" />

<!-- CSS here -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="assets/css/owl.carousel.min.css" />
<link rel="stylesheet" href="assets/css/flaticon.css" />
<link rel="stylesheet" href="assets/css/slicknav.css" />
<link rel="stylesheet" href="assets/css/animate.min.css" />
<link rel="stylesheet" href="assets/css/magnific-popup.css" />
<link rel="stylesheet" href="assets/css/fontawesome-all.min.css" />
<link rel="stylesheet" href="assets/css/themify-icons.css" />
<link rel="stylesheet" href="assets/css/slick.css" />
<link rel="stylesheet" href="assets/css/nice-select.css" />
<link rel="stylesheet" href="assets/css/style.css" />
<link rel="stylesheet" href="assets/css/main_search.css" />

<script src="js/jquery-3.5.1.min.js"></script>
<style>
.dropdown{
color: #000000 !important;
cursor: pointer !important;
}
</style>
</head>

<body>
	<!--? Preloader Start -->
	<div id="preloader-active">
		<div
			class="preloader d-flex align-items-center justify-content-center">
			<div class="preloader-inner position-relative">
				<div class="preloader-circle"></div>
				<div class="preloader-img pere-text">
					<img src="assets/img/logo/logo.png" alt="" />
				</div>
			</div>
		</div>
	</div>
	<!-- Preloader Start -->
	<header>
		<!-- Header Start -->
		<div class="header-area">
			<div class="main-header header-sticky">
				<div class="container-fluid">
					<div class="menu-wrapper">
						<!-- Logo -->
						<div class="logo">
							<a href="main.do"><img
								src="assets/img/logo/logo.png" alt="" /></a>
						</div>
						<!-- Main-menu -->
						<div class="main-menu d-none d-lg-block">
							<nav>
								<ul id="navigation">
									<li><a href="main.do">Home</a></li>
									<li><a href="shopForm.do">shop</a>
									<ul class="submenu">
											<li><a href="shopForm.do"> Mealkit list</a></li>
											<li><a href="matForm.do"> Material Details</a>
											</li>
										</ul></li>
									<li><a href="about.html">about</a></li>
									<li class="hot"><a href="#">Latest</a>
										<ul class="submenu">
											<li><a href="shopForm.do"> Product list</a></li>
											<li><a href="product_details.html"> Product Details</a>
											</li>
										</ul></li>
									<li><a href="blogForm.do">Blog</a>
										<ul class="submenu">
											<li><a href="blogForm.do">Blog</a></li>
											<li><a href="blogDetailForm.do">Blog Details</a></li>
										</ul></li>
									<li><a href="#">Pages</a>
										<ul class="submenu">
											<li><a href="login.html">Login</a></li>
											<li><a href="cart.html">Cart</a></li>
											<li><a href="elements.html">Element</a></li>
											<li><a href="confirmation.html">Confirmation</a></li>
											<li><a href="checkout.html">Product Checkout</a></li>
										</ul></li>
									<li><a href="contact.html">Contact</a></li>
								</ul>
							</nav>
						</div>
						<!-- Header Right -->
						<div class="header-right">
							<ul>
								<li>
									<div class="nav-search search-switch">
										<span class="flaticon-search"></span>
									</div>
								</li>
								<li><c:choose>
										<c:when test="${empty session_id }">
											<a href="loginForm.do"><span class="flaticon-user"></span></a>							
										</c:when>
										<c:otherwise>
											<!-- 드랍다운 메뉴 찾기 -->
									<div class="dropdown show" style="color: black;" >
										<div class="flaticon-user dropdown-toggle"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">(${session_id})</div>
											<div class="dropdown-menu">
											<a class="dropdown-item" href="MyPageForm.do">MyPage</a>
											<a class="dropdown-item" href="#" id="logout">로그아웃</a>
										</div>
									</div>
										</c:otherwise>
									</c:choose></li>
								
								<c:if test="${empty session_id }">
								
								<li><a href="loginForm.do"><span
										class="flaticon-shopping-cart"></span></a></li>
								</c:if>
								<c:if test="${not empty session_id }">
								<li><a href="cartForm.do?id=${session_id }"><span
										class="flaticon-shopping-cart"></span></a></li>
								</c:if>
							</ul>
						</div>
					</div>
					<!-- Mobile Menu -->
					<div class="col-12">
						<div class="mobile_menu d-block d-lg-none"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- Header End -->
	</header>

	<script type="text/javascript">
	$('#logout').on('click',function(event){
		event.stopPropagation();
		$.ajax({
			type : "post",
			url : "logout.do",
			async : false,
			dataType : "text",
			success : function(data, textStatus) {
				if (data == "success") {
					alert("로그 아웃");
					location.href = "loginForm.do";
				}
			},
			error : function(data, textStatus) {
				alert("error");
			},
			complete : function(data, textStatus) {
			}
		});
	});
	</script>
	