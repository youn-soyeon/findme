<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
<br>
<br>
<br>
<br>
<div id="content" class="container">
	<div class="row">
		<div class="col-sm-6">
			<div id="mapDiv" style="width: 500px; height: 500px;"></div>
		</div>
		<div id="contentDiv" class="col-sm-6">
			<div class='card mb-3'>
				<h4 class='card-header' id='findDateH6'>물건 습득일 :
					${finditem.fDate}</h4>
				<div class='card-body'>
					<h5 class='card-subtitle text-muted' style='float: right;'>
						작성자 : <a href='sendMsg.jsp?receiverId=${finditem.writer}'
							id='writerIdH3'>${finditem.writer}</a>
					</h5>
				</div>
				<img style='display: block; height: 300px'
					src='./resources/${finditem.fPicture }' alt='Card image'>
				<div class='card-body'>
					<p class='card-text' id='contentsP'>${finditem.fContent }</p>
				</div>
				<div class='card-footer text-muted' id='hashtagDiv'>${finditem.fHashtag }</div>
			</div>
		</div>
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
<!--Daum Address API-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!--Daum Map API-->
<!-- services 라이브러리 불러오기 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8180e5d2870cf4ded0953dc8f1e5c7d1&libraries=services,clusterer,drawing"></script>

<!--my script-->
<script>
	function init() {
		// 서블릿에서 markerList, searchAddr 받아오기 = 마커 정보들
		console.log('${finditem.fAddress}')
		var searchAddr = '${finditem.fAddress}'.split(" (")[0];
		console.log(searchAddr);

		var mapContainer = document.getElementById('mapDiv'), // 지도를 표시할 div 
		mapOption = {
			center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};
		
		// 마커의 이미지 주소
		var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png'; 

		// 지도를 생성합니다    
		var map = new daum.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new daum.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(searchAddr, function(result, status) {

			// 정상적으로 검색이 완료됐으면 
			if (status === daum.maps.services.Status.OK) {

				var coords = new daum.maps.LatLng(result[0].y, result[0].x);

				// 마커 이미지의 이미지 크기 입니다
			    var imageSize = new daum.maps.Size(24, 35); 
			    
			    // 마커 이미지를 생성합니다    
			    var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize); 
			    
			    
			   var marker = new daum.maps.Marker({
					map : map,
					position : coords,
			        image : markerImage, // 마커 이미지 
			        clickable: true,
				});

				// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				map.setCenter(coords);
			}
		});

	}

	window.onload = init();
</script>
</body>
</html>