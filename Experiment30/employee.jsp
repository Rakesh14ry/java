<%@ page import="java.sql.*" %>
<html><head><title>Employee Management</title></head><body>
<h2>Employee Management System</h2>
<form action="addEmployee.jsp" method="post">
Name: <input type="text" name="name"><br>
Email: <input type="email" name="email"><br>
Department: <input type="text" name="department"><br>
Salary: <input type="text" name="salary"><br>
<input type="submit" value="Add Employee">
</form>
<h3>Employee Details</h3>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Department</th><th>Salary</th><th>Action</th></tr>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("SELECT * FROM employee");
while(rs.next()){
%>
<tr>
<td><%=rs.getInt("id")%></td>
<td><%=rs.getString("name")%></td>
<td><%=rs.getString("email")%></td>
<td><%=rs.getString("department")%></td>
<td><%=rs.getDouble("salary")%></td>
<td><a href="updateEmployee.jsp?id=<%=rs.getInt("id")%>">Update</a> | <a href="deleteEmployee.jsp?id=<%=rs.getInt("id")%>">Delete</a></td>
</tr>
<%
}
con.close();
}catch(Exception e){out.println("Error: "+e);}
%>
</table>
</body></html>
