package Resurse;

import Cofetarie.Cofetarie;
import Cofetarie.Produs;
import java.sql.*;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BazaDeDate {
        private static Connection con;
        private static Scanner sc=new Scanner(System.in);

        public static boolean conectare(){
                try{
                        con= DriverManager.getConnection("jdbc:sqlite:Cofetarie.db");
                        return true;
                }catch(Exception e){
                        System.out.println(e);
                }
                return false;
        }
        public static void deconectare(){
                if (con == null) {
                        System.out.println("nu exista conexiune");
                        return;
                }
                try {
                        con.close();
                }catch(SQLException e){ System.out.println(e);}
                System.out.println("deconectat de la baza de date");
        }

        //Operatiuni angajati
        public static void citireDateAngajati(Cofetarie cofetarie) {                //adaugare angajati din baza de date in cofetarie
                int id;
                String nume,prenume,utilizator,parola;
                try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from angajati");
                        while (rs.next()){
                                id=Integer.parseInt(rs.getString(1));
                                nume=rs.getString(2);
                                prenume=rs.getString(3);
                                utilizator=rs.getString(4);
                                parola=rs.getString(5);
                                cofetarie.getAngajati().add(cofetarie.new Angajat(id,nume,prenume,utilizator,parola));
                        }
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }
        public static void inserareAngajat(String nume, String prenume, String utilizator,String parola,Cofetarie cofetarie) {
                if (Operatiuni.cautareUtilizator(utilizator, cofetarie)) {
                        System.out.println("Utilizatorul exista deja.Alegeti alt utilizator");
                        while (Operatiuni.cautareUtilizator(utilizator, cofetarie)) {
                                System.out.print("Utilizator:");
                                utilizator = sc.next();
                        }
                }
                try {
                        int idAngajat;
                        Statement st = con.createStatement();
                        st.execute("insert into Angajati(Nume,Prenume,Utilizator,Parola)values(" +
                                "'" + nume + "','" + prenume + "','" +
                                utilizator + "','" + parola + "');");
                        try {
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery("select idAngajat from angajati where utilizator='" +
                                        utilizator + "';");
                                rs.next();
                                idAngajat = Integer.parseInt(rs.getString(1));
                                cofetarie.getAngajati().add(cofetarie.new Angajat(idAngajat, nume, prenume, utilizator, parola));
                                System.out.println("Angajat adaugat");
                        } catch (SQLException e) {
                                System.out.println(e);
                        }
                } catch (SQLException ex) {
                        System.out.println(ex);
                }
        }
        public static void stergereAngajat(Cofetarie cofetarie,int idAngajat) {
                Cofetarie.Angajat a = Operatiuni.cautareAngajat(idAngajat,cofetarie);
                if(a!=null){
                        try {
                                Statement st = con.createStatement();
                                st.execute("delete from Angajati where IDAngajat=" + a.getIdAngajat() + ";");
                                System.out.println("angajat sters");
                                cofetarie.getAngajati().remove(a);
                        } catch (SQLException e) {
                                System.out.println(e);
                        }
                        return;
                }
                System.out.println("Angajatul nu exista");
        }

        //Operatiuni produse
        public static void citireDateProduse(Cofetarie cofetarie) {                //adaugare produse din baza de date in cofetarie
                String denumire,tip;
                int pret;
                try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from produse");
                        while (rs.next()){
                                denumire=rs.getString(1);
                                tip=rs.getString(3);
                                try{
                                        pret=Integer.parseInt(rs.getString(5));
                                        if(pret != 0){
                                                cofetarie.getMeniuCofetarie().put(tip, new Produs(denumire,pret,tip));
                                                System.out.println("Produsul a fost adaugat");
                                        }
                                }catch (NumberFormatException ex){
                                        System.out.println(ex);
                                }
                        }
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }
        public static void adaugareProdus(Cofetarie cofetarie,String denumire,int pret,String tip){
                if(!cofetarie.getMeniuCofetarie().put(tip, new Produs(denumire,pret,tip))){
                        System.out.println("Produsul deja exista");
                        return;
                }
                try {
                        Statement st = con.createStatement();
                        st.execute("insert into Produse(Denumire,Descriere,Pret,tip)values('"+ denumire +"','"
                                 + "','" + pret +"','" + tip + "');");
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }
        public static void stergereProdus(Cofetarie cofetarie,Produs p) {
                cofetarie.getMeniuCofetarie().remove(p.getTip(), p);
                try {
                        Statement st = con.createStatement();
                        st.execute("delete from Produse where denumire='" + p.getDenumire() + "';");
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }
        public static void actualizareDenumireProdus(Produs p,String denumireNoua) {
                p.setDenumire(denumireNoua);
                try {
                        Statement st = con.createStatement();
                        st.execute("update Produse set denumire='" + denumireNoua + "' where denumire='" + p.getDenumire() + "';");
                } catch (SQLException e) {
                        System.out.println(e);
                }

        }

        public static void actualizarePretProdus(Produs p,int pretNou){
                p.setPret(pretNou);
                try {
                        Statement st = con.createStatement();
                        st.execute("update Produse set pret=" + pretNou + " where denumire='" + p.getDenumire() + "';");
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }
}