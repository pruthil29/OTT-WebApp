<!DOCTYPE html>
<html>
<head>
    <title>Create Account</title>
    <link rel="stylesheet" type="text/css"
          href="style.css"> 
</head>
<body>

<h2>Create Account</h2>

<form action="RegisterServlet" method="post">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Create Account">
</form>

<p style="color:red;">
    ${errorMessage}
</p>

</body>
</html>
