/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.*;
import dao.MovieDAO;

@WebServlet(name = "DeleteMovieServlet", urlPatterns = {"/DeleteMovieServlet"})
public class DeleteMovieServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
     HttpSession session=request.getSession(false);
        if(session == null || session.getAttribute("username")==null){
            response.sendRedirect("login.jsp");
            return;
        }
    
    String title = request.getParameter("title");
    String genre = request.getParameter("genre");
    String description = request.getParameter("description");
    
    int id=Integer.parseInt(request.getParameter("id"));
    MovieDAO dao = new MovieDAO();
    dao.deleteMovie(id);

    response.sendRedirect("MovieServlet");
}
}
