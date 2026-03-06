<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
    <link rel="stylesheet" type="text/css"
          href="style.css"> 
</head>
<body>
    <%
        if(session.getAttribute("username")==null){
            response.sendRedirect("login.jsp");
        }
    %>
    
    <h2>Welcome, ${sessionScope.username}</h2>
    <h2>Login Successful</h2>

    <br><br>
    <a href="LogoutServlet">Logout</a>
</body>
</html>