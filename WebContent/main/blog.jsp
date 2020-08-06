<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
										<img class="card-img rounded-0" src="assets/img/blog/single_blog_5.png" alt="">
									</div>
				
									<div class="blog_details">
										<a class="d-inline-block" href="blogDetailForm.do">
											<h2>${blog.title }</h2>
										</a><br>${blog.content }</p>
<%-- 											<p>${blog.content }</p> --%>
										<ul class="blog-info-link">
											<li><a href="#"><i class="fa fa-user"></i>${blog.cookIndex}</a></li>
											<li><a href="#"><i class="fa fa-comments"></i>${blog.readCount }</a></li>
										</ul>
									</div>
								</article>
	 						</c:forEach> 
						</form>
						<nav class="blog-pagination justify-content-center d-flex">
							<ul class="pagination">
								<li class="page-item">
									<a href="#" class="page-link" aria-label="Previous">
										<i class="ti-angle-left"></i>
									</a>
								</li>
								<li class="page-item">
									<a href="#" class="page-link">1</a>
								</li>
								<li class="page-item active">
									<a href="#" class="page-link">2</a>
								</li>
								<li class="page-item">
									<a href="#" class="page-link" aria-label="Next">
										<i class="ti-angle-right"></i>
									</a>
								</li>
							</ul>
						</nav>
					</div>
				</div> 
				
				<!-- 우측 바 메뉴 시작-->
				<div class="col-lg-4">
					<button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn" type="submit">글쓰기</button><br>
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget post_category_widget">
							<h4 class="widget_title">Category</h4>
							<ul class="list cat-list">
								<li>
									<a href="#" class="d-flex"><p>전체보기</p></a>
								</li>
								<li>
									<a href="#" class="d-flex"><p>내글보기</p></a>
								</li>
								<li>
									<a href="#" class="d-flex"><p>한식</p></a>
								</li>
								<li>
									<a href="#" class="d-flex"><p>일식</p></a>
								</li>
								<li>
									<a href="#" class="d-flex"><p>양식</p></a>
								</li>
								<li>
									<a href="#" class="d-flex"><p>중식</p></a>
								</li>
							</ul>
						</aside>
					</div>
				</div>
			</div>
		</div>
	</section>

<%@ include file="../include/footer.jsp"%>