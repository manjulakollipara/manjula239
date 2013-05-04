<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome</title>
</head>
<body>
<h3 align='center'> Welcome to CMPE239 - Web and Data Mining Project</h3>
<div align="center">
<form action="search" method="post" >
	<p>Enter Search text,City name here:</p>
	<input type="text" size=60 style="font-size:16pt;height=80px" name="businessText"/>
	<input type="text" size=60 style="font-size:16pt;height=80px" name="cityText"/>
	<input type="submit" style="font-size:16pt;"  name="Search"/>
</form>
</div>
</body>
</html>