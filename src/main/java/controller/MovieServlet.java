package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import dao.MovieDAO;
import model.Movie;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String keyword = request.getParameter("keyword");
    MovieDAO dao = new MovieDAO();
    List<Movie> movieList;

    if (keyword != null && !keyword.trim().isEmpty()) {

        movieList = dao.searchMovies(keyword);

        if (movieList == null || movieList.isEmpty()) {
            request.setAttribute("message", "Movie Not Found");
            movieList = new ArrayList<>();
        }

    } else {
        movieList = dao.getAllMovies();
    }

    request.setAttribute("movieList", movieList);
    request.getRequestDispatcher("movies.jsp").forward(request, response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String title = request.getParameter("title");
    String genre = request.getParameter("genre");
    String description = request.getParameter("description");
    String image=request.getParameter("image");
    String trailer_link=request.getParameter("trailer_link");
    
    if(title==null || title.trim().isEmpty()||
        genre==null || genre.trim().isEmpty()||
        description == null || description.trim().isEmpty())
    {
        response.sendRedirect("addMovie.jsp");
        return;
    }
    MovieDAO dao = new MovieDAO();
    dao.addMovie(title, genre, description,image,trailer_link);

    response.sendRedirect("MovieServlet");
}
}