<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
<br>
<br>
<br>
<div id="content" class="container">
	<p style="font-size: 30px; text-align: center; color: black;">My
		Page</p>
	<div class="row" style="margin: auto; text-align: center;">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div class="tab-pane fade active show" id="receiveMsgDiv">
				<br> <br>
				<table class="table table-hover">
					<thead>
						<tr class="table-info" style="color: black;"
							style="font-size:20px;">
							<th scope="col">번호</th>
							<th scope="col">날짜</th>
							<th scope="col">주소</th>
							<th scope="col">글쓴이</th>
							<th scope="col">선택</th>
						</tr>
					</thead>
					<tbody id="receiveMsg">
						<c:forEach items="${finditemList}" var="finditem">
							<tr class="table-secondary">
								<td scope="row">${finditem.fId}</td>
								<td>${finditem.fDate}</td>
								<td>${finditem.fAddress}</td>
								<td>${finditem.writer}</td>
								<td><input type="checkbox"></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-1"></div>
		<br>
		<br>
		<br>
	</div>
</div>
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
<!--my script-->
<script>
	function init() {
		/* 		$('#joinBtn').click(function() {
		 //alert('id : ' + $('#memid').val() + ' / pw : ' + $('#password').val() + ' / pwck : ' + $('#password_check').val());
		
		 }) */
	}

	window.onload = init();
</script>
</body>
</html>