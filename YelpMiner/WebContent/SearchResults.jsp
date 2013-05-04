<%@page import="com.sjsu.cmpe239.dto.RapidMinerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>
<body>
	<table>
    <c:forEach items="${map}" var="entry">
    <tr>
        <td>${entry.key}</td>
	    <td>${entry.value}</td>
	</tr>
    </c:forEach>
	</table>
</body>
</html>