package dao;

import model.Expense;
import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;




public class ExpenseDao {
    public void addExpense(Expense e) throws SQLException, ClassNotFoundException {
        Connection c = DBConnection.getConnection();
        String sql = "INSERT INTO expenses (user_id, title , amount, category, date ) VALUES (?, ?, ? , ? ,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, e.getUserId());
        ps.setString(2, e.getTitle());
        ps.setDouble(3, e.getAmount());
        ps.setString(4, e.getCategory());
        ps.setDate(5, new java.sql.Date(e.getDate().getTime()));
        ps.executeUpdate();

        ps.close();

    }

    public List<Expense> getAllExpenses(int userId) throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM expenses WHERE user_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();

        List<Expense> list = new ArrayList<>();

        while (rs.next()) {
            Expense e = new Expense(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getDouble("amount"),
                    rs.getString("category"),
                    rs.getDate("date")

            );
            list.add(e);
        }
        return list;
    }

    public void deleteExpense(int id) throws SQLException ,  ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM expenses WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public Expense getExpenseById(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM expenses WHERE id=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Expense e = new Expense(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getDouble("amount"),
                    rs.getString("category"),
                    rs.getDate("date")
            );
            return e;
        }
        return null;
    }

    public void updateExpense(Expense e) throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE expenses SET title=?, amount=?, category=?, date=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, e.getTitle());
        ps.setDouble(2, e.getAmount());
        ps.setString(3, e.getCategory());
        ps.setDate(4, new java.sql.Date(e.getDate().getTime()));
        ps.setInt(5, e.getId());
        ps.executeUpdate();
        ps.close();

    }
}


