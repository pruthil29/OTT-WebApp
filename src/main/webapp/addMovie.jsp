<h2>Add Movie</h2>
<link rel="stylesheet" type="text/css"
          href="style.css"> 

<form action="MovieServlet" method="post">
    Title: <input type="text" name="title" required><br><br>
    Genre: <input type="text" name="genre" required><br><br>
    Description: <input type="text" name="description" required><br><br>
    Image URL: <input type="text" name="image"><br><br>
    <input type="text" name="trailer_link">

    <input type="submit" value="Add Movie">
</form>

<br>
<a href="MovieServlet">Back to Movies</a>