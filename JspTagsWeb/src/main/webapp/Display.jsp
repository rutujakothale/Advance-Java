<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Display Jsp file executed</h1>
	
	<%
		ArrayList<String> arr=(ArrayList<String>) request.getAttribute("arraylist");
		for(String s:arr){
	%>
	<h1><%= s %></h1>
	<% } %>
	
</html>