<%@ page import="java.sql.*" %>
<%@ page import="util.DBConnection" %>
<link rel="stylesheet" type="text/css"
          href="style.css"> 

<%
Connection con = DBConnection.getConnection();

if(con == null){
    out.println("Connection NULL");
} else {

    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM users WHERE username='admin' AND password='admin123'"
    );

    ResultSet rs = ps.executeQuery();

    if(rs.next()){
        out.println("MATCH FOUND DIRECTLY");
    } else {
        out.println("NO MATCH IN DB");
    }
}
%>