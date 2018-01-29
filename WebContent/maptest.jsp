<%@page import="com.findme.model.vo.Finditem"%>
<%@page import="com.findme.model.dao.FinditemDAO"%>
<%@page import="com.findme.model.dao.FinditemDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
    <div id="content" class="container">
        <div class="row">
            <div class="col-sm-6">
                <div id="mapDiv" style="width:500px;height:400px;"></div>
            </div>
            <div id="contentDiv" class="col-sm-6">
                <div class="card mb-3">
                    <h3 class="card-header">
                    	<c:forEach var="finditem" items="${finditemList}">
                    		<p>finditem.writer</p>
                    	</c:forEach>
                    </h3>
                    <div class="card-body">
                        <h6 class="card-subtitle text-muted"><%FinditemDAO finditemDao2 = new FinditemDAOImpl();
						ArrayList<Finditem> list2 = finditemDao2.getFinditemList();
		
						for (Finditem finditem : list2) {%>
						<%=finditem.getfDate()%><%}%>
               </h6>
                    </div>
                    <img style="height: 200px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22318%22%20height%3D%22180%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20318%20180%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_158bd1d28ef%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A16pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_158bd1d28ef%22%3E%3Crect%20width%3D%22318%22%20height%3D%22180%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22129.359375%22%20y%3D%2297.35%22%3EImage%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" alt="Card image">
                    <div class="card-body">
                        <p class="card-text"><%FinditemDAO finditemDao3 = new FinditemDAOImpl();
									ArrayList<Finditem> list3 = finditemDao3.getFinditemList();
		
									for (Finditem finditem : list3) {%>
										<%=finditem.getfContent()%><%}%></p>
                    </div>
                    <div class="card-footer text-muted">
                        <%FinditemDAO finditemDao4 = new FinditemDAOImpl();
						ArrayList<Finditem> list4 = finditemDao4.getFinditemList();
		
						for (Finditem finditem : list4) {%>
							<%=finditem.getfHashtag()%><%}%>
                    </div>
                </div>
            </div>
        </div>
    </div><br><br><br>

    <div id="footer" class="container">
		<jsp:include page="footer.jsp"/>
    </div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
<!--Daum Addres API-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!--Daum Map API-->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8180e5d2870cf4ded0953dc8f1e5c7d1"></script>

<!--my script-->
<script>
    function  init() {

    
    }

    window.onload = init();
</script>
</body>
</html>