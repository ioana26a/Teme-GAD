package Resurse;

import Cofetarie.*;

import java.util.Collection;;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operatiuni {
        private static Scanner sc = new Scanner(System.in);
        private static int idAngajatAutentificat=0;

        public static int getIdAngajatAutentificat() {
                return idAngajatAutentificat;
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
        public static void verificareUtilizatorExistent(String utilizator,Cofetarie cofetarie){
                if (Operatiuni.cautareUtilizator(utilizator, cofetarie)) {
                        while (Operatiuni.cautareUtilizator(utilizator, cofetarie)) {
                                System.out.println("Utilizatorul exista deja.Alegeti alt utilizator");
                                System.out.print("Utilizator:");
                                utilizator = sc.next();
                        }
                }
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
        public static Produs cautareProdus(Cofetarie cofetarie) {
                String denumireProdus,tipProdus;
                System.out.print("Denumire produs:");
                denumireProdus = sc.next();
                System.out.print("Tip produs:");
                tipProdus = sc.next();
                return cautare(cofetarie,denumireProdus,tipProdus);
        }
        public static Produs cautare(Cofetarie cofetarie,String denumireProdus,String tipProdus){
                if (cofetarie.getMeniuCofetarie().containsKey(tipProdus)) {
                        for (Produs p : cofetarie.getMeniuCofetarie().get(tipProdus)) {
                                if (p.getDenumire().equals(denumireProdus))
                                        return p;
                        }
                        System.out.println("Produsul nu exista");
                        return null;
                }
                System.out.println("Acest tip de produse nu exista in cofetarie");
                return null;
        }
        private static boolean adaugareProduseComanda(Cofetarie cofetarie, HashMap<Produs,Integer> bon){
                String optiune= sc.next();
                while (!optiune.equals("ok")){
                        Produs p = Operatiuni.cautareProdus(cofetarie);
                        int c = cantitate();
                        if (p != null && c > 0) {
                                bon.put(p,c);
                        }
                }
                if(!bon.isEmpty())
                        return true;
                return false;
        }
        public static int cantitate() {
                System.out.print("Cantitate:");
                try{
                        int cantitate = sc.nextInt();
                        return cantitate;
                }
                catch (InputMismatchException ex){
                        System.out.println(ex);
                }
                return -1;
        }
        public static Comanda plasareComanda(Cofetarie cofetarie,Client client){
                cofetarie.vizualizareMeniu();
                HashMap<Produs,Integer> bon=new HashMap<>();
                if(adaugareProduseComanda(cofetarie,bon)){
                        int sumaTotala=0;
                        for(Produs p : bon.keySet()){
                                sumaTotala+=bon.get(p);
                        }
                        Comanda com=new Comanda(1,sumaTotala,client,bon);
                        return com;
                }
                return null;
        }

        public static void comanda(Cofetarie cofetarie){
                Client c = cautareClient(cofetarie);
                if(c!=null){
                        Comanda comanda = plasareComanda(cofetarie,c);
                        if(comanda!=null){
                                BazaDeDate.adaugareComanda(c.getNrTelefon(),comanda);
                                cofetarie.getComenzi().put(c,comanda);
                                System.out.println("Comanda a fost plasata cu succes!");
                        }
                        System.out.println("Nu au fost adaugate produse in comanda");
                }
                else System.out.println("Clientul nu exista");
        }

        public static Client cautareClient(Cofetarie cofetarie){              //verifica daca exista clientul
                String telefon;
                telefon = sc.next();
                for(Client c:cofetarie.getClienti()){
                        if(c.getNrTelefon().equals(telefon)){
                                return c;
                        }
                }
                return null;
        }
}






