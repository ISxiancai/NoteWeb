<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>


<link href="css/libdiary_pure.css" rel="stylesheet" type="text/css" />
<div id="top" class="mass">
	<div id="liblogo"><a href="login.jsp">
	<img src="img/libdiary_pure.png" alt="唯记. 日记本儿" width="160" height="50" border="0" /></a></div>
    <div id="libenter"><a href="login.jsp" title="登入唯记">登 录</a></div>
    <p class="clear"></p>
</div>
<div id="main" class="mass">
<%
String nameerror = request.getAttribute("nameerror")!=null?request.getAttribute("nameerror").toString():""; 
%>

<form method="post" action="createservlet" onsubmit="return check()">


<div class="libinblock"><p class="label">用户名</p><p class="input">

<input type="text" id="libusername" name="libusername" value="" maxlength="15" />

</p>
    <p id="libusernamenotice" class="notice"><%=nameerror %></p></div>
    <div class="libinblock"><p class="label">密码</p><p class="input">
    
    <input type="password" id="libpassword" name="libpassword" maxlength="15" value="" />
    
    </p>
    <p id="libpasswordnotice" class="notice"></p></div>
  <div class="libinblock"><p class="label">邮箱</p><p class="input">
  
  <input type="text" id="libemail" name="libemail" value="" />
  
  </p>
    <p id="libemailnotice" class="notice"></p></div>
    <div class="libinblock" style="width:100px;">
    
    <input type="submit" id="libiptbtn" name="libreg" value="注册" />
    
    </div>
</form>
</div>
<script type="text/javascript" src="js/check.js">
	

</script>

</body>
</html>