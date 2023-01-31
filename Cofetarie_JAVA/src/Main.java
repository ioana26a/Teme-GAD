import Cofetarie.*;
import Resurse.BazaDeDate;
import Resurse.Operatiuni;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                int meniu,varianta,pret;
                Scanner sc=new Scanner(System.in);
                String denumireProdus, tipProdus;
                Cofetarie cofetarie;
                Produs p;
                Comanda comanda;

                Calendar cal = Calendar.getInstance();
                int ora = cal.get(Calendar.HOUR_OF_DAY);
                if(BazaDeDate.conectare()) {
                        System.out.println("Conectat la baza de date");

                        cofetarie = BazaDeDate.citireDateCofetarie();
                        BazaDeDate.citireDateAngajati(cofetarie);
                        BazaDeDate.citireDateProduse(cofetarie);

                        do {
                                meniu = getMeniu(sc);
                                switch (meniu) {
                                        case 1:
                                                cofetarie.verificareProgram(ora);
                                                break;
                                        case 2:
                                                cofetarie.vizualizareMeniu();
                                                break;
                                        case 3:
                                                Operatiuni.comanda(cofetarie);
                                                break;
                                        case 4:
                                                //adaugare client
                                                break;
                                        case 5:
                                                if (Operatiuni.getIdAngajatAutentificat() != 0 || (Operatiuni.getIdAngajatAutentificat() == 0 && Operatiuni.autentificare(cofetarie)))
                                                        do {
                                                                varianta = getSubmeniu(sc);
                                                                switch (varianta) {
                                                                        case 1:
                                                                                BazaDeDate.inserareAngajat(cofetarie);
                                                                                break;
                                                                        case 2:
                                                                                /*if (Operatiuni.getIdAngajatAutentificat() == idAngajat) {
                                                                                        BazaDeDate.stergereAngajat(cofetarie, idAngajat);
                                                                                        Operatiuni.setIdAngajatAutentificat(0);
                                                                                        varianta = 0;
                                                                                        break;
                                                                                }*/
                                                                                BazaDeDate.stergereAngajat(cofetarie);
                                                                                break;
                                                                        case 3:

                                                                                System.out.print("Denumire:");
                                                                                denumireProdus = sc.next();
                                                                                System.out.print("Tip produs:");
                                                                                tipProdus = sc.next();
                                                                                try {
                                                                                        pret = sc.nextInt();
                                                                                } catch (
                                                                                        InputMismatchException ex) {
                                                                                        System.out.println(ex);
                                                                                        System.out.println("Produsul nu a fost adaugat.");
                                                                                        break;
                                                                                }
                                                                                BazaDeDate.adaugareProdus(cofetarie, denumireProdus, pret, tipProdus);
                                                                                break;
                                                                        case 4:
                                                                                System.out.print("Denumire produs:");
                                                                                denumireProdus = sc.next();
                                                                                System.out.print("Tip produs:");
                                                                                tipProdus = sc.next();
                                                                                p = Operatiuni.cautareProdus(cofetarie, denumireProdus, tipProdus);
                                                                                if (p != null) {
                                                                                        String denumireNoua;
                                                                                        System.out.print("Denumire noua produs:");
                                                                                        denumireNoua = sc.next();
                                                                                        if (denumireNoua.length() < 30) {
                                                                                                System.out.println("Denumirea nu poate fi mai lunga de 30 de caractere");
                                                                                                return;
                                                                                        }
                                                                                        BazaDeDate.actualizareDenumireProdus(p, denumireNoua);
                                                                                }

                                                                                break;
                                                                        case 5:
                                                                                System.out.print("Denumire produs:");
                                                                                denumireProdus = sc.next();
                                                                                System.out.print("Tip produs:");
                                                                                tipProdus = sc.next();
                                                                                p = Operatiuni.cautareProdus(cofetarie, denumireProdus, tipProdus);
                                                                                if (p != null) {
                                                                                        int pretNou;
                                                                                        System.out.print("Pret nou:");
                                                                                        try {
                                                                                                pretNou = sc.nextInt();
                                                                                                if (pretNou > 1) {
                                                                                                        p.setPret(pretNou);
                                                                                                        BazaDeDate.actualizarePretProdus(p, pretNou);
                                                                                                        System.out.println("Pretul a fost actualizat.");
                                                                                                } else
                                                                                                        System.out.println("Pretul nu poate fi negativ sau egal cu 0");
                                                                                        } catch (
                                                                                                InputMismatchException ex) {
                                                                                                System.out.println(ex);
                                                                                        }
                                                                                }
                                                                                break;
                                                                        case 6:
                                                                                System.out.print("Denumire produs:");
                                                                                denumireProdus = sc.next();
                                                                                System.out.print("Tip produs:");
                                                                                tipProdus = sc.next();
                                                                                p = Operatiuni.cautareProdus(cofetarie, denumireProdus, tipProdus);
                                                                                if (p != null)
                                                                                        BazaDeDate.stergereProdus(cofetarie, p);
                                                                                break;
                                                                        default:

                                                                                System.out.println("Varianta gresita");
                                                                                break;

                                                                }
                                                        }
                                                        while (varianta != 0);
                                                break;
                                        default:
                                                break;
                                }
                        }
                        while (meniu != 0);
                        BazaDeDate.deconectare();
                }
                else System.out.println("Nu s-a realizat conexiunea.Va rugam incercati din nou");
        }

        private static int getMeniu(Scanner sc) {
                int meniu;
                System.out.println("1.Verificare program ");
                System.out.println("2.Vizualizare meniu ");
                System.out.println("3.Plasare comanda");
                System.out.println("4.Adaugare client");
                System.out.println("5.Autentificare angajat");
                System.out.println("0.Iesire\n");
                System.out.print("Optiune:");
                meniu = sc.nextInt();
                return meniu;
        }
        private static int getSubmeniu(Scanner sc) {
                int varianta;
                System.out.println("1.Adaugare angajat");
                System.out.println("2.Stergere angajat");
                System.out.println("3.Adaugare produs");
                System.out.println("4.Actualizare denumire produs ");
                System.out.println("5.Actualizare pret produs ");
                System.out.println("6.Stergere produs");
                System.out.println("0.Inapoi\n");
                System.out.print("Optiune:");
                varianta = sc.nextInt();
                return varianta;
        }
}
