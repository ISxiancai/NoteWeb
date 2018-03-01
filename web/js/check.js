function check() {
		var name = document.getElementById('libusername').value;
		var pwd = document.getElementById('libpassword').value;
		var email = document.getElementById('libemail').value;
		var nameflag = document.getElementById('libusernamenotice');
		var pwdflag = document.getElementById('libpasswordnotice');
		var emailflag = document.getElementById('libemailnotice');
		
		var temp1 = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;    //邮箱
		var temp2 =  /^[a-zA-Z0-9]+$/;     // 字母 数字
		var temp3 = /^[a-zA-Z0-9\u4e00-\u9fa5]+$/;  // 字母数字汉字
		
		if(name==''||name==null||pwd==''||pwd==null||email==''||email==null){
				if(name==''||name==null){
					nameflag.innerHTML="看这里忘记填写了？";
				}else {
					nameflag.innerHTML="";
				}
				 if(pwd==''||pwd==null){
					pwdflag.innerHTML="看这里忘记填写了？";
				 }else{
					 pwdflag.innerHTML="";
				 }
				if(email==''||email==null){
					emailflag.innerHTML="看这里忘记填写了？";
				}else{
					emailflag.innerHTML="";
				}
				return false;
		}else if(!temp3.test(name)||!temp2.test(pwd)||!temp1.test(email)){
			if(!temp3.test(name)){
			nameflag.innerHTML="用户名为只能输入中文、英文、数字!";
		}else{
			nameflag.innerHTML="";
		}
			
		if(!temp2.test(pwd)){
			pwdflag.innerHTML="密码由英文、数字组成!";
		}else{
			 pwdflag.innerHTML="";
		} if(!temp1.test(email)){
			emailflag.innerHTML="邮箱格式不正确！";
		}
		else{
			emailflag.innerHTML="";
		}
		 return false;
		}
		else{return true;}
	}
