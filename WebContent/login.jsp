<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<div id="content" class="container">
	<br>
	<br>
	<br>
	<p style="font-size: 50px; text-align: center; color: black;">F I N
		D M E</p>
	<form method="post" action="./login.do">
		<h5 class="title_content">login</h5>
		<div class="form-group">
			<label for="loginId" class="addlabel" style="float: left;">ID</label>
			<input type="text" class="form-control" id="loginId" name="loginId"
				placeholder="Enter Your ID"> <small id="emailHelp"
				class="form-text text-muted addlabel">We'll never share your
				ID with anyone else.</small>
		</div>
		<div class="form-group">
			<label for="loginPassword" class="addlabel" style="float: left;">Password</label>
			<input type="password" class="form-control" id="loginPassword"
				password="password" name="loginPassword" placeholder="Password"
				width="50%">
		</div>
		<button id="loginBtn" type="submit" class="btn btn-outline-info">로그인</button>
		<button id="resetBtn" type="reset" class="btn btn-outline-secondary">취소</button>
	</form>
	<br>
	<br>
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

	}

	window.onload = init();
</script>
</body>
</html>