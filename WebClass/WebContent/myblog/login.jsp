<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.dimigo.vo.UserVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>LogIn</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="/WebClass/css/signin.css">
<link rel="stylesheet" href="/WebClass/css/main.css">

</head>
<body>
<div class="container">

  <form class="form-signin" action="/WebClass/bloglogin" method="post">
    <h2 class="form-signin-heading">Please sign in</h2>
    <%UserVo user = (UserVo)session.getAttribute("user"); %>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" name="id" id="inputEmail" class="form-control" placeholder="Email address" required autofocus <%if(user!=null) {%> value="<%=user.getId() %>"<%} %>>
    
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="pw" id="inputPassword" class="form-control" placeholder="Password" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  </form>
  
  

</div>

<%@ include file="modal.jsp" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<script>
	<%-- 로그인이 실패한 경우 처리 추가 --%>
	<%
	if("error".equals(request.getAttribute("msg"))) {
	%>
		var myModal = $('#mymodal');
		myModal.find('.modal-title').text('Login Error');
		myModal.find('.modal-body').text('Invalid username or password');
		myModal.modal();
		<% }%>
</script>

</body>
</html>