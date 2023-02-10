import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PracownikOpcje {
    private int temp_id_pracownik;
    private int temp_id_adres_2;
    private String temp_haslo;

    public int login(String user, String haslo){
        int status = 0;
        try {
            ResultSet wynik = WykonanieZapytania.zapytanieOut("SELECT login, haslo, uprawnienia, id_pracownik, id_adres_2 FROM pracownik WHERE login = '"+user+"';");
            wynik.next();
            String haslo2 = wynik.getString("haslo");
            this.temp_haslo = wynik.getString("haslo");
            String login = wynik.getString("login");
            this.temp_id_pracownik = wynik.getInt("id_pracownik");
            this.temp_id_adres_2 = wynik.getInt("id_adres_2");
            int perm = wynik.getInt("uprawnienia");
            if (haslo.equals(haslo2)){
                status = perm;
            }
            else
            {
                status = 0;
                System.out.println("złe dane");
            }

        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.print("brak połączenia z tablica users");
            System.out.println("złe dane");
        }
        return status;
    }

    public void ZmienAdres(){
        String kod_pocztowy;
        String miejscowosc;
        int nr_domu;
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nowe dane(Kod pocztowy, Miejscowosc, Numer domu):");
        kod_pocztowy = input.nextLine();
        miejscowosc = input.nextLine();
        nr_domu = input.nextInt();
        WykonanieZapytania.zapytanieIn("UPDATE adres_2 SET kod_pocztowy_2='"+kod_pocztowy+"', miejscowosc_2='"+miejscowosc+"', nr_domu_2="+nr_domu+" WHERE id_adres_2="+temp_id_adres_2+";");
    }

    public void ZmienHaslo(){
        String stare_haslo, nowe_haslo1, nowe_haslo2;
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj stare haslo: ");
        stare_haslo = input.nextLine();
        if (stare_haslo.equals(temp_haslo)){
            System.out.println("Podaj nowe haslo: ");
            nowe_haslo1 = input.nextLine();
            System.out.println("Powtórz nowe haslo: ");
            nowe_haslo2 = input.nextLine();
            if (nowe_haslo2.equals(nowe_haslo1)){
                WykonanieZapytania.zapytanieIn("UPDATE pracownik SET haslo='"+nowe_haslo2+"' WHERE id_pracownik="+temp_id_pracownik+";");
            }
            else {
                System.out.println("Hasla nie sa identyczne");
            }
        }
        else{
            System.out.println("Haslo nie jest prawidlowe");
        }
    }
}
