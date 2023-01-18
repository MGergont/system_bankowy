import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PracownikOpcje PrOpcje = new PracownikOpcje();

        int menu, menu2, menu3;
        do{
            System.out.println("Podaj login:");
            String login = input.nextLine();
            System.out.println("Podaj haslo");
            String haslo = input.nextLine();
            menu = PrOpcje.login(login, haslo);
        }while (menu == 0);
        if(menu == 1){
            do{
                //KlientFunctions funkcja = new KlientFunctions();
                System.out.println("Wyświetl dane klienta -- 1");
                System.out.println("Wyświetl dane konta -- 2");
                System.out.println("Dodaj klienta -- 3");
                System.out.println("Ustwaienia -- 4");
                System.out.println("Zakoncz prace -- 9");
                System.out.println("Podaj liczbę: ");
                menu2 = input.nextInt();

            }while (menu2 != 10);
        }
        if(menu == 2){
            do{
                // rejestr przelewów
                // dodawanie klientów
                // rejestr przelewów ???
                System.out.println("Wyświetl dane klienta -- 1");
                System.out.println("Wyświetl dane konta -- 2");
                System.out.println("Ustwaienia -- 3");
                System.out.println("Zakladanie konta  -- 4");
                System.out.println("Dodaj pracownika -- 5");
                System.out.println("Usun pracownika -- 6");
                System.out.println("Edytuj dane pracownika -- 7");
                System.out.println("Zakoncz prace -- 9");
                System.out.println("Podaj liczbę: ");
                menu2 = input.nextInt();
            }while (menu2 != 10);
        }
    }
}