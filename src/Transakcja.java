import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Transakcja {
    public static void dodanieTransakcji(String nr_nadawca, String nr_odbiorca, double kwota) {
        LocalDate data = LocalDate.now();
        int id_nadawca = nrKontaNaID(nr_nadawca);
        int id_odbiorca = nrKontaNaID(nr_odbiorca);
        WykonanieZapytania.zapytanieIn("INSERT INTO transakcja VALUES (NULL, " + id_nadawca + ", " + id_odbiorca + ", '" + data + "', " + kwota + ");");
    }

    public static int nrKontaNaID(String nrkonta) {
        int id = 0;
        try {
            ResultSet result = WykonanieZapytania.zapytanieOut("SELECT id_konta FROM konto WHERE numer_konta = " + nrkonta + ";");
            result.next();
            id = result.getInt("id_konta");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static void wyswietlTransakcje() {
        try {
            ResultSet result = WykonanieZapytania.zapytanieOut("SELECT nadawca.numer_konta, odbiorca.numer_konta, data_transakcji, wartosc_pln FROM transakcja INNER JOIN konto AS nadawca ON transakcja.id_nadawca_konto = nadawca.id_konta INNER JOIN konto AS odbiorca ON transakcja.id_odbiorca_konto = odbiorca.id_konta ORDER BY data_transakcji DESC;");
            while (result.next()){
                String nadawca = result.getString(1);
                String odbiorca = result.getString(2);
                Date data = result.getDate(3);
                Double wartosc = result.getDouble(4);
                System.out.println(nadawca + " " + odbiorca + " " + data + " " + wartosc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}