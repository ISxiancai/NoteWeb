<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
<link href="css/libdiary_style.css" rel="stylesheet" type="text/css" />
<%
Date data = new Date();
SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
String topdata1 = format.format(data);

 SimpleDateFormat sdf = new SimpleDateFormat("EEEE");  
    String week = sdf.format(data);  
String topdata = topdata1+week;
	
	
	
%>
<div class="mass">
<div id="libtop" style="position: relative;">
  	<div id="libtop_left" style="position: absolute;left: 30px;">Today	:  	<%=topdata %></div>
  	<div id="libtop_right">《Hello!  <%=session.getAttribute("name") %>》  <a href="setting.jsp">设置</a> | <a href="quitservlet">登出</a></div>
  	</div>
<div id="libtopbar">
	<div class="addon-menu"><a href="add.jsp">New Note</a></div>
	<div class="menu">
		<a href="findservlet">My Note</a>

	</div>
</div>
<%
String pwd = request.getAttribute("pwdok")!=null?request.getAttribute("pwdok").toString():"";
%>

<div id="libmain">
    <div id="container"> 
    <div id="bodymain" style="width:750px"><!--p class="headintro pdtop29" style="padding-left:90px">你的痕迹，似水流年，消逝不见，这里显示了那些公开的</p-->
<div id="setting" class="box1">
    
<form method="post" action="pwdchangeservlet" onsubmit="return check()">
<label>密码：</label><p><input type="password" id="pwd1" name="libnickname" class="inputbox" maxlength="12" style="width:150px;" /></p>

<label>重复密码：</label><p><input type="password" id="pwd2" name="libnickname" class="inputbox" maxlength="12" style="width:150px;" /></p>
<p class="notice" id="pwdnotice" style="color: red;" ><%=pwd %></p>
<input type="submit" id="libiptbtn" name="done" style="border-width:0px;" value="好了" />
</form>
</div>
</div>
        <div class="clear h80"></div>
        </div>
        <div id="containerbottom" class="clear"></div>
        </div>

</div>
<script type="text/javascript">
function check() {
	var pwd1 = document.getElementById('pwd1').value;
	var pwd2 = document.getElementById('pwd2').value;
	var pwdnotice = document.getElementById('pwdnotice');
	
	if(pwd1==null||pwd2==null||pwd1==''||pwd2==''){
// 		alert("密码输入不为空！");
		pwdnotice.innerHTML="密码忘记写了吗？";
		return false;
	}
	else if(pwd1!=pwd2){
// 		alert("密码输入不一致！");
		pwdnotice.innerHTML="两次密码不一样哦~";
		return false;
	}else{
		return true;
	}
}
</script>
</body>
</html>