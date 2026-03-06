<%@ page import="java.util.List" %>
<%@ page import="model.Movie" %>
<div class="movie-container">
<div class="navbar">
    <div class="logo">OTTflix</div>
    <%
        String role=(String)
                session.getAttribute("userRole");
        if(role == null){
            response.sendRedirect("login.jsp");
            return;
        }
    %>
    <%@page contentType="text/html;
            charset=UTF-8" pageEncoding="UTF-8" %>
    
        <form action="MovieServlet" method="get" class="search-form">
            <input type="text" name="keyword" placeholder="Search Movie...">
            <input type="submit" value="Search"> 
        </form>
    <div class="nav-links">
        <a href="MovieServlet">Home</a>
       <% if(role != null && role.equals("admin")){
       %>
        <a href="addMovie.jsp">Add Movie</a>
        <% } %>
        <a href="LogoutServlet">Logout</a> 
    </div>
</div>
<h2>Movies List</h2>
<link rel="stylesheet" type="text/css"
          href="style.css"> 

<div class="movie-container">

<%
    List<Movie> movieList = (List<Movie>) request.getAttribute("movieList");
    for(Movie m : movieList){
%>
<%
    String message = (String)
            request.getAttribute("message");
    if(message != null){
%>
<h2 style="color:red; text-align:center;"> 🎬 <%= message %> </h2>
<% } %>

<div class="movie-card">
    <%
        String img=m.getImage();
        if(img==null || img.trim().isEmpty()){
            img="https://i.imgur.com/8Km9tLL.jpg";
        }
       %>
    <img src="<%= img %>" class="movie-img">

    <div class="movie-content">
        <div class="movie-title"><%= m.getTitle() %></div>
        <div class="movie-genre">Genre: <%= m.getGenre() %></div>
        <div class="movie-desc"><%= m.getDescription() %></div>
        <%
            String trailer=m.getTrailerLink();
            if(trailer !=null && !trailer.trim().isEmpty()){
            }
           %>
           
           <a href="<%=trailer %>" target="_blank" class="trailer-btn">
               ▶ Watch Trailer
           </a>
           <%
               if(role.equals("admin")){
            %>
               }
        <a href="EditMovieServlet?id=<%= m.getId() %>">Edit</a>
        <a href="DeleteMovieServlet?id=<%= m.getId() %>"
           onclick="return confirm('Are you sure you want to delete this movies?')">
            Delete
        </a>
        <%
            }
        %>
    </div>
</div>

<%
    }
%>

</div>
<%
    if(role != null && role.equals("admin")){
%>
<br><br>
<a href="addMovie.jsp">Add New Movie</a><!--- admin can add movies-->
<%
    }
%>
<br><br>
<a href="LogoutServlet">Logout</a>
