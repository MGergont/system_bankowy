import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class KontoFunkcje {
    private int temp_id;
    private double temp_stanKonta;
    private String temp_numer_konta;

    public void infoKonto(){
        Scanner input = new Scanner(System.in);
        String imie, nazwisko;
        System.out.println("Podaj imie i nazwisko:");
        imie = input.nextLine();
        nazwisko = input.nextLine();
        try{
            ResultSet wynik = WykonanieZapytania.zapytanieOut("SELECT id_konta, imie, nazwisko, pesel, numer_konta, stan_konta FROM konto INNER JOIN klient on klient.id_klient=konto.id_klient WHERE imie='"+imie+"' AND nazwisko='"+nazwisko+"';;");
            wynik.next();
            this.temp_id = wynik.getInt("id_konta");
            this.temp_stanKonta = wynik.getDouble("stan_konta");
            this.temp_numer_konta = wynik.getString("numer_konta");
            System.out.println(wynik.getString("imie")+"  "+wynik.getString("nazwisko")+"  "+wynik.getString("pesel"));
            System.out.println(wynik.getString("numer_konta")+"  "+wynik.getDouble("stan_konta"));
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Takiego konta nie mam w systemie");
        }
    }

    public void Wyplata(){
        double kwota;
        Scanner input2 = new Scanner(System.in);
        System.out.println("Podaj kwote:");
        kwota = input2.nextDouble();

        if (temp_stanKonta > kwota){
            temp_stanKonta = temp_stanKonta - kwota;
            WykonanieZapytania.zapytanieIn("UPDATE konto SET stan_konta="+temp_stanKonta+" WHERE id_konta="+temp_id+";");
        }
        else {
            System.out.println("Na końcie nie ma wystarczajaco pieniedzy");
        }
    }

    public void Wplata(){
        double kwota;
        Scanner input2 = new Scanner(System.in);
        System.out.println("Podaj kwote:");
        kwota = input2.nextDouble();

        if (kwota > 0){
            temp_stanKonta = temp_stanKonta + kwota;
            WykonanieZapytania.zapytanieIn("UPDATE konto SET stan_konta="+temp_stanKonta+" WHERE id_konta="+temp_id+";");
        }
        else {
            System.out.println("Kwota jest ujemna");
        }
    }

    public void Przelew(){
        double kwota, stan_konta2 = 0;

        String nr_nadawca, nr_odbiorca;
        Scanner input2 = new Scanner(System.in);
        System.out.println("Podaj kwote:");
        nr_odbiorca = input2.nextLine();
        kwota = input2.nextDouble();
        nr_nadawca = temp_numer_konta;

        try{
            ResultSet result = WykonanieZapytania.zapytanieOut("SELECT stan_konta FROM konto WHERE numer_konta='"+nr_odbiorca+"';;");
            result.next();
            stan_konta2 = result.getDouble("stan_konta");

        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Takiego konta nie mam w systemie");
        }

        if (temp_stanKonta > kwota){
            temp_stanKonta = temp_stanKonta - kwota;
            stan_konta2 = stan_konta2 + kwota;
            WykonanieZapytania.zapytanieIn("UPDATE konto SET stan_konta="+temp_stanKonta+" WHERE numer_konta='"+nr_nadawca+"';");
            WykonanieZapytania.zapytanieIn("UPDATE konto SET stan_konta="+stan_konta2+" WHERE numer_konta='"+nr_odbiorca+"';");
            Transakcja.dodanieTransakcji(nr_nadawca, nr_odbiorca, kwota);
        }
        else {
            System.out.println("Kwota jest ujemna");
        }
    }
}
