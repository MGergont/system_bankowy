import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Polonczenie {
    private static String URL = "jdbc:mysql://localhost:3306/bank_9";
    private static String user = "root";
    private static String pass = "";

    public static Connection connect(){


        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, user, pass);
            System.out.println("Połaczono 1");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}