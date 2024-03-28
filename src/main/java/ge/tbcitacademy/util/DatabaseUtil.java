package ge.tbcitacademy.util;

import ge.tbcitacademy.steps.DatabaseConfigLoader;

import java.sql.*;

public class DatabaseUtil {
    private static final String URL = DatabaseConfigLoader.getProperty("db.url");
    private static final String USER = DatabaseConfigLoader.getProperty("db.username");
    private static final String PASS = DatabaseConfigLoader.getProperty("db.password");

    public static User getUserById(int userId) {
        String query = "SELECT * FROM Users WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
