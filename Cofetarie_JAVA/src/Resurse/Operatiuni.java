package Resurse;

import Cofetarie.Cofetarie;
import Cofetarie.Produs;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operatiuni {
        private static Scanner sc = new Scanner(System.in);
        private static int idAngajatAutentificat=0;

        public static int getIdAngajatAutentificat() {
                return idAngajatAutentificat;
        }

        public static void setIdAngajatAutentificat(int idAngajatAutentificat) {
                Operatiuni.idAngajatAutentificat = idAngajatAutentificat;
        }

        public static Produs cautareProdus(Cofetarie cofetarie, String denumire, String tip) {
                if (cofetarie.getMeniuCofetarie().containsKey(tip)) {
                        Collection<Produs> ex;
                        ex = cofetarie.getMeniuCofetarie().get(tip);
                        for (Produs p : ex) {
                                if (p.getDenumire().equals(denumire))
                                        return p;
                        }
                        System.out.println("Produsul nu exista");
                        return null;
                }
                System.out.println("Acest tip de produse nu exista in cofetarie");
                return null;
        }
        public static boolean autentificare(Cofetarie cofetarie){
                System.out.print("Username:");
                String utilizator=sc.next();
                System.out.print("Parola:");
                String parola=sc.next();
                if(verificareUtilizator(utilizator,parola,cofetarie))
                        return true;
                return false;
        }
        public static boolean verificareUtilizator(String utilizator, String parola,Cofetarie cofetarie){
                for(Cofetarie.Angajat a:cofetarie.getAngajati()){
                        if(a.getUtilizator().equals(utilizator)){
                                if (a.getParola().equals(parola)){
                                        idAngajatAutentificat = a.getIdAngajat();
                                        return true;
                                }
                        }
                }
                return false;
        }
        public static Cofetarie.Angajat cautareAngajat(int idAngajat,Cofetarie cofetarie) {
                for(Cofetarie.Angajat a:cofetarie.getAngajati()){
                        if(a.getIdAngajat() == idAngajat)
                                return a;
                }
                return null;
        }
        public static boolean cautareUtilizator(String user,Cofetarie cofetarie) {
                for(Cofetarie.Angajat a:cofetarie.getAngajati()){
                        if(a.getUtilizator().equals(user))
                                return true;
                }
                return false;
        }
}
