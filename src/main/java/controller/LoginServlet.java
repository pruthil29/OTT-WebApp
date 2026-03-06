package controller;

import dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.User;


public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.validateUser(username, password);

        if (user != null) {
            HttpSession session=request.getSession();
            session.setAttribute("username",user.getUsername());
            session.setAttribute("userRole", user.getRole());
            if(user.getRole().equals("admin")){
                response.sendRedirect("AdminDashboard.jsp");
            }else{
            response.sendRedirect("MovieServlet");
            }
                return;
        } else {
            request.setAttribute("errorMessage", "Invalid Username or Password");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    
}
}