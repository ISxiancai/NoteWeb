function check() {
	var diary = document.getElementById('diarybody').value;
	if(diary==""||diary==null){
		alert("你应该有什么要记下的吧……");
		return false;
	}else{return true;}
}
var maxstrlen=150;
function Q(s){return document.getElementById(s);}
function checkWord(c){
    len=maxstrlen;
    var str = c.value;
    myLen=getStrleng(str);
    var wck=Q("spannum");
    if(myLen>len*2){
        c.value=str.substring(0,i+1);
    }
    else{
        wck.innerHTML = '还可以写'+Math.floor((len*2-myLen)/2)+'字';
       }
}
function getStrleng(str){
    myLen =0;
    i=0;
    for(;(i<str.length)&&(myLen<=maxstrlen*2);i++){
    if(str.charCodeAt(i)>0&&str.charCodeAt(i)<128)
    myLen++;
    else
    myLen+=2;
}
return myLen;
}