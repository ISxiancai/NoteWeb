<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="bean.bean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Note Book Welcome</title>


</head>
<body >
<link href="css/libdiary_style.css" rel="stylesheet" type="text/css" />

<div class="mass">
<%
Date data = new Date();
SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
String topdata1 = format.format(data);

 SimpleDateFormat sdf = new SimpleDateFormat("EEEE");  
    String week = sdf.format(data);  
String topdata = topdata1+week;
	
	
	
%>

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
    <div id="container"> 
<div class="box1 tcenter" style="font-size:14px"><p>“ <font color="#888888">不大可能的事也许今天实现，根本不可能的事也许明天会实现。</font> ”</h3></p></div>  


 
 <div id="bodymain" >

<%
	List<bean> list = (List<bean>)request.getAttribute("list");
// List<bean> list = (List<bean>)session.getAttribute("list");
	if(list ==null||list.size()<1)
{
	out.print("还没有写 Note……");		
}else{
	for(bean bean :list){
		%>
 <!--start-->
<div class="timelist" id="notefirst">
<div>
<div id="diarydetail_it" class="diarydetail"  ><%=bean.getDate() %></div>
<div class="diarybody"><%=bean.getNote() %>

<%-- <a href="deleteservlet?idnote=<%=bean.getIdnote() %>" id="nomore">&nbsp;&nbsp;&nbsp;&nbsp;抹去</a> --%>


<form action="deleteservlet" method="post">
<input id="nomore"  type="submit" value="抹去">
<input type="hidden" name="idnote" value="<%=bean.getIdnote() %>">
</form>
</div><p class="clear"></p>
</div>
 <p class="diaryfrom bdashed"></p></div>
 
 <!--end-->
		
		
		<% 
	}
}

%>


</div>

<div class="clear h80">
<%
int flag=1;
// request.setAttribute("list", list);
// session.setAttribute("list", list);
//System.out.println("jsp_list_"+list);     //   1  

// String moreshow1 ="点击查看更多！";
// String moreshow2 = (String)request.getAttribute("morelist");
// if(moreshow2==null){
%>
<%-- 	<a  id="moreshow" ><%=moreshow1 %></a> --%>
	<% 
// }else{
	%>
<%-- 	<a  id="moreshow" ><%=moreshow2 %></a> --%>
	<% 
// }


%>

<a  id="moreshow" >点击查看更多！</a>
<script type="text/javascript" src="jq/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	/* 点击按钮触发 */
	$("#moreshow").click(function () {
		ajaxFun();
	});

	/* ajax代码部分，从jquery帮助文档可直接拷贝 */
	function ajaxFun() {
		//ajax执行体
		$.ajax({
			//提交方式
			type : "POST",
			//访问servleturl
			url : "moreshowservlet",
			
			data: "flag=1",
			//服务器成功返回结果后，会把结果保存到data中
			success : function(data) {
				//先把表体部分清空
// 				$("#t_body").empty();
				//eval获取返回的JSON对象集合
// 				var d = eval('(' + data + ')');
// 				console.log(data);
				
				if(data.length==0){
					$("#moreshow").text("没有了……");
				}
				
				
				//把数据显示到页面的方法
				showData(data);
			}
		});
	}
	/* 显示数据 */
	
	function showData(d) {
		//循环遍历一边d
		for ( var i = 0; i < d.length; i++) {
			 var html = "<div class='timelist' id='notefirst'>\
				<div>\
				<div id='diarydetail_it' class='diarydetail'  >"+d[i].date+"</div>\
				<div class='diarybody'>"+d[i].note+



				"<form action='deleteservlet' method='post'>\
				<input id='nomore'  type='submit' value='抹去'>\
				<input type='hidden' name='idnote' value='+d[i].idnote+'>\
				</form>\
				</div><p class='clear'></p>\
				</div>\
				 <p class='diaryfrom bdashed'></p></div>";
			//通过表体id把显示文本显示到网页中
			$("#bodymain").append(html);
		}
	}
	});
</script>
</div>
</div>
<div id="containerbottom" class="clear"></div>
</div>
</div></body>
		
</html>