
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.connection.*,java.sql.*,java.io.*,java.util.*,com.dao.*,com.model.*,com.controller.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Customers</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<style type="text/css">
body{
background-color : rgb(32, 128, 0);
}
td,th,h1{
color : white;
}
a{
    text-decoration: none;
    color: rgb(255, 77, 255);
}
a:hover{
text-decoration: none;
    color: rgb(153, 230, 230);
}
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: plum;
	color: white;
	text-align: center;
}
</style>
</head>
<body>
	<h1 class=h1 align=center>List Of Customers</h1>

	<%!String name = "";
	String ci = "";
	String dob = "";%>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	ArrayList<Customer> lc = (ArrayList<Customer>) session.getAttribute("slist");
	%>
	<div class="container-fluid">
		<table align=center class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>CustomerID</th>
					<th>Date Of Birth</th>
					<th>EmailID</th>
					<th>Pan Number</th>
					<th>Contact Number</th>
				</tr>
			</thead>
			<tbody>
				<%
				if(!lc.isEmpty()){
					System.out.println("if data");
				Iterator<Customer> it=lc.iterator();
					while (it.hasNext()) {
					Customer c = it.next();
					ci = c.getCustomer_id();
				%>
				<tr>
					<td scope="row"><%=c.getCust_first_name()%></td>
					<td><a href="Cust_Details.jsp?cid=<%=ci%>"><%=ci%></a></td>
					<%
						dob = c.getDate_of_birth();
					%>
					<td><%=dob.substring(8, 10) + "-" + dob.substring(5, 7) + "-" + dob.substring(0, 4)%></td>
					<td><%=c.getEmail_id()%></td>
					<td><%=c.getPan()%></td>
					<td><%=c.getMobile_num()%></td>
				</tr>
				<%
					}
				}
				else{
					System.out.println("else no data");
				%>
				<tr><td align=center style="color:red">No Data Found!!</td></tr>
				<% } %>
				<tr>
					<td colspan=6 align=center><button type="button" class="btn btn-info" onclick="javascript:history.go(-1)">Back</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<br>
	<br>
	<br>
	<div class="footer">
		<h2>Welcome to ABC Bank !!!</h2>
	</div>
</body>
</html>