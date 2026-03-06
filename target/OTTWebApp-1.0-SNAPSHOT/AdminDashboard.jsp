<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            background-color: #121212;
            color: white;
            font-family: Arial, sans-serif;
            text-align: center;
            padding-top: 100px;
        }

        h1 {
            color: #ff4c4c;
            margin-bottom: 40px;
        }

        .btn {
            display: inline-block;
            padding: 12px 25px;
            margin: 15px;
            background-color: #ff4c4c;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 18px;
            transition: 0.3s;
        }

        .btn:hover {
            background-color: #ff0000;
        }
    </style>
</head>
<body>

    <h1>Welcome Admin</h1>

    <a href="MovieServlet" class="btn">Manage Movies</a>
    <a href="LogoutServlet" class="btn">Logout</a>

</body>
</html>