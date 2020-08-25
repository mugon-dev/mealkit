<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Meal share | eCommers</title>
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
.dropdown {
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
							<a href="main.do"><img src="assets/img/logo/logo.png" alt="" /></a>
						</div>
						<!-- Main-menu -->
						<div class="main-menu d-none d-lg-block">
							<nav>
								<ul id="navigation">
									<li><a href="main.do">Home</a></li>
									<li><a href="shopForm.do">shop</a>
										<ul class="submenu">
											<li><a href="shopForm.do"> Mealkit list</a></li>
											<li><a href="matForm.do"> Material Details</a></li>
										</ul></li>
									<li><a href="blogForm.do">Blog</a>
										<ul class="submenu">
											<li><a href="blogForm.do">Blog</a></li>
										</ul></li>
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
											<div class="dropdown show" style="color: black;">
												<div class="flaticon-user dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">(${session_id})</div>
												<div class="dropdown-menu">
													<a class="dropdown-item" href="blogForm.do?idx=6&no=${session_no }">내 글보기</a> 
													<a class="dropdown-item" id="memberUpdate" onclick="modalPopup()">내 정보 수정</a> 
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
	<!-- 내 정보 수정 모달 -->
		<div class="modal fade" id="idMoal" tabindex="-1"
			aria-labelledby="idMoalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="idMoalLabel">내정보수정</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="mat.do" method="post">
							<div class="form-group">
								<label for="recipient-name" class="col-form-label" id="memberName"></label> 
								<input
									type="text" class="form-control" id="name" name="name">
							</div>
							<div class="form-group">
								<label for="recipient-name" class="col-form-label" id="memberAddr"> </label> <input
									type="text" class="form-control" id="addr" name="addr">
							</div>
							<div class="form-group">
								<label for="recipient-name" class="col-form-label" id="memberTel"></label>
								<input type="text" class="form-control" id="tel" name="tel">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn_3" data-dismiss="modal"
									style="padding: 10px;">닫기</button>
								<button id="btnUpdate" class="btn_3" style="padding: 10px;">수정</button>
								<button id="btnDelete" class="btn_3" style="padding: 10px;">탈퇴</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript">
		$('#logout').on('click', function(event) {
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
		function modalPopup() {			
			$("#memberUpdate").on('click', function() {
				$.ajax({
					type:"post", // 전송 방식 GET , POST , PUT , DELETE
					url: "readPerson.do", // 전송할 경로
					async : false,
					data: {"no": ${session_no }} , // 전송할 키와 값
					success : function(data, textStatus) {
						var jsonInfo = JSON.parse(data);
						$('#memberName').html(jsonInfo.members.name);
						$('#memberAddr').html(jsonInfo.members.addr);
						$('#memberTel').html(jsonInfo.members.tel);
						$("#idMoal").modal("show");
					},
					complete : function() {
					// 성공여부와 상관없이 ajax 완료후 작업 
						
					},
					error : function(request, status, error) {
					// 에러가 났을 경우의 작업
						alert("error");
					}
				});
				
			});
			
		}
		$("#btnDelete").on('click', function() {
			location.href = "memberDelete.do?no=${member.no}";
		});
		$("#btnDelete").on('click', function() {
			location.href = "memberUpdate.do?no=${member.no}";
		});
	</script>