package servlet;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String email =  request.getParameter("email");
       String password =  request.getParameter("password");

        try {
            UserDao userDao = new UserDao();
            User user = userDao.loginUser(email, password);

            if(user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("dashboard");
            } else {
                response.sendRedirect("login.jsp?error=invalid");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=failed");
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }
}
