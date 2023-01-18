import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class KlientFunkcje {
    private int temp_id;
    private int temp_id_kontakt;
    private int temp_id_adres;

    public void dodajKlent(){
        Scanner input = new Scanner(System.in);
        String imie, nazwisko, pesel, email, kod_pocztowy, miejscowosc;
        int telefon, id_adres = 0, id_kontakt = 0, nr_dom;
        double wyplata;
        System.out.println("Podaj imie, nazwisko, pesel klienta");
        imie = input.nextLine();
        nazwisko = input.nextLine();
        pesel = input.nextLine();
        System.out.println("Podaj kod pocztowy i miejscowosc");
        kod_pocztowy = input.nextLine();
        miejscowosc = input.nextLine();
        System.out.println("Podaj numer domu");
        nr_dom = input.nextInt();
        input.nextLine();
        System.out.println("Podaj email i telefon");
        email = input.nextLine();
        telefon = input.nextInt();
        WykonanieZapytania.zapytanieIn("INSERT INTO adres VALUES ( NULL, '"+kod_pocztowy+"', '"+miejscowosc+"', "+nr_dom+");");
        WykonanieZapytania.zapytanieIn("INSERT INTO `kontakt` VALUES (NULL, "+telefon+", '"+email+"');");
        try {
            ResultSet wynik = WykonanieZapytania.zapytanieOut("SELECT MAX(id_adres) FROM adres;");
            wynik.next();
            id_adres = wynik.getInt(1);
            ResultSet wynik2 = WykonanieZapytania.zapytanieOut("SELECT MAX(id_kontakt) FROM kontakt;");
            wynik2.next();
            id_kontakt = wynik2.getInt(1);
        }
        catch (SQLException error){
            System.out.println("error");
        }

        WykonanieZapytania.zapytanieIn("INSERT INTO klient VALUES ( NULL, '"+imie+"', '"+nazwisko+"', '"+pesel+"', "+id_kontakt+", "+id_adres+");");
    }

    public void dodajKonto(){
        Scanner input = new Scanner(System.in);
        String nr_konto;
        System.out.println("Podaj numer konta:");
        nr_konto = input.nextLine();
        WykonanieZapytania.zapytanieIn("INSERT INTO konto VALUES (NULL, '"+nr_konto+"', 0, "+temp_id+");");
    }

    public void infoKlient(){
        Scanner input = new Scanner(System.in);
        String imie, nazwisko;
        System.out.println("Podaj imie i nazwisko:");
        imie = input.nextLine();
        nazwisko = input.nextLine();
        try{
            ResultSet wynik = WykonanieZapytania.zapytanieOut("SELECT id_klient, klient.id_kontakt, klient.id_adres, imie, nazwisko, pesel, kod_pocztowy, miejscowosc, nr_domu, telefon, email FROM klient INNER JOIN adres ON adres.id_adres=klient.id_adres INNER JOIN kontakt ON kontakt.id_kontakt=klient.id_kontakt WHERE imie='"+imie+"' AND nazwisko='"+nazwisko+"';");
            wynik.next();
            this.temp_id = wynik.getInt("id_klient");
            this.temp_id_adres = wynik.getInt("id_adres");
            this.temp_id_kontakt = wynik.getInt("id_kontakt");
            System.out.println(wynik.getString("imie")+"  "+wynik.getString("nazwisko")+"  "+wynik.getString("pesel"));
            System.out.println(wynik.getString("kod_pocztowy")+"  "+wynik.getString("miejscowosc")+"  "+wynik.getString("nr_domu"));
            System.out.println(wynik.getInt("telefon")+"  "+wynik.getString("email"));
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Takiej osoby nie mam w systemie");
        }
    }

    public void ZmienImieNazwisko(){
        String imie, nazwisko, pesel;
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nowe dane(Imie, Nazwisko, Pesel)");

        imie = input.nextLine();
        nazwisko = input.nextLine();
        pesel = input.nextLine();
        WykonanieZapytania.zapytanieIn("UPDATE klient SET imie='"+imie+"', nazwisko='"+nazwisko+"', pesel='"+pesel+"' WHERE id_klient="+temp_id+";");
    }

    public void ZmienNumerEmail(){
        String email;
        int numer_tel;
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nowe dane(Email, Numer telefonu)");
        email = input.nextLine();
        numer_tel = input.nextInt();
        WykonanieZapytania.zapytanieIn("UPDATE kontakt SET telefon="+numer_tel+", email='"+email+"' WHERE id_kontakt="+temp_id_kontakt+";");
    }

    public void ZmienAdres(){
        String kod_pocztowy;
        String miejscowosc;
        int nr_domu;
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nowe dane(Kod pocztowy, Miejscowosc, Numer domu)");
        kod_pocztowy = input.nextLine();
        miejscowosc = input.nextLine();
        nr_domu = input.nextInt();
        WykonanieZapytania.zapytanieIn("UPDATE adres SET kod_pocztowy='"+kod_pocztowy+"', miejscowosc='"+miejscowosc+"', nr_domu="+nr_domu+" WHERE id_adres="+temp_id_adres+";");
    }
}
