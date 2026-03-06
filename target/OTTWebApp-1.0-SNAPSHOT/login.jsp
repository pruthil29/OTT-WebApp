<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css"
          href="style.css"> 
</head>
<body>

<h2>Login</h2>

<form action="LoginServlet" method="post">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>

<p style="color:red;">
    ${errorMessage}
</p>
<br><br>
<a href="register.jsp">Create Account</a>

</body>
</html>