<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<div id="content" class="container">
	<br>
	<br>
	<br>
	<p style="font-size: 50px; text-align: center; color: black;">F I N
		D M E</p>
	<br>
	<br>
	<div class="row" style="margin: auto; text-align: center;">

		<div class="col-md-1"></div>
		<div class="col-lg-2">
			<button id="addrSearchBtn" class="btn btn-outline-info">주소
				검색</button>
		</div>
		<div class="col-md-8">
			<form method="post" action="addrSearch.do">
				<div class="input-group">
					<input id="addrInput" name="addrInput" type="text" class="form-control"
						aria-label="Amount (to the nearest dollar)" >
					<div class="input-group-append">
						<button id="searchByAddrBtn" class="btn btn-primary">검색</button>
						<input type="hidden" id="hiddenBname" name="searchBname">
					</div>
				</div>
			</form>
			<div class="col-lg-1"></div>
		</div>
	</div>
	<div id="footer" class="container">
		<jsp:include page="footer.jsp" />
	</div>

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
	integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
	crossorigin="anonymous"></script>
<!--Daum Addres API-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!--my script-->
<script>
	
	function init() {
		addrSearchBtn.onclick = addrPopOpen;
	}
	
	function addrPopOpen() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var fullAddr = ''; // 최종 주소 변수
				var extraAddr = ''; // 조합형 주소 변수

				// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					fullAddr = data.roadAddress;

				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					fullAddr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
				if (data.userSelectedType === 'R') {
					//법정동명이 있을 경우 추가한다.
					if (data.bname !== '') {
						extraAddr += data.bname;
					}
					// 건물명이 있을 경우 추가한다.
					if (data.buildingName !== '') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
					fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')'
							: '');
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('addrInput').value = fullAddr;
				document.getElementById('hiddenBname').value = data.bname;
			}
		}).open();
	}

	window.onload = init();
</script>
</body>
</html>