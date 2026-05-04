package servlet;

import dao.ExpenseDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Expense;
import model.User;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

public class AddexpenseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String category = request.getParameter("category");
        String dateStr = request.getParameter("date");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();

        Expense expense = new Expense(0, userId, title, amount, category, Date);

        try {
            ExpenseDao expenseDao = new ExpenseDao();
            expenseDao.addExpense(expense);
            response.sendRedirect("dashboard");
        } catch (SQLException | ClassNotFoundException | ParseException e) {
            e.printStackTrace();
            response.sendRedirect("add-expense.jsp?error=failed");
        }
    }
}
