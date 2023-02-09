import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PracownikOpcje PrOpcje = new PracownikOpcje();

        System.out.println("Witaj w systemie bankowym");
        int menu, menu2, menu3;
        do{
            System.out.println("Podaj login:");
            String login = input.nextLine();
            System.out.println("Podaj haslo:");
            String haslo = input.nextLine();
            menu = PrOpcje.login(login, haslo);
        }while (menu == 0);
        if(menu == 1){
            do{
                KlientFunkcje klientOpcje = new KlientFunkcje();
                System.out.println("Wyświetl dane klienta -- 1");
                System.out.println("Wyświetl dane konta -- 2");
                System.out.println("Dodaj klienta -- 3");
                System.out.println("Ustwaienia -- 4");
                System.out.println("Zakoncz prace -- 9");
                System.out.println("Podaj liczbę: ");
                menu2 = input.nextInt();

                switch (menu2){
                    case 1:
                        menu3 = 0;
                        klientOpcje.infoKlient();
                        do {
                            System.out.println();
                            System.out.println("Zmien imie, nazwisko, pesel -- 1");
                            System.out.println("Zmien numer telefonu i email -- 2");
                            System.out.println("Zmien adres  -- 3");
                            System.out.println("Zakladanie konta  -- 4");
                            System.out.println("Wstecz  -- 9");
                            System.out.println("Podaj liczbę: ");
                            menu3 = input.nextInt();
                            switch (menu3) {
                                case 1:
                                    klientOpcje.ZmienImieNazwisko();
                                    break;
                                case 2:
                                    klientOpcje.ZmienNumerEmail();
                                    break;
                                case 3:
                                    klientOpcje.ZmienAdres();
                                    break;
                                case 4:
                                    klientOpcje.dodajKonto();
                                    break;
                                case 9:
                                    menu3 = 10;
                                    break;
                                default:
                                    System.out.println("nie wybrano właściwej liczby");
                            }
                        } while (menu3 != 10);
                        break;
                    case 2:
                        menu3 = 0;
                        KontoFunkcje kontoOpcje = new KontoFunkcje();
                        do {
                            kontoOpcje.infoKonto();
                            System.out.println();
                            System.out.println("Wypłata -- 1");
                            System.out.println("Wpłata -- 2");
                            System.out.println("Przelew -- 3");
                            System.out.println("Wstecz -- 9");
                            System.out.println("Podaj liczbę: ");
                            menu3 = input.nextInt();
                            switch (menu3)
                            {
                                case 1:
                                    kontoOpcje.Wyplata();
                                    break;
                                case 2:
                                    kontoOpcje.Wplata();
                                    break;
                                case 3:
                                    kontoOpcje.Przelew();
                                    break;
                                case 9:
                                    menu3 = 10;
                                    break;
                                default:
                                    System.out.println("nie wybrano właściwej liczby");
                            }
                        }while (menu3 != 10);
                        break;
                    case 3:
                        klientOpcje.dodajKlent();
                        break;
                    case 4:
                        menu3 = 0;
                        do {
                            System.out.println();
                            System.out.println("Zmien haslo -- 1");
                            System.out.println("Zmien adres -- 2");
                            System.out.println("Wstecz  -- 9");
                            System.out.println("Podaj liczbę: ");
                            menu3 = input.nextInt();
                            switch (menu3) {
                                case 1:
                                    PrOpcje.ZmienHaslo();
                                    break;
                                case 2:
                                    PrOpcje.ZmienAdres();
                                    break;
                                case 9:
                                    menu3 = 10;
                                    break;
                                default:
                                    System.out.println("nie wybrano właściwej liczby");
                            }

                        } while (menu3 != 10);
                        break;
                    case 9:
                        menu2 = 10;
                        break;
                    default:
                        System.out.println("nie wybrano właściwej liczby");
                }
            }while (menu2 != 10);
        }
        if(menu == 2){
            do{
                KlientFunkcje KlientOpcje = new KlientFunkcje();
                FunkcjeAdmin AdminOpcje = new FunkcjeAdmin();
                System.out.println("Wyświetl dane klienta -- 1");
                System.out.println("Wyświetl dane konta -- 2");
                System.out.println("Ustwaienia -- 3");
                System.out.println("Dodaj klienta  -- 4");
                System.out.println("Dodaj pracownika -- 5");
                System.out.println("Usun pracownika -- 6");
                System.out.println("Edytuj dane pracownika -- 7");
                System.out.println("Wyświetl transakcje -- 8");
                System.out.println("Zakoncz prace -- 9");
                System.out.println("Podaj liczbę: ");
                menu2 = input.nextInt();
                switch (menu2) {
                    case 1:
                        menu3 = 0;
                        KlientOpcje.infoKlient();
                        do {
                            System.out.println();
                            System.out.println("Zmien imie, nazwisko ,pesel -- 1");
                            System.out.println("Zmien numer telefonu i email -- 2");
                            System.out.println("Zmien adres  -- 3");
                            System.out.println("Zakladanie konta  -- 4");
                            System.out.println("Wstecz  -- 9");
                            System.out.println("Podaj liczbę: ");
                            menu3 = input.nextInt();
                            switch (menu3) {
                                case 1:
                                    KlientOpcje.ZmienImieNazwisko();
                                    break;
                                case 2:
                                    KlientOpcje.ZmienNumerEmail();
                                    break;
                                case 3:
                                    KlientOpcje.ZmienAdres();
                                    break;
                                case 4:
                                    KlientOpcje.dodajKonto();
                                    break;
                                case 9:
                                    menu3 = 10;
                                    break;
                                default:
                                    System.out.println("nie wybrano właściwej liczby");
                            }
                        } while (menu3 != 10);
                        break;
                    case 2:
                        menu3 = 0;
                        KontoFunkcje KontoOpcje = new KontoFunkcje();
                        do {
                            KontoOpcje.infoKonto();
                            System.out.println();
                            System.out.println("Wypłata -- 1");
                            System.out.println("Wpłata -- 2");
                            System.out.println("Przelew -- 3");
                            System.out.println("Wstecz -- 9");
                            System.out.println("Podaj liczbę: ");
                            menu3 = input.nextInt();
                            switch (menu3)
                            {
                                case 1:
                                    KontoOpcje.Wyplata();
                                    break;
                                case 2:
                                    KontoOpcje.Wplata();
                                    break;
                                case 3:
                                    KontoOpcje.Przelew();
                                    break;
                                case 9:
                                    menu3 = 10;
                                    break;
                                default:
                                    System.out.println("nie wybrano właściwej liczby");
                            }
                        }while (menu3 != 10);
                        break;
                    case 3:
                        menu3 = 0;
                        do {
                            System.out.println();
                            System.out.println("Zmien haslo-- 1");
                            System.out.println("Zmien adres -- 2");
                            System.out.println("Wstecz  -- 9");
                            System.out.println("Podaj liczbę: ");
                            menu3 = input.nextInt();
                            switch (menu3) {
                                case 1:
                                    PrOpcje.ZmienHaslo();
                                    break;
                                case 2:
                                    PrOpcje.ZmienAdres();
                                    break;
                                case 9:
                                    menu3 = 10;
                                    break;
                                default:
                                    System.out.println("nie wybrano właściwej liczby");
                            }
                        } while (menu3 != 10);
                        break;
                    case 4:
                        KlientOpcje.dodajKlent();
                        break;
                    case 5:
                        AdminOpcje.dodajPracowanik();
                        break;
                    case 6:
                        AdminOpcje.wyswietlPraco();
                        AdminOpcje.usunPraco();
                        break;
                    case 7:
                        menu3 = 0;
                        AdminOpcje.wyswietlPraco();
                        AdminOpcje.infoPracownik();
                        do {
                            System.out.println();
                            System.out.println("Zmien imie, nazwisko -- 1");
                            System.out.println("Zmien login, haslo -- 2");
                            System.out.println("Zmien uprawnienia  -- 3");
                            System.out.println("Zmien wyplate  -- 4");
                            System.out.println("Zmien adres  -- 5");
                            System.out.println("Wstecz  -- 9");
                            System.out.println("Podaj liczbę: ");
                            menu3 = input.nextInt();
                            switch (menu3) {
                                case 1:
                                    AdminOpcje.zmienImieNazwisko();
                                    break;
                                case 2:
                                    AdminOpcje.zmienLoginHaslo();
                                    break;
                                case 3:
                                    AdminOpcje.zmienUprawnienia();
                                    break;
                                case 4:
                                    AdminOpcje.zmienWyplate();
                                    break;
                                case 5:
                                    AdminOpcje.zmienAdres();
                                    break;
                                case 9:
                                    menu3 = 10;
                                    break;
                                default:
                                    System.out.println("nie wybrano właściwej liczby");
                            }
                        } while (menu3 != 10);
                        break;
                    case 8:
                        Transakcja.wyswietlTransakcje();
                        break;
                    case 9:
                        menu2 = 10;
                        break;
                    default:
                        System.out.println("nie wybrano właściwej liczby");
                }
            }while (menu2 != 10);
        }
    }
}
