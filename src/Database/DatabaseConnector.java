package src.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ulartangga";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal: " + e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Tes koneksi berhasil!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
