<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="org.dimigo.vo.UserVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	UserVo user = new UserVo();
	user = (UserVo)(session.getAttribute("user"));
	
	%>
	<h1><%=user.getId() %></h1>
	<h1><%=user.getName() %></h1>
	<h1><%=user.getNick() %></h1>

</body>
</html>