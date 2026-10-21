<%@ page import="java.sql.*" %>
<%
String id=request.getParameter("id");
if(request.getParameter("update")==null){
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
PreparedStatement ps=con.prepareStatement("SELECT * FROM employee WHERE id=?");
ps.setInt(1,Integer.parseInt(id));
ResultSet rs=ps.executeQuery();
if(rs.next()){
%>
<html><body><h2>Update Employee</h2>
<form method="post">
<input type="hidden" name="id" value="<%=rs.getInt("id")%>">
Name: <input type="text" name="name" value="<%=rs.getString("name")%>"><br>
Email: <input type="email" name="email" value="<%=rs.getString("email")%>"><br>
Department: <input type="text" name="department" value="<%=rs.getString("department")%>"><br>
Salary: <input type="text" name="salary" value="<%=rs.getDouble("salary")%>"><br>
<input type="submit" name="update" value="Update Employee">
</form></body></html>
<%
}
con.close();
}catch(Exception e){out.println("Error: "+e);}
}else{
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
PreparedStatement ps=con.prepareStatement("UPDATE employee SET name=?,email=?,department=?,salary=? WHERE id=?");
ps.setString(1,request.getParameter("name"));
ps.setString(2,request.getParameter("email"));
ps.setString(3,request.getParameter("department"));
ps.setDouble(4,Double.parseDouble(request.getParameter("salary")));
ps.setInt(5,Integer.parseInt(request.getParameter("id")));
ps.executeUpdate();
con.close();
response.sendRedirect("employee.jsp");
}catch(Exception e){out.println("Error: "+e);}
}
%>
