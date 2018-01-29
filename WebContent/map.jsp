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
			<input id="hiddenAddr" class="form-control" value="${address }"
				type="hidden"> <input id="hiddenList" class="form-control"
				value="${markerList }" type="hidden">
			<div id="mapDiv" style="width: 500px; height: 400px;"></div>
		</div>
		<div id="contentDiv" class="col-sm-6">
			
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
		var markerList = [];
		<c:forEach items="${markerList}" var="marker">
			markerList.push("${marker}");
		</c:forEach>
		console.log(markerList)
		
		var address = document.getElementById('hiddenAddr').value;
		console.log(address);

		var mapContainer = document.getElementById('mapDiv'), // 지도를 표시할 div 
		mapOption = {
			center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 4
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new daum.maps.Map(mapContainer, mapOption);
		
		// 마커의 이미지 주소
		var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png'; 
		
		for (var i = 0; i < markerList.length; i ++) {
			
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new daum.maps.services.Geocoder();
			var addr = markerList[i].split('fAddress=')[1].split('(')[0];
		    
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(addr, function(result, status) {
				console.log('정상완료 전 addr : ' + addr);
			
				// 정상적으로 검색이 완료됐으면 
				if (status === daum.maps.services.Status.OK) {

					var coords = new daum.maps.LatLng(result[0].y, result[0].x);
					console.log('coords : '+coords);
					// 마커 이미지의 이미지 크기 입니다
				    var imageSize = new daum.maps.Size(24, 35); 
				    
				    // 마커 이미지를 생성합니다    
				    var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize); 
				    
				    
					// 결과값으로 받은 위치를 마커로 표시합니다
					var marker = new daum.maps.Marker({
						map : map,
						position : coords,
				        image : markerImage, // 마커 이미지 
				        clickable: true
					});

					// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					map.setCenter(coords);
					
					daum.maps.event.addListener(marker, 'click', function() {
						$('#contentDiv').empty();
						$('#contentDiv').append(
								"<div class='card mb-3'>"
								+ "<h3 class='card-header' id='writerIdH3'>Writer ID</h3>"
								+"<div class='card-body'>"
									+"<h6 class='card-subtitle text-muted' id='findDateH6'>물건 습득일 : 2018.01.06</h6>"
								+"</div>"
								+"<img style='height: 200px; width: 100%; display: block;' src='data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22318%22%20height%3D%22180%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20318%20180%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_158bd1d28ef%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A16pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_158bd1d28ef%22%3E%3Crect%20width%3D%22318%22%20height%3D%22180%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22129.359375%22%20y%3D%2297.35%22%3EImage%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E' alt='Card image'>"
								+"<div class='card-body'>"
									+"<p class='card-text' id='contentsP'>content.</p>"
								+"</div>"
								+"<div class='card-footer text-muted' id='writerDateDiv'>글 작성일 : 2 days ago</div>"
							+"</div>");
					});
					
				}
			});
			
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(address, function(result, status) {

			    // 정상적으로 검색이 완료됐으면 
			     if (status === daum.maps.services.Status.OK) {

			        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new daum.maps.Marker({
			            map: map,
			            position: coords
			        });

			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new daum.maps.InfoWindow({
			            content: '<div style="width:150px;text-align:center;padding:6px 0;">검색 주소</div>'
			        });
			        infowindow.open(map, marker);

			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			});    
		    
		   
		}
				
		

	}

	window.onload = init();
</script>
</body>
</html>