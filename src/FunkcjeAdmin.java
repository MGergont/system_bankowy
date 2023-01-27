import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FunkcjeAdmin {
    private int id_temp, temp_id_adres;
    public void dodajPracowanik(){
        Scanner input = new Scanner(System.in);
        String imie, nazwisko, haslo, login, kod_pocztowy, miejscowosc;
        int uprawnienia, id_adres = 0, nr_dom;
        double wyplata;
        System.out.println("Podaj imie i nazwisko pracownika");
        imie = input.nextLine();
        nazwisko = input.nextLine();
        System.out.println("Podaj wyplate");
        wyplata = input.nextDouble();
        input.nextLine();
        System.out.println("Podaj kod pocztowy i miejscowosc");
        kod_pocztowy = input.nextLine();
        miejscowosc = input.nextLine();
        System.out.println("Podaj numer domu");
        nr_dom = input.nextInt();
        System.out.println("Podaj login i haslo");
        input.nextLine();
        login = input.nextLine();
        haslo = input.nextLine();
        System.out.println("Podaj stopien uprawnien uzytkownika");
        System.out.println("Uzytkownik - 1");
        System.out.println("Administrator - 2");
        uprawnienia = input.nextInt();
        WykonanieZapytania.zapytanieIn("INSERT INTO adres_2 VALUES ( NULL, '"+kod_pocztowy+"', '"+miejscowosc+"', "+nr_dom+");");
        try {
            ResultSet result = WykonanieZapytania.zapytanieOut("SELECT MAX(id_adres_2) FROM adres_2;");
            result.next();
            id_adres = result.getInt(1);
        }
        catch (SQLException error){
            System.out.println("error");
        }

        WykonanieZapytania.zapytanieIn("INSERT INTO pracownik VALUES ( NULL, '"+imie+"', '"+nazwisko+"', '"+login+"', '"+haslo+"', "+uprawnienia+", "+wyplata+", "+id_adres+");");

    }

    public void wyswietlPraco(){
        try {
            ResultSet result = WykonanieZapytania.zapytanieOut("SELECT id_pracownik, imie, nazwisko, wyplata FROM pracownik;");
            while (result.next()){
                System.out.println(result.getInt("id_pracownik") + " " + result.getString("imie") + " " + result.getString("nazwisko") + " " + result.getDouble("wyplata"));
            }

        }
        catch (SQLException error){
            System.out.println("error");
        }
    }

    public void usunPraco(){
        Scanner input = new Scanner(System.in);
        int id;
        String odpowiedz;
        System.out.println("Podaj id pracownika do usuniencia:");
        id = input.nextInt();
        input.nextLine();
        System.out.println("Czy napewno chcesz usunac pracowanika o id " + id);
        odpowiedz = input.nextLine();
        if(odpowiedz.equals("tak") || odpowiedz.equals("Tak") || odpowiedz.equals("TAK")){
            WykonanieZapytania.zapytanieIn("DELETE FROM adres_2 WHERE id_adres_2 = "+id+";");
        }
    }

    public void infoPracownik(){
        Scanner input = new Scanner(System.in);
        String imie, nazwisko, uprawnienia;
        int id;
        System.out.println("Podaj id");
        id = input.nextInt();
        try{
            ResultSet result = WykonanieZapytania.zapytanieOut("SELECT id_pracownik, adres_2.id_adres_2, imie, nazwisko, login, uprawnienia, wyplata, kod_pocztowy_2, miejscowosc_2, nr_domu_2 FROM pracownik INNER JOIN adres_2 ON pracownik.id_adres_2=adres_2.id_adres_2 WHERE id_pracownik="+id+";;");
            result.next();
            this.id_temp = result.getInt("id_pracownik");
            this.temp_id_adres = result.getInt("id_adres_2");
            if(result.getInt("uprawnienia") == 2){
                uprawnienia = "Administrator";
            }
            else{
                uprawnienia = "Uzytkownik";
            }
            System.out.println(result.getString("imie")+"  "+result.getString("nazwisko")+"  "+result.getString("login")+"  "+result.getDouble("wyplata")+" PLN");
            System.out.println(uprawnienia);
            System.out.println(result.getString("kod_pocztowy_2")+"  "+result.getString("miejscowosc_2")+"  "+result.getString("nr_domu_2"));
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Takiej osoby nie mam w systemie");
        }
    }

    public void zmienImieNazwisko(){
        String imie, nazwisko;
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nowe dane(Imie, Nazwisko)");

        imie = input.nextLine();
        nazwisko = input.nextLine();
        WykonanieZapytania.zapytanieIn("UPDATE pracownik SET imie='"+imie+"', nazwisko='"+nazwisko+"' WHERE id_pracownik="+id_temp+";");
    }

    public void zmienLoginHaslo(){
        String login, haslo;
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nowe dane(login, haslo):");
        login = input.nextLine();
        haslo = input.nextLine();
        WykonanieZapytania.zapytanieIn("UPDATE pracownik SET login='"+login+"', haslo='"+haslo+"' WHERE id_pracownik="+id_temp+";");
    }

    public void zmienUprawnienia(){
        int uprawnienia;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Użytkownik - 1");
            System.out.println("Administrator - 2");
            System.out.println("Podaj opcje:");
            uprawnienia = input.nextInt();
            if (uprawnienia == 1 || uprawnienia == 2) {
                WykonanieZapytania.zapytanieIn("UPDATE pracownik SET uprawnienia="+uprawnienia+" WHERE id_pracownik="+id_temp+";");
            } else {
                System.out.println("Niepoprawne liczba");
                uprawnienia = 10;
            }
        }while (uprawnienia == 10);
    }
    public void zmienWyplate(){
        double wyplata;
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nowe dane(podaj wyplate):");
        wyplata = input.nextDouble();
        WykonanieZapytania.zapytanieIn("UPDATE pracownik SET wyplata="+wyplata+" WHERE id_pracownik="+id_temp+";");
    }

    public void zmienAdres(){
        String kod_pocztowy, miejscowosc;
        int nr_domu;
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nowe dane(Kod pocztowy, Miejscowosc, Numer domu)");
        kod_pocztowy = input.nextLine();
        miejscowosc = input.nextLine();
        nr_domu = input.nextInt();
        WykonanieZapytania.zapytanieIn("UPDATE adres_2 SET kod_pocztowy_2='"+kod_pocztowy+"', miejscowosc_2='"+miejscowosc+"', nr_domu_2="+nr_domu+" WHERE id_adres_2="+temp_id_adres+";");
    }
}
