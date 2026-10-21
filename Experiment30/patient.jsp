<%@ page import="java.sql.*" %>
<html><head><title>Patient Management</title></head><body>
<h2>Patient Management System</h2>
<form action="addPatient.jsp" method="post">
Name: <input type="text" name="name"><br>
Age: <input type="text" name="age"><br>
Disease: <input type="text" name="disease"><br>
Treatment Status: <input type="text" name="treatment_status"><br>
<input type="submit" value="Add Patient">
</form>
<h3>Patient Records</h3>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Age</th><th>Disease</th><th>Treatment Status</th><th>Action</th></tr>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("SELECT * FROM patient");
while(rs.next()){
%>
<tr>
<td><%=rs.getInt("patient_id")%></td>
<td><%=rs.getString("name")%></td>
<td><%=rs.getInt("age")%></td>
<td><%=rs.getString("disease")%></td>
<td><%=rs.getString("treatment_status")%></td>
<td><a href="updatePatient.jsp?id=<%=rs.getInt("patient_id")%>">Update</a> | <a href="deletePatient.jsp?id=<%=rs.getInt("patient_id")%>">Delete</a></td>
</tr>
<%
}
con.close();
}catch(Exception e){out.println("Error: "+e);}
%>
</table>
</body></html>
