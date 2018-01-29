<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">

    <!--Lux Theme-->
    <link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.css" media="screen">
    <link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.min.css">
    <link rel="stylesheet" herf="https://bootswatch.com/4/lux/_variables.scss">
    <link rel="stylesheet" herf="https://bootswatch.com/4/lux/_bootswatch.scss">

    <title>Find Me</title>
    <style>
        .title_content{
            text-align: center;
            color:black;
        }
        .findme{
            font-size: 50px;
        }
        #content{
            margin : auto;
            text-align: center;
        }
    </style>
</head>

    <div id="header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="main.jsp">FIND ME</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor03">
                <ul class="navbar-nav mr-auto">
                    <li>
                        <a class="nav-link" href="#">LIST</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">WRITE</a>
                    </li>
                </ul>
                <input class="form-control mr-sm-3" type="text" placeholder="Search" style="width:70%;">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">JOIN</a>
                        
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">LOGIN</a>
                        
                    </li>
                    
                </ul>
            </div>
        </nav>
    </div>

    <div id="content" class="container">
        <br><br><br>
        <p class="title_content findme">F I N D   M E</p>
        <form method="post" action="./login.do">
            <h5 class="title_content">login</h5>
            <div class="form-group">
                <label for="exampleInputEmail1"  class="addlabel" style="float:left;">ID</label>
                <input type="text" class="form-control" id="exampleInputEmail1" name="memid" placeholder="Enter Your ID">
                <small id="emailHelp" class="form-text text-muted addlabel">We'll never share your ID with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1" class="addlabel" style="float:left;">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" password="password" name="password" placeholder="Password" width="50%">
            </div>
            <button id="loginBtn" type="submit" class="btn btn-outline-info">로그인</button>
            <button id="resetBtn" type="reset" class="btn btn-outline-secondary">취소</button>
        </form>
        <br><br>
    </div>
    <div id="footer" class="container">
        <div class="row">
            <div class="col-lg-12">
                <hr>
                <ul class="list-unstyled">
                    <li class="float-lg-right"><a href="#top">Back to top</a>.</li>
                </ul>
                <p>Web : Made by <a href="http://www.findme.com">TwoTwo (Junsu, Suin, Seungsu, Soyeon)<a></p>
                <p>Theme : Made by <a href="http://thomaspark.co">Thomas Park</a>.</p>
                <p>Code released under the <a href="https://github.com/thomaspark/bootswatch/blob/master/LICENSE">MIT License</a>.</p>
                <p>Based on <a href="https://getbootstrap.com" rel="nofollow">Bootstrap</a>. Icons from <a href="http://fontawesome.io/" rel="nofollow">Font Awesome</a>. Web fonts from <a href="https://fonts.google.com/" rel="nofollow">Google</a>.</p>
            </div>
        </div>

    </div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
<!--Daum Addres API-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!--my script-->
<script>
    function  init() {

    }

    window.onload = init();
</script>
</body>
</html>