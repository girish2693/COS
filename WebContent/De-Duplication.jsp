<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.*"%>
<%@ page import="com.dao.Deduplication_DAO"%>
<%@ page import="com.listener.ApplicationListener"%>
<%@ page import="java.sql.Connection,java.sql.SQLException,java.util.List,java.util.Iterator"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>De-Duplication</title>
<script type="text/javascript" src="JS/Validate_dedup.js"></script>

<style type="text/css">

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
<body align=center>
	<%!String acc_holder = "";
	String acc_num = "";
	int c = 0;%>
	<%
		Connection conn = (Connection) request.getServletContext().getAttribute("connection");
	Deduplication_DAO ddao = new Deduplication_DAO();
	List<Account> al = ddao.getAccounts(conn);
	session.setAttribute("acc", al);
	Iterator<Account> it = al.iterator();
	%>
	
		<h1 align=center class=h1>De-Duplication</h1>
		<br> <br>
		<div class="container-fluid">
		<form action="Dedup_Servlet" method=post>
			<table align=center class="table table-hover">
			<thead>
				<tr>
					<th>Check</th>
					<th>Account Number</th>
					<th>Account Holder Name</th>
					<th>Address Line1</th>
					<th>Address Line2</th>
					<th>City</th>
					<th>PinCode</th>
					<th>Contact Number</th>
					<th>Date Of Birth</th>
					<th>Status</th>
					<th>Pan Number</th>
				</tr>
				</thead>
				<tbody>
				<%
					while (it.hasNext()) {
					System.out.println(++c);
					Account ac = it.next();
					
					acc_num = ac.getAccount_number();
				%>
				
				<tr>
					<td scope="row"><input type="checkbox" name="cb" value="<%=acc_num%>"></td>
					<td><%=acc_num%></td>
					<%
						acc_holder = ac.getFirst_name() + " " + ac.getMid_name() + " " + ac.getLast_name();
					%>
					<td><%=acc_holder%></td>
					<td><%=ac.getAddress()%></td>
					<td align=center>---</td>
					<td><%=ac.getCity()%></td>
					<td><%=ac.getPin()%></td>
					<td><%=ac.getMobile_num()%></td>
					<td><%=ac.getDate_of_birth()%></td>
					<td><%=ac.getStatus()%></td>
					<td><%=ac.getPan()%></td>
				</tr>
				
				<%
				
					}
				c=0;
				%>
				<tr><td>&emsp;</td></tr>
				<tr>
					<td colspan=11 align=center><input type="submit" value="De-duplicate"
						name="de-duplicate" onclick="return p_d_equal()">&emsp;
						<input type="reset" value=Refresh name="refresh" onclick="location.href='De-Duplication.jsp'">&emsp;
						<input type="button" name="back" value="Back" onclick="location.href='Customer_One_System_Main.html'"></td>
				</tr>
				</tbody>
			</table>
		</form>
		<br><br><br>
		</div>
	<div class="footer">
  <h2>Welcome to ABC Bank !!!</h2>
</div>

</body>
</html>