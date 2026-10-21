<%@ page import="java.sql.*" %>
<%
String id=request.getParameter("id");
if(request.getParameter("update")==null){
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
PreparedStatement ps=con.prepareStatement("SELECT * FROM patient WHERE patient_id=?");
ps.setInt(1,Integer.parseInt(id));
ResultSet rs=ps.executeQuery();
if(rs.next()){
%>
<html><body><h2>Update Patient</h2>
<form method="post">
<input type="hidden" name="id" value="<%=rs.getInt("patient_id")%>">
Name: <input type="text" name="name" value="<%=rs.getString("name")%>"><br>
Age: <input type="text" name="age" value="<%=rs.getInt("age")%>"><br>
Disease: <input type="text" name="disease" value="<%=rs.getString("disease")%>"><br>
Treatment Status: <input type="text" name="treatment_status" value="<%=rs.getString("treatment_status")%>"><br>
<input type="submit" name="update" value="Update Patient">
</form></body></html>
<%
}
con.close();
}catch(Exception e){out.println("Error: "+e);}
}else{
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
PreparedStatement ps=con.prepareStatement("UPDATE patient SET name=?,age=?,disease=?,treatment_status=? WHERE patient_id=?");
ps.setString(1,request.getParameter("name"));
ps.setInt(2,Integer.parseInt(request.getParameter("age")));
ps.setString(3,request.getParameter("disease"));
ps.setString(4,request.getParameter("treatment_status"));
ps.setInt(5,Integer.parseInt(request.getParameter("id")));
ps.executeUpdate();
con.close();
response.sendRedirect("patient.jsp");
}catch(Exception e){out.println("Error: "+e);}
}
%>
