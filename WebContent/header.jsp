<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
   integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy"
   crossorigin="anonymous">

<!--Lux Theme-->
<link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.css"
   media="screen">
<link rel="stylesheet"
   href="https://bootswatch.com/4/lux/bootstrap.min.css">
<link rel="stylesheet"
   href="https://bootswatch.com/4/lux/_variables.scss">
<link rel="stylesheet"
   href="https://bootswatch.com/4/lux/_bootswatch.scss">

<title>F I N D M E</title>
<style>
#content {
   margin: auto;
   text-align: center;
}
</style>
</head>

<div id="header">
   <nav class="navbar navbar-expand-lg navbar-dark bg-info">
      <a class="navbar-brand" href="/findme">FIND ME</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse"
         data-target="#navbarColor03" aria-controls="navbarColor03"
         aria-expanded="false" aria-label="Toggle navigation">
         <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarColor03">
         <ul class="navbar-nav mr-auto">
            <c:choose>
               <c:when test="${loginMember != null}">
                  <li><a class="nav-link" href="listall.do">LIST</a></li>
                  <li class="nav-item"><a class="nav-link" href="write.jsp">WRITE</a>
                  </li>
               </c:when>
               <c:otherwise>
                  <li><a class="nav-link" href="listall.do">LIST</a></li>
                  <li><a class="nav-link"></a></li>
               </c:otherwise>
            </c:choose>
         </ul>
         <form action="/findme/hashtagsearch.do" method="post">
         	<input class="form-control mr-sm-3" type="text" placeholder="Search" name="hashtagSearch" id="submit"
             style="width: 600px;">
         </form>
            
         <ul class="navbar-nav mr-auto">
            <c:choose>
               <c:when test="${loginMember != null}">
                  <li class="nav-item"><a class="nav-link" href="msgSearch.do"><img
                        src="resources/img/msgOff.png" /></a></li>
                  <li class="nav-item"><a class="nav-link" href="mypage.do">${loginMember.getMemId()}(${loginMember.getPoint()})</a>
                  </li>
                  <li class="nav-item"><a class="nav-link" href="logout.do">LOGOUT</a>
                  </li>
               </c:when>
               <c:otherwise>
                  <li class="nav-item"><a class="nav-link" href="join.jsp">JOIN</a>
                  </li>
                  <li class="nav-item"><a class="nav-link" href="login.jsp">LOGIN</a>
                  </li>
               </c:otherwise>
            </c:choose>

         </ul>
      </div>
   </nav>
</div>
   