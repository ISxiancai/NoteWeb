<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 超
  Date: 2017/5/22
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Note Book 登录</title>
</head>
<body>


<link href="css/libdiary_signin.css" rel="stylesheet" type="text/css" />
<div id="top" class="mass">
	<div id="liblogo"><img src="img/libdiary_pure.png" alt="唯记. 日记本儿" width="160" height="50" border="0" /></div>
</div>
<div id="main" class="mass">
<div class="leftpart"></div>
<div class="rightpart">
<%  
String error = request.getAttribute("error")!=null?request.getAttribute("error").toString():"";

     String username = "";
     String password = "";
     //获取当前站点的所有Cookie
     Cookie[] cookies = request.getCookies();
     for (int i = 0; i < cookies.length; i++) {
    	 //对cookies中的数据进行遍历，找到用户名、密码的数据                 
         if ("username".equals(cookies[i].getName())) {
             username = cookies[i].getValue();
             username = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
         } else if ("password".equals(cookies[i].getName())) {
             password = cookies[i].getValue();
         }
     }
 
%>
 	<form method="post" action="loginservlet" nsubmit="return check()" >
    <div class="libinblock">
    <p class="notice" id="notice"><%=error %></p>
    <p class="label"><br />用户名</p>
    <p class="input"><input type="text" maxlength="15" id="libusername" name="libusername"  value="<%=username %>" /></p>
     </div>
    <div class="libinblock">
    <p class="label"><br  />密码</p>
    <p class="input"><input type="password" id="libpassword" maxlength="15" name="libpassword" value="<%=password %>" /></p>
</div>
<div class="libinblock" style="text-align:right;font-size:13px;color:#949494"><br />
        <label><input name="libloglong" type="checkbox" value="yes"  />记住账号密码</label></div>
    <div id="libenter" class="libinblock"><a href="create.jsp" title="注册唯记">注 册</a>
                <input type="submit" id="libiptbtn" name="log" value="登入" /></div>
    </form>
</div><p class="clear"></p></div>

<script type="text/javascript">
	function check() {
		var name = document.getElementById('libusername').value;
		var pwd = document.getElementById('libpassword').value;
		var notice = document.getElementById('notice');
		if(name==""||name==null||pwd==""||pwd==null){
			notice.innerHTML="用户名或密码不能为空！";
			return false;
		}else{notice.innerHTML="";
			return true;}
	}
</script>

</body>
</html>