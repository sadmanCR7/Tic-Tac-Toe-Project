package TicTacToePlay;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/TicTacToeDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS game_results ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "player1 VARCHAR(50),"
                    + "player2 VARCHAR(50),"
                    + "winner VARCHAR(50)"
                    + ")";
            stmt.executeUpdate(createTable);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveGameResult(String player1, String player2, String winner) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO game_results (player1, player2, winner) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, player1);
            pstmt.setString(2, player2);
            pstmt.setString(3, winner);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

