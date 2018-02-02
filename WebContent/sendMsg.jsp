<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<div id="content" class="container">
   <br>
   <br>
   <br>
   <p style="font-size: 50px; text-align: center; color: black;">F I N
      D M E</p>

   <div class="row" style="margin: auto; text-align: center;">

      <div class="col-lg-2"></div>
      <div class="col-md-8">
         <form method="post" action="sendmessage.do">
         <fieldset>
            <legend>Send Message</legend>
      <br>
      <br>
      <br>
            
            <table class="table">
               <tr>
                  <td>받는 사람</td>
                  <td colspan="2" class="write-tab-td"><input
                        class="form-control" id="receiver" name="msgReceiver" value="<%= request.getParameter("receiverId") %>"/></td>
               </tr>
            
               <tr>
                  <td>제목</td>
                  <td colspan="2" class="write-tab-td"><input
                        class="form-control" id="title" name="msgTitle" /></td>
               </tr>
              
              
               <tr>
                  <td>글 내용</td>
                  <td colspan="2" class="write-tab-td"><textarea
                        class="form-control" id="contents" name="msgContents" rows="5"></textarea></td>
               </tr>
               
               
 
            </table>
            <button type="submit" class="btn btn-outline-info">보내기</button>
            <button type="reset" class="btn btn-secondary">취소</button>
            <br>
            <br>
            <br>
            <br>
         </fieldset>
         </form>
      </div>
      <div class="col-lg-2"></div>
      <br>
      <br>
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

</body>
</html>