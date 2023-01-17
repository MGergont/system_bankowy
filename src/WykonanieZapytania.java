import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WykonanieZapytania{
    public static ResultSet zapytanieOut(String zapytanieSelect){
        try{
            Connection connection = Polonczenie.connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(zapytanieSelect);
        }
        catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void zapytanieIn(String zapytanie){
        try{
            Connection connection = Polonczenie.connect();
            Statement statement = connection.createStatement();
            statement.execute(zapytanie);
        }
        catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}