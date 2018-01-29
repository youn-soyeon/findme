<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<br>
<br>
<br>
<br>
<div id="content" class="container">
	<div id="tabBar" class="row">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active show"
				data-toggle="tab" href="#receiveMsg">받은쪽지함</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#sendMsg">보낸쪽지함</a></li>
		</ul>

	</div>
	<div class="row">
		<div class="col-sm-6">
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade active show" id="receiveMsg">
					<br>
					<br>
					<table class="table table-hover">
						<thead>
							<tr class="table-info" style="color: black;">
								<th scope="col">쪽지번호</th>
								<th scope="col">제목</th>
								<th scope="col">보낸사람</th>
								<th scope="col">날짜</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td id="titleTd">안녕하세요 제지갑인거같아요</td>
								<td>test</td>
								<td>18.01.18</td>
							</tr>
							<tr class="table-secondary">
								<th scope="row">Secondary</th>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="tab-pane fade" id="sendMsg">

					<br>
					<br>
					<table class="table table-hover">
						<thead>
							<tr class="table-success" style="color: black;">
								<th scope="col">쪽지번호</th>
								<th scope="col">제목</th>
								<th scope="col">받는사람</th>
								<th scope="col">날짜</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">Default</th>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
							</tr>
							<tr class="table-secondary">
								<th scope="row">Secondary</th>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="msgContentDiv" class="col-sm-6"></div>
	</div>
</div>
<br>
<br>
<br>

<div id="footer" class="container">
	<jsp:include page="footer.jsp" />
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
<!--Daum Map API-->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8180e5d2870cf4ded0953dc8f1e5c7d1"></script>

<!--my script-->
<script>
	function init() {
		$(titleTd)
				.click(
						function name() {
							$("#msgContentDiv").empty()
							$("#msgContentDiv")
									.append(
											'<div class="card mb-3">'
													+ '                <h3 class="card-header">보낸사람</h3>'
													+ '                <div class="card-body">'
													+ '                    <h6 class="card-subtitle text-muted">2018.01.06</h6>'
													+ '                </div>'
													+ '                <div class="card-body">'
													+ '                    <p class="card-text">내애애애용 내애애애애애용</p>'
													+ '                </div>'
													+ '            </div>');
						})
	}
	window.onload = init();
</script>
</body>
</html>
