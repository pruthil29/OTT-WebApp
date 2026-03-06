
<%@ page import="model.Movie"%>
<%
    Movie m = (Movie) request.getAttribute("movie");
%>

<h2>Edit Movie</h2>
<link rel="stylesheet" type="text/css"
          href="style.css"> 
<form action="UpdateMovieServlet" method="post">
    <input type="hidden" name="id" value="<%= m.getId() %>">

    Title:
    <input type="text" name="title"
           value="<%= m.getTitle() %>" required><br><br>

    Genre:
    <input type="text" name="genre"
           value="<%= m.getGenre() %>" required><br><br>

    Description:
    <input type="text" name="description"
           value="<%= m.getDescription() %>" required><br><br>

    <input type="submit" value="Update Movie">
</form>