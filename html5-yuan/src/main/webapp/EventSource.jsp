<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>html5消息传递Demo</title>
</head>
<body>
	<div id="result"></div>
	<div id="connect"></div>
	<div>在连接建立状态下 值的改变是从response 中刷新获取到的 所有后台记得对 response 进行flush</div>
</body>
<script type="text/javascript">
	//检测 浏览器是否支持消息传递
	if (typeof (EventSource) !== "undefined") {
		var source = new EventSource("Html5Servlet");
		source.onmessage = function(event) {
			document.getElementById("result").innerHTML = event.data +"<br />";
		};
		source.onopen = function(){
			document.getElementById("connect").innerHTML = "连接已建立";
		};
		source.onerror = function(){
			document.getElementById("connect").innerHTML = "连接已断开,请求一次结束,建立下次请求";
		}
		
	}
</script>
</html>