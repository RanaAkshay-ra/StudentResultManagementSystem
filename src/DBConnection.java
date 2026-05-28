import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/student_result_db";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully!");
        } catch (Exception e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }

        return con;
    }
}