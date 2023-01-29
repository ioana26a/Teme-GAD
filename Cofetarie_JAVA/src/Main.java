import Cofetarie.Cofetarie;
import Cofetarie.Produs;
import Resurse.BazaDeDate;
import Resurse.Operatiuni;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                int meniu,varianta,oraDes,oraInch;
                Scanner sc=new Scanner(System.in);
                String numeCofetarie,denumireProdus, tipProdus,nume, prenume, utilizator, parola;
                Cofetarie cofetarie=null;
                Produs p=null;

                Calendar cal = Calendar.getInstance();
                int ora = cal.get(Calendar.HOUR_OF_DAY);
                if(BazaDeDate.conectare()) {
                        System.out.println("Conectat la baza de date");
                        System.out.print("Introduceti nume cofetarie:");
                        numeCofetarie = sc.next().concat(sc.nextLine());
                        try {
                                System.out.print("Introduceti ora de deschidere:");
                                oraDes = sc.nextInt();
                                System.out.print("Introduceti ora de inchidere:");
                                oraInch = sc.nextInt();
                                cofetarie = new Cofetarie(numeCofetarie, oraDes, oraInch);
                                System.out.println(cofetarie);
                        } catch (InputMismatchException ex) {
                                System.out.println(ex);
                        }

                        BazaDeDate.citireDateAngajati(cofetarie);
                        BazaDeDate.citireDateProduse(cofetarie);

                        for (Cofetarie.Angajat a : cofetarie.getAngajati()) {
                                System.out.println(a);
                        }
                        do {
                                System.out.println("1.Verificare program ");
                                System.out.println("2.Vizualizare meniu ");
                                System.out.println("3.Plasare comanda");
                                System.out.println("4.Adaugare client");
                                System.out.println("5.Autentificare angajat");
                                System.out.println("0.Iesire\n");
                                System.out.print("Optiune:");
                                meniu = sc.nextInt();
                                switch (meniu) {
                                        case 1:
                                                if (cofetarie.verificareProgram(ora)) {
                                                        System.out.println("Cofetaria este deschisa");
                                                } else System.out.println("Cofetaria este inchisa");
                                                break;
                                        case 2:
                                                cofetarie.vizualizareMeniu();
                                                break;
                                        case 3:
                                                cofetarie.plasareComanda();
                                                break;
                                        case 4:
                                                //adaugare client
                                                break;
                                        case 5:
                                                if (Operatiuni.getIdAngajatAutentificat() == 0)
                                                        if (Operatiuni.autentificare(cofetarie)) {
                                                                do {
                                                                        System.out.println("1.Adaugare angajat");
                                                                        System.out.println("2.Stergere angajat");
                                                                        System.out.println("3.Adaugare produs");
                                                                        System.out.println("4.Actualizare denumire produs ");
                                                                        System.out.println("5.Actualizare pret produs ");
                                                                        System.out.println("6.Stergere produs");
                                                                        System.out.println("0.Inapoi\n");
                                                                        System.out.print("Optiune:");
                                                                        varianta = sc.nextInt();
                                                                        switch (varianta) {
                                                                                case 1:
                                                                                        System.out.print("Nume:");
                                                                                        nume = sc.next();
                                                                                        System.out.print("Prenume:");
                                                                                        prenume = sc.next();
                                                                                        System.out.print("Utilizator:");
                                                                                        utilizator = sc.next();
                                                                                        System.out.print("Parola:");
                                                                                        parola = sc.next();
                                                                                        BazaDeDate.inserareAngajat(nume, prenume, utilizator, parola, cofetarie);
                                                                                        break;
                                                                                case 2:
                                                                                        System.out.print("Id angajat:");
                                                                                        int idAngajat = sc.nextInt();
                                                                                        if (Operatiuni.getIdAngajatAutentificat() == idAngajat) {
                                                                                                BazaDeDate.stergereAngajat(cofetarie, idAngajat);
                                                                                                Operatiuni.setIdAngajatAutentificat(0);
                                                                                                varianta = 0;
                                                                                                break;
                                                                                        }
                                                                                        BazaDeDate.stergereAngajat(cofetarie, idAngajat);
                                                                                        break;
                                                                                case 3:
                                                                                        String descriere;
                                                                                        int pret;
                                                                                        System.out.print("Denumire:");
                                                                                        denumireProdus = sc.next();
                                                                                        System.out.print("Descriere:");
                                                                                        descriere = sc.next();
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
                                                                                        if (p != null){
                                                                                                String denumireNoua;
                                                                                                System.out.print("Denumire noua produs:");
                                                                                                denumireNoua=sc.next();
                                                                                                if(denumireNoua.length()<25){
                                                                                                        System.out.println("Denumirea nu poate fi mai luga de 25 de caractere");
                                                                                                        return;
                                                                                                }
                                                                                                BazaDeDate.actualizareDenumireProdus(p,denumireNoua);
                                                                                        }

                                                                                        break;
                                                                                case 5:
                                                                                        System.out.print("Denumire produs:");
                                                                                        denumireProdus = sc.next();
                                                                                        System.out.print("Tip produs:");
                                                                                        tipProdus = sc.next();
                                                                                        p = Operatiuni.cautareProdus(cofetarie, denumireProdus, tipProdus);
                                                                                        if (p != null){
                                                                                                int pretNou;
                                                                                                System.out.print("Pret nou:");
                                                                                                try {
                                                                                                        pretNou= sc.nextInt();
                                                                                                        if(pretNou > 1){
                                                                                                                p.setPret(pretNou);
                                                                                                                BazaDeDate.actualizarePretProdus(p,pretNou);
                                                                                                                System.out.println("Pretul a fost actualizat.");
                                                                                                        }
                                                                                                        else System.out.println("Pretul nu poate fi negativ sau egal cu 0");
                                                                                                } catch (InputMismatchException ex)
                                                                                                {
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
                                                        } else System.out.println("Autentificare esuata");
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
}
