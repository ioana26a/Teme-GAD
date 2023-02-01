import Cofetarie.*;
import Resurse.BazaDeDate;
import Resurse.Operatiuni;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                int meniu, varianta;
                Scanner sc = new Scanner(System.in);
                Cofetarie cofetarie;
                Calendar cal = Calendar.getInstance();
                int ora = cal.get(Calendar.HOUR_OF_DAY);
                af();
                if(!BazaDeDate.conectare())
                        return;

                cofetarie = BazaDeDate.citireDateCofetarie();
                if(cofetarie==null)
                        return;

                BazaDeDate.citireDateAngajati(cofetarie);
                BazaDeDate.citireDateProduse(cofetarie);
                System.out.println(cofetarie.getAngajati().get(0));
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
                                        BazaDeDate.adaugareClient(cofetarie);
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
                                                                        BazaDeDate.stergereAngajat(cofetarie);
                                                                        break;
                                                                case 3:
                                                                        BazaDeDate.adaugareProdus(cofetarie);
                                                                        break;
                                                                case 4:
                                                                        BazaDeDate.actualizareDenumireProdus(cofetarie);
                                                                        break;
                                                                case 5:
                                                                        BazaDeDate.actualizarePretProdus(cofetarie);
                                                                        break;
                                                                case 6:
                                                                        BazaDeDate.stergereProdus(cofetarie);
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
