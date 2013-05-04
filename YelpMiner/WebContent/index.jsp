<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sjsu.cmpe239.dto.RapidMinerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<style>
body 
{
background-image:url('images/bg1.jpg');
background-repeat:repeat-y;
background-attachment:fixed;
}
</style>

<body>
<h1 align='center'> Welcome to CMPE239 - Web and Data Mining Project</h1>
<h2 align='center'> Project: Sentimental Recommendation System</h2>
<div align="center">
		<Table width="60%" border="0">
			<tr>
				<td>
				<div align="center">			
						<form action="search" method="post" >
						<h2>Enter Search text,City name here:</h2>
						<input type="text" size=30 style="font-size:16pt;height=80px" name="businessText"/>
						<input type="text" size=20 style="font-size:16pt;height=80px" name="cityText"/>
						<input type="submit" style="font-size:16pt;"  name="Search"/>
						</form>
				</div>
					<br>
					<br>
				</td>
			</tr>
			<c:forEach items="${map}" var="entry">
    			<tr>
	    				<td>Business Name: ${entry.bzname}</td>
	    				<tr><td>Address: ${entry.fulladdress}</td></tr>
	    				<tr><td>Number of Reviews: ${entry.review_count}</td></tr>
	    				
						<c:choose>
						<c:when test="${entry.review_stars eq 1}"><img src="images/1Star.png"/>
						</c:when>
						<c:when test="${entry.review_stars eq 2}"><img src="images/2Star.png"/>
						</c:when>
						<c:when test="${entry.review_stars eq 3}"><img src="images/3Star.png"/>
						</c:when>
						<c:when test="${entry.review_stars eq 4}"><img src="images/4Star.png"/>
						</c:when>
						<c:otherwise ><img src="images/5Star.png"/>
						</c:otherwise>
						</c:choose>             
	    				
	    				<td>Overall Stars: ${entry.review_stars}</td>
	    				<tr><td align='left'>${entry.review_text}</td></tr>
				</tr>
				<tr>
				<td><h1>-------------------------------------------------------------------------------</h1></td>
				<td></td>
				</tr>
				<tr>
				</tr>
    		</c:forEach>
		</Table>
</div>
<br>
<div align='center'>
<h3> 2013 San Jose State University. All Rights Reserved:   Designed by Manjula, Pallavi and Sumalatha</h3>
</div>
</body>
</html>