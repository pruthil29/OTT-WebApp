<%@ page import="java.sql.*" %>
<%@ page import="util.DBConnection" %>
<link rel="stylesheet" type="text/css"
          href="style.css"> 

<%
    Connection con = DBConnection.getConnection();
    if(con != null){
        out.println("DATABASE CONNECTED SUCCESSFULLY");
    } else {
        out.println("DATABASE CONNECTION FAILED");
    }
%>