<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<!-- Modal 재료등록 사진, 이름, 단위, 가격-->
    <div
      class="modal fade"
      id="cookIngredient"
      tabindex="-1"
      role="dialog"
      aria-labelledby="cookIngredient"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="cookIngredient">재료 등록</h4>
          </div>
          <div class="modal-body">
          <form method='post' action='' enctype="multipart/form-data">
            <div class="form-group">
              <label>재료명</label>
              <input type="text" class="form-control" placeholder="재료명" id="ingredient" />
            </div>
            <div class="form-group">
              <label>단위</label>
              <input
                type="text"
                class="form-control"
                placeholder="단위"
                id="igdUnit"
              />
            </div>
            <div class="form-group">
              <label>가격</label>
              <input
                type="text"
                class="form-control"
                placeholder="가격"
                id="igdPrice"
              />
            </div>
            <div class="form-group">
              <label>사진</label> 
          	  Select file : <input type='file' id='igdImage' class='form-control' ><br>
         	  <input type='button' class='btn btn-info' value='Upload' id='igd_upload'>
            </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" id="btnIgdIn">
              등록
            </button>
            <button type="button" class="btn btn-default" data-dismiss="modal">
              닫기
            </button>
          </div>
        </div>
        <!-- 모달 콘텐츠 -->
      </div>
      <!-- 모달 다이얼로그 -->
    </div>
    <!-- 모달 전체 윈도우 -->
     <script>     
      $("#btnIgdIn").on('click', function() {
			var query = {
				"ingredient" : $("#ingredient").val(),
				"igdUnit" : $("#igdUnit").val(),
				"igdPrice" : $("#igdPrice").val(),
				"igdImage" : new FormData($("#igdImage")[0])
			};
			$.ajax({
				type : "post",
				url : "shop.do", //수정필요
				data : query,
				contentType: false,
			    processData: false,
				success : function(data, textStatus) {
					if (data == "success") {
						alert("등록 성공");
						modal.modal("hide");
						location.href = "shop.do"; //수정필요
					} else {
						alert("등록 실패");
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