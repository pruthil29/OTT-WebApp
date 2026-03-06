/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.MovieDAO;
import jakarta.servlet.http.HttpSession;
import model.Movie;
 

@WebServlet("/EditMovieServlet")
public class EditMovieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession(false);
        if(session == null || session.getAttribute("username")==null){
            response.sendRedirect("login.jsp");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));

        MovieDAO dao = new MovieDAO();
        Movie movie = dao.getMovieById(id);

        request.setAttribute("movie", movie);
        request.getRequestDispatcher("editMovie.jsp")
               .forward(request, response);
    }
}