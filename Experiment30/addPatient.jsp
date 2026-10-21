<%@ page import="java.sql.*" %>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
PreparedStatement ps=con.prepareStatement("INSERT INTO patient(name,age,disease,treatment_status) VALUES(?,?,?,?)");
ps.setString(1,request.getParameter("name"));
ps.setInt(2,Integer.parseInt(request.getParameter("age")));
ps.setString(3,request.getParameter("disease"));
ps.setString(4,request.getParameter("treatment_status"));
ps.executeUpdate();
con.close();
response.sendRedirect("patient.jsp");
}catch(Exception e){out.println("Error: "+e);}
%>
