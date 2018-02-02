<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
<div id="content" class="container">
	<br> <br> <br>
	<p style="font-size: 50px; text-align: center; color: black;">F I N
		D M E</p>
	<br>
	<div class="row" style="margin: auto; text-align: center;">
		<div class="container text-center">
			<h3>전체 분실물 모아보기</h3>
			<br> <p style="margin: auto; text-align: center; font-size:28px; color:black;">습득물</p>
				<div class="row">
					<c:forEach items="${findList}" var="findItem">
					<div class="col-sm-4" name="onePost">
					<input type="hidden" name="hiddenFId" value="${findItem.fId }">
							<img src="./resources/${findItem.fPicture }"
								class="img-responsive" alt="Image"
								style="width: 100%; height: 150px;">
							<p>${findItem.fAddress}</p>
							<p>${findItem.fHashtag}</p>
						</div>
					</c:forEach>
					<br> <br> <br> <br>
				</div>
				<br> <br> <br><br>
			</div><br> 
			<br> <br> <br> <br> <br> <br> <br><br> <br> <br> <br>
			<p style="margin: auto; text-align: center; font-size:28px; color:black;">분실물</p>
			<div class="row">
				<c:forEach items="${lostList}" var="lostItem">
					<div class="col-sm-4" name="onePost">
                	 <input type="hidden" name="hiddenFId" value="${lostItem.lId }">
						<img src='./resources/${lostItem.lPicture }'
							class="img-responsive" style="width: 100%; height: 150px;"
							alt="Image">
						<p>${lostItem.lAddress}</p>
						<p>${lostItem.lHashtag}</p>
					</div>
				</c:forEach>

			</div>
		</div>
		<br>
	</div>

<br>
<br>
<br>
<br>
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
<!--my script-->
<script>
	/* <c:forEach  var="i"  items="${hashList}" begin="0" end="${hashList.size()}">
	 ${i.fHashtag}
	 ${i.fHashtag}// 추가하고 싶은거 해서 하기.
	 </c:forEach> */

	function init() {
		 $('div[name="onePost"]').click(function () {
				location.href='detail.do?fId='+$(this).children('input[name="hiddenFId"]').val();
			});
	}
	window.onload = init();
</script>
</body>
</html>