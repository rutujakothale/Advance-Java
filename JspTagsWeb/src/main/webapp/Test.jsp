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
		<h1>Good AfterNoon</h1>
		
		<%!
		int a= 45;
		
		public int add(){
		return 10+20;
		}
		%>
		
		<!-- Expression tag -->
		<h2>A variable value is <%= a %></h2>
		<h2>add method  value is <%= add() %></h2>
		
		<!-- Scriplet tag -->   to call methods / create methods/ write logic wrt java 
		<%
			ArrayList<String> arr=new ArrayList <String>();
			arr.add("Hello");
			arr.add("HII");
			
			
		%>
		
		<% for(String s:arr){ %>
		
		<table border=1>
			<tr>
			
				<td><%= s %></td>
				
			</tr>
			
		</table>
		<%} %>
</body>
</html>