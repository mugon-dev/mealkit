<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	
	<section class="blog_area section-padding">
	    <div class="container">
	        <div class="row">
				<div class="col-lg-8 mb-5 mb-lg-0">
					<div class="blog_left_sidebar">
						
						<!-- 게시글 시작 -->
						<form action="blog.do" method="post" enctype="multipart/form-data">
	 						<c:forEach items="${list }" var="blog" > 
								<article class="blog_item">
									<div class="blog_item_img">
										<c:if test="${not empty blog.image}" >
											<img class="card-img rounded-0" src="images/${blog.image }" >
										</c:if>
										<c:if test="${empty blog.image}" >
											<img class="card-img rounded-0" src="images/noImage.png" >
										</c:if>
									</div>
				
									<div class="blog_details">
										<a class="d-inline-block" href="blogDetailForm.do">
											<h2> No.${blog.milNo } ${blog.title } </h2>
										</a><br> ${blog.content } </p>
										<ul class="blog-info-link">
											<li><a href="#"><i class="fa fa-user"></i>${blog.no }</a></li> 
											<li><a href="#"><i class="fa fa-comments"></i>${blog.replyCount }</a></li>
										</ul>
									</div>
								</article>
	 						</c:forEach> 
						</form>
						<nav class="blog-pagination justify-content-center d-flex">
							<!-- 페이징 시작  -->
							<ul class="pagination">
								<li class='page-item <c:out value="${pageM.prev == true ? '' : 'disabled' }"></c:out>'>
									<a href="blogForm.do?pageNum=${pageM.startPage - pageM.pageSize }" class="page-link" aria-label="Previous">
										<i class="ti-angle-left"></i> 
									</a>
								</li>
								<c:forEach var="i" begin="${pageM.startPage }" end="${pageM.endPage }">
									<li class='page-item <c:out value="${pageM.currentPage == i ? 'active' : '' }"></c:out>'>
										<a href="blogForm.do?pageNum=${i }" class="page-link" >${i }</a></li>
								</c:forEach>
								<li class='page-item <c:out value="${pageM.next == true ? '' : 'disabled' }"></c:out>'>
									<a href="blogForm.do?pageNum=${pageM.endPage+1 }" class="page-link" aria-label="Next">
										<i class="ti-angle-right"></i>
									</a>
								</li>
							</ul>
						</nav>
					</div>
				</div> 
				
				<!-- 우측 바 메뉴 시작-->
				<div class="col-lg-4">
<%-- 					<c:if test="${not empty session_no }"> --%>
						<button type="button" id="btnBlogDetailWrite"  class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn" >글쓰기</button><br>
<%-- 					</c:if> --%>
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget post_category_widget">
							<h4 class="widget_title">Category</h4>
							<ul class="list cat-list">
								<li>
									<a href="blogForm.do?idx=5&no=${session_no }" class="d-flex"><p>전체보기</p></a>
								</li>
								<li>
									<a href="blogForm.do?idx=6&no=${session_no }" class="d-flex"><p>내글보기</p></a>
								</li>
								<li>
									<a href="blogForm.do?idx=1&no=${session_no }" class="d-flex"><p>한식</p></a>
								</li>
								<li>
									<a href="blogForm.do?idx=2&no=${session_no }" class="d-flex"><p>중식</p></a>
								</li>
								<li>
									<a href="blogForm.do?idx=3&no=${session_no }" class="d-flex"><p>일식</p></a>
								</li>
								<li>
									<a href="blogForm.do?idx=4&no=${session_no }" class="d-flex"><p>양식</p></a>
								</li>
							</ul>
						</aside>
					</div>
				</div> <!-- 우측 바 메뉴 끝 -->
			</div>
		</div>
	</section>

	<script type="text/javascript">
		$("#btnBlogDetailWrite").on('click', function(){
			location.href = "blogDetailForm.do";
		});
	</script>
<%@ include file="../include/footer.jsp"%>