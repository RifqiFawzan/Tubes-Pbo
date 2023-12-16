package src.Database;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseHandler {
    public static ArrayList<String> data = new ArrayList<>();

    public static void simpanDataPemain(String nama, int jumlahMenang) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            // Perbarui jumlah_menang jika data pemain sudah ada di database
            String updateQuery = "UPDATE user SET jumlah_menang = jumlah_menang + ? WHERE nama = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setInt(1, jumlahMenang);
                updateStatement.setString(2, nama);
                int updatedRows = updateStatement.executeUpdate();

                // Jika tidak ada data yang diupdate, berarti pemain baru, lakukan insert
                if (updatedRows == 0) {
                    String insertQuery = "INSERT INTO user (nama, jumlah_menang) VALUES (?, ?)";
                    try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                        insertStatement.setString(1, nama);
                        insertStatement.setInt(2, jumlahMenang);
                        insertStatement.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> showLeaderboard() {
        ArrayList<String> leaderboardData = new ArrayList<>();
    
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT nama, jumlah_menang FROM user ORDER BY jumlah_menang DESC";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
    
                while (resultSet.next()) {
                    String winnerName = resultSet.getString("nama");
                    int jumlahMenang = resultSet.getInt("jumlah_menang");
    
                    // Assuming you want to display both the name and the number of wins
                    String leaderboardEntry = winnerName + ": " + jumlahMenang + " wins";
                    leaderboardData.add(leaderboardEntry);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return leaderboardData;
    }
}
