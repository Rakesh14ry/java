<%@ page import="java.sql.*" %>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
PreparedStatement ps=con.prepareStatement("DELETE FROM employee WHERE id=?");
ps.setInt(1,Integer.parseInt(request.getParameter("id")));
ps.executeUpdate();
con.close();
response.sendRedirect("employee.jsp");
}catch(Exception e){out.println("Error: "+e);}
%>

