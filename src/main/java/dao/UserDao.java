package dao;


import model.User;
import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UserDao {
    public void registerUser (User user) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
          String sql = "Insert into Users(name,email,password) Values(?,?,?)";
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, user.getName());
          ps.setString(2, user.getEmail());
          ps.setString(3, user.getPassword());
          ps.executeUpdate();

    }
    public User loginUser (String email, String password) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email") ,
                    rs.getString("password"));
        }
        return null;
    }


}
