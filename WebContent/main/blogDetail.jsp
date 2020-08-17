<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section class="login_part section_padding ">
	<div class="container">
		<div class="row align-items-center">
			<form class="row contact_form" action="blogDetailForm.do" method="post" > 
				<div class="col-lg-6 col-md-6">
					<div class="login_part_text text-center">
						<div class="login_part_text_iner">
							<h2>New to our Shop?</h2>
							<p>There are advances being made in science and technology
								everyday, and a good example of this is the</p>
							<a href="blogDetailForm.do" class="btn_3">파일 업로드</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="login_part_form">
						<div class="login_part_form_iner">
							<h3>
								당신만의 ! <br> 레시피를 등록해보세요!
							</h3>
							<div class="col-md-12 form-group p_star" >
								<input type="text" class="form-control" id="title" name="title" placeholder="제목" >
							</div>
							<div class="col-md-12 form-group p_star" >
								<input type="text" class="form-control" id="title" name="title" placeholder="요리소개" >
							</div>
							<div class="col-md-12 form-group p_star" >
								카테고리
								<select name="type2" data-trigger="" name="choices-single-defaul">
									<option value="pork">돼지</option>
									<option value="beef">소</option>
									<option value="chicken">닭</option>
								</select>
								<select name="type3" data-trigger="" name="choices-single-defaul">
									<option value="boiled">찜</option>
									<option value="grilled">구이</option>
									<option value="raw">생식</option>
								</select>
								<select name="type1" data-trigger="" name="choices-single-defaul">
									<option value="korean">한식</option>
									<option value="chinese">중식</option>
									<option value="japanese">일식</option>
									<option value="western">양식</option>
								</select>
							</div>
							<div class="col-md-12 form-group p_star" >
								요리정보
								<select name="type2" data-trigger="" name="choices-single-defaul">
									<option value="1">1~2인</option>
									<option value="2">3~4인</option>
									<option value="3">5~10인</option>
								</select>
								<select name="type3" data-trigger="" name="choices-single-defaul">
									<option value="1">1시간 이하</option>
									<option value="2">1시간 이상</option>
									<option value="3">2이간 이하</option>
								</select>
								<select name="type1" data-trigger="" name="choices-single-defaul">
									<option value="1">상</option>
									<option value="2">중</option>
									<option value="3">하</option>
								</select>
							</div>
							<!--
							<div class="col-md-8 form-group"  style="width:90%;">
								<div class="input-select">
									
									
								</div>
								<div class="input-select">
									
								</div>
								<div class="input-select">
									
								</div>
							</div>
							-->
							<div class="col-md-12 form-group p_star">
								<input type="password" class="form-control" id="pw" name="pw" placeholder="재료" >
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="name" name="name" placeholder="UserName" >
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="mail" name="mail" placeholder="E-mail" >
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="addr" name="addr" placeholder="Address" >
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="tel" name="tel" placeholder="Tel" >
							</div>
							<div class="col-md-4 form-group">
								<button type="submit" id="btnInsert" class="btn_3">등록</button>
							</div>
							<div class="col-md-4 form-group">
								<button type="button" id="btnUpdate" class="btn_3">수정</button>
							</div>
							<div class="col-md-4 form-group">
								<button type="button" id="btnDelete" class="btn_3">삭제</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			<!-- 리플 -->
			<div class="comments-area">
				<h4>05 Comments</h4>
				<div class="comment-list">
					<div class="single-comment justify-content-between d-flex">
						<div class="user justify-content-between d-flex">
							<div class="thumb">
								<img src="assets/img/comment/comment_3.png" alt="">
							</div>
							<div class="desc">
								<p class="comment">
                                    Multiply sea night grass fourth day sea lesser rule open subdue female fill which them
                                    Blessed, give fill lesser bearing multiply sea night grass fourth day sea lesser
								</p>
								<div class="d-flex justify-content-between">
									<div class="d-flex align-items-center">
										<h5><a href="#">Emilly Blunt</a></h5>
										<p class="date">December 4, 2017 at 3:12 pm </p>
									</div>
									<div class="reply-btn">
										<a href="#" class="btn-reply text-uppercase">reply</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div> <!-- comments-area 끝 --><!-- --------------------------------------------아렁니ㅏㅓㄹ다절저ㅡ리;어 -->
                  <div class="comment-form">
                     <h4>Leave a Reply</h4>
                     <form class="form-contact comment_form" action="#" id="commentForm">
                        <div class="row">
                           <div class="col-12">
                              <div class="form-group">
                                 <textarea class="form-control w-100" name="comment" id="comment" cols="30" rows="9"
                                    placeholder="Write Comment"></textarea>
                              </div>
                           </div>
                           <div class="col-sm-6">
                              <div class="form-group">
                                 <input class="form-control" name="name" id="name" type="text" placeholder="Name">
                              </div>
                           </div>
                           <div class="col-sm-6">
                              <div class="form-group">
                                 <input class="form-control" name="email" id="email" type="email" placeholder="Email">
                              </div>
                           </div>
                           <div class="col-12">
                              <div class="form-group">
                                 <input class="form-control" name="website" id="website" type="text" placeholder="Website">
                              </div>
                           </div>
                        </div>
                        <div class="form-group">
                           <button type="submit" class="button button-contactForm btn_1 boxed-btn">Send Message</button>
                        </div>
                     </form>
                  </div>
              </div> <!-- 리플 끝 -->
			
		</div>
	</div>
</section>

<script type="text/javascript">

</script>

<%@ include file="../include/footer.jsp"%>