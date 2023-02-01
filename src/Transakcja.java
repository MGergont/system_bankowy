import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Transakcja {
    public static void dodanieTransakcji(String nr_nadawca, String nr_odbiorca, double kwota){
        LocalDate data = LocalDate.now();
        int id_nadawca = nrKontaNaID(nr_nadawca);
        int id_odbiorca = nrKontaNaID(nr_odbiorca);
        WykonanieZapytania.zapytanieIn("INSERT INTO transakcja VALUES (NULL, "+id_nadawca+", "+id_odbiorca+", '"+data+"', "+kwota+");");
    }

    public static int nrKontaNaID(String nrkonta){
        int id = 0;
        try{
            ResultSet result = WykonanieZapytania.zapytanieOut("SELECT id_konta FROM konto WHERE numer_konta = "+nrkonta+";");
            result.next();
            id = result.getInt("id_konta");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }
}
