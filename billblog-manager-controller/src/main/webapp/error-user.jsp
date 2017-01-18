<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>错误页面</title>
</head>
<body>
	<h2 style="text-align:center;">出错了！</h2>
	<div style="text-align:center;">
		<span>${param.errinfo}</span><br>
		<p>
			<a href="http://jaybill.tunnel.qydev.com/billblog-manager-controller/regist.jsp">
			请点击此处重新注册<<
			</a>
		</p>
	</div>
</body>
</html>