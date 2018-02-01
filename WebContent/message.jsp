<%@page import="com.findme.model.vo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.findme.model.dao.MessageDAO"%>
<%@page import="com.findme.model.dao.MessageDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
<br>
<br>
<br>

<br>
<div id="content" class="container">
	<div id="tabBar" class="row">
		<ul class="nav nav-tabs">
			<li id="receiveLi" class="nav-item"><a class="nav-link active show"
				data-toggle="tab" href="#receiveMsgDiv">받은쪽지함</a></li>
			<li id="sendLi" class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#sendMsgDiv">보낸쪽지함 </a></li>
		</ul>

	</div>
	<div class="row">
		<div class="col-sm-7">
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade active show" id="receiveMsgDiv">
					<br> <br>
					<table class="table table-hover" >
						<thead>
							<tr class="table-info" style="color: black;">
								<th scope="col">쪽지번호</th>
								<th scope="col">제목</th>
								<th scope="col">보낸사람</th>
								<th scope="col">날짜</th>
							</tr>
						</thead>
						<tbody id="receiveMsg">
							<c:forEach items="${receiveList}" var="receiveMsg">
								<tr class="table-secondary">
									<td name="receiveIdTd" scope="row">${receiveMsg.msgId}</td>
									<td name="receiveTitleTd">${receiveMsg.msgTitle}</td>
									<td name="receiveSenderTd">${receiveMsg.sender}</td>
									<td name="receiveDateTd">${receiveMsg.msgDate}</td>
									<input name="receiveContentInput" type="hidden" value="${receiveMsg.msgContent }"/>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="tab-pane fade" id="sendMsgDiv">
					<br> <br>
					<table class="table table-hover" >
						<thead>
							<tr class="table-success" style="color: black;">
								<th scope="col">쪽지번호</th>
								<th scope="col">제목</th>
								<th scope="col">받는사람</th>
								<th scope="col">날짜</th>
							</tr>
						</thead>
						<tbody id="sendMsg">
							<c:forEach items="${sendList}" var="sendMsg">
								<tr class="table-secondary">
									<td name="sendIdTd" scope="row">${sendMsg.msgId}</td>
									<td name="sendTitleTd">${sendMsg.msgTitle}</td>
									<td name="sendReceiverTd">${sendMsg.receiver}</td>
									<td name="sendDateTd">${sendMsg.msgDate}</td>
									<input name="sendContentInput" type="hidden" value="${sendMsg.msgContent }"/>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div id="msgContentDiv" class="col-sm-5"></div>
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
	var msgHtml = '<br><br><div class="card mb-3">'
		+ '                <h3 id="msgSenderH3" class="card-header"> </h3>'
		+ '                <div class="card-body">'
		+ '                    <h6 id="msgDatdH6" class="card-subtitle text-muted">수신일 : </h6>'
		+ '                </div>'
		+ '                <div class="card-body">'
		+ '                    <p id="contentP" class="card-text"></p>'
		+ '                </div>'
		+ '            </div>';
		
	function init() {
		
		$('#receiveLi').click(function() {
			$("#msgContentDiv").empty();
		})
		$('#sendLi').click(function() {
			$("#msgContentDiv").empty();
		})

		$('#receiveMsg').children('tr').click(function () {
			$("#msgContentDiv").empty();
			$("#msgContentDiv").append(msgHtml);
			$('#msgSenderH3').append($(this).children('td[name="receiveSenderTd"]').text());
			$('#msgDatdH6').append($(this).children('td[name="receiveDateTd"]').text());
			$('#contentP').append($(this).children('input[name="receiveContentInput"]').val());
			
			//alert($(this).children('input[name="receiveContentInput"]').val());
		});
		
		$('#sendMsg').children('tr').click(function () {
			$("#msgContentDiv").empty();
			$("#msgContentDiv").append(msgHtml);
			$('#msgSenderH3').append($(this).children('td[name="sendReceiverTd"]').text());
			$('#msgDatdH6').append($(this).children('td[name="sendDateTd"]').text());
			$('#contentP').append($(this).children('input[name="sendContentInput"]').val());
			$('#resendMsgBtn').cilck(function() {
				alert('ㅎㅎㅎ');
			});
		})
		

		
	}
	
	window.onload = init();
</script>



</body>
</html>