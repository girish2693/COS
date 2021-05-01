<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.connection.*,java.sql.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<style type="text/css">
body {
	background-color: rgb(96, 6, 68);
}

table {
	text-align: left;
}

td {
	color: white;
}

h1, th {
	color: white;
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
	<h1 class=h1 align=center>Customer Details</h1>
	<br>
	<%!String ci = "";
	String dob = "";%>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	ci = request.getParameter("cid");
	System.out.println("Details page=");
	System.out.println(ci);
	Connection conn = (Connection) request.getServletContext().getAttribute("connection");
	PreparedStatement stmt = conn.prepareStatement(
			"select c.cust_first_name,c.date_of_birth,c.address,c.email_id,c.pan,c.mobile_num,c.occupation,c.salary "
			+ "from customer c  " + "where c.customer_id=?");
	stmt.setString(1, ci);
	ResultSet rs = stmt.executeQuery();
	System.out.println("b4 while");
	while (rs.next()) {
		System.out.println("in while");
	%>
	<div class="container">
		<table align=center class="table table-hover">
			<tr>
				<th>Name</th>
				<th><%=rs.getString(1)%></th>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<%
					dob = rs.getString(2);
				%>
				<td><%=dob.substring(8, 10) + "-" + dob.substring(5, 7) + "-" + dob.substring(0, 4)%></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><%=rs.getString(3)%></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><%=rs.getString(4)%></td>
			</tr>
			<tr>
				<td>PAN Number</td>
				<td><%=rs.getString(5)%></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><%=rs.getString(6)%></td>
			</tr>
			<tr>
				<td>Occupation</td>
				<td><%=rs.getString(7)%></td>
			</tr>
			<tr>
				<td>Monthly Income</td>
				<td><%=rs.getString(8)%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<br>
	<div class="container">
		<table align=center class="table table-bordered">
			<tr>
				<th>Account Number</th>
				<th>Account Type</th>
				<th>Balance</th>
			</tr>
			<%
				stmt = conn.prepareStatement("select account_number,acc_type,balance " + "from account " + "where customer_id=?");
			stmt.setString(1, ci);
			rs = stmt.executeQuery();
			System.out.println("b4 while");
			while (rs.next()) {
				System.out.println("in while");
			%>
			<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getString(2).toUpperCase()%></td>
				<td><%=rs.getString(3)%></td>
			</tr>
			<%
				}
			%>
		</table>

		<br>
		<div align=center>
			<button type="button" class="btn btn-dark"
				onClick="javascript:history.go(-1)">Back</button>
		</div>
	</div>
	<br>
	<br>
	<br>
	<div class="footer">
		<h2>Welcome to ABC Bank !!!</h2>
	</div>
</body>
</html>