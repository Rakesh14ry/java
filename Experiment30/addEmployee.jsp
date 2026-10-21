<%@ page import="java.sql.*" %>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
PreparedStatement ps=con.prepareStatement("INSERT INTO employee(name,email,department,salary) VALUES(?,?,?,?)");
ps.setString(1,request.getParameter("name"));
ps.setString(2,request.getParameter("email"));
ps.setString(3,request.getParameter("department"));
ps.setDouble(4,Double.parseDouble(request.getParameter("salary")));
ps.executeUpdate();
con.close();
response.sendRedirect("employee.jsp");
}catch(Exception e){out.println("Error: "+e);}
%>
