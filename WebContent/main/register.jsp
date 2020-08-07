<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- Hero Area Start-->
<!-- Hero Area End-->
<!--================login_part Area =================-->
<section class="login_part section_padding ">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 col-md-6">
				<div class="login_part_text text-center">
					<div class="login_part_text_iner">
						<h2>New to our Shop?</h2>
						<p>There are advances being made in science and technology
							everyday, and a good example of this is the</p>
						<a href="loginForm.do" class="btn_3">Login</a>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="login_part_form">
					<div class="login_part_form_iner">
						<h3>
							Welcome ! <br> Please Register to join!
						</h3>
						<form class="row contact_form" action="register.do" method="post" onsubmit="return validate()" >
							<div class="col-md-8 form-group p_star">
								<input type="text" class="form-control" id="id" name="id"
									 placeholder="UserID">
							</div>
							<div class="col-md-4 form-group">
								<button type="button" id="btnOverappedId" class="btn_3 xs float-right" style="padding:10px; margin:0px;">중복확인</button>
								
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="password" class="form-control" id="pw" name="pw"
									 placeholder="Password">
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="name" name="name"
									 placeholder="UserName">
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="mail" name="mail"
									 placeholder="E-mail">
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="addr" name="addr"
									 placeholder="Address">
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="tel" name="tel"
									 placeholder="Tel">
							</div>
							<div class="col-md-12 form-group">

								<button type="submit" id="btnJoin" class="btn_3">등록</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================login_part end =================-->

<script type="text/javascript">
function validate(){
	if($('input[name="id"]').val()==''){
		alert("아이디를 입력하세요");
		id.focus();
		return false;
	}else if($('input[name="pw"]').val()==''){
		alert("패스워드를 입력하세요");
		id.focus();
		return false;
	}else if($('input[name="name"]').val()==''){
		alert("이름을 입력하세요");
		id.focus();
		return false;
	}else if($('input[name="mail"]').val()==''){
		alert("메일을 입력하세요");
		id.focus();
		return false;
	}else if($('input[name="addr"]').val()==''){
		alert("주소를 입력하세요");
		id.focus();
		return false;
	}else if($('input[name="tel"]').val()==''){
		alert("전화번호를 입력하세요");
		id.focus();
		return false;
	}
	return true;
}

	$("#btnOverappedId").on('click', function() {
		$.ajax({
			type : "post",
			url : "overappedId.do",
			data : {
				"id" : $("#id").val()
			},
			async : false,
			dataType : "text",
			success : function(data, textStatus) {
				if (data == 'usable') {
					alert("사용가능한 아이디");
				} else if (data == 'not usable') {
					alert("사용불가능한 아이디");
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

<%@ include file="../include/footer.jsp"%>