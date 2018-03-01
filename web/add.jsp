<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/libdiary_style.css" rel="stylesheet" type="text/css" />

</head>
<body onbeforeunload="return out();">
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
<div id="libmain">
	<form method="post" action="addservlet"  onsubmit="return check()" >
	
	
	
    <div id="container"> 
    <div id="bodymain" style="width:500px;padding:25px;">
  	 		 <h3 style="line-height:150%;">New Note</h3>
  			  <textarea id="diarybody" name="libdiarybody" maxlength="150" onKeyUp="javascript:checkWord(this);" onMouseDown="javascript:checkWord(this);"></textarea>
  			  <span id="spannum" ></span>
   		 </div>
   		 
   		 
   		 


<p class="pdtop15"><input type="submit" id="libiptbtn" name="done" style="width:100px;" value="好了"  onclick="isSubmit=true" /></p>

    <div class="clear"></div></div><div id="containerbottom" class="clear"></div>
</form>
</div>

</div></body>

<script type="text/javascript" src="js/add.js">

</script>

</html>