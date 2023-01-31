package Resurse;

import Cofetarie.Cofetarie;
import Cofetarie.Cofetarie.Angajat;
import Cofetarie.Produs;
import Cofetarie.Comanda;
import java.sql.*;
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
        public static Cofetarie citireDateCofetarie(){
                Cofetarie cofetarie=null;
                try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from cofetarie");
                        citireCofetarie(rs);
                } catch (SQLException e) {
                        System.out.println(e);
                }
                if(cofetarie!=null)
                        return cofetarie;
                return null;
        }
        private static Cofetarie citireCofetarie(ResultSet rs) throws SQLException {
                String nume;
                int oraDes,oraInch;
                Cofetarie cofetarie=null;
                if(rs.next()){
                        nume=rs.getString(1);
                        oraDes=Integer.parseInt(rs.getString(2));
                        oraInch=Integer.parseInt(rs.getString(3));
                        cofetarie=new Cofetarie(nume,oraDes,oraInch);
                        return cofetarie;
                }
                return null;
        }
        //Operatiuni angajati
        public static void citireDateAngajati(Cofetarie cofetarie) {                //adaugare angajati din baza de date in cofetarie
                try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from angajati");
                        citireAngajat(cofetarie,rs);
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }
        public static void citireAngajat(Cofetarie cofetarie,ResultSet rs) throws SQLException {
                int id;
                String nume,prenume,utilizator,parola;
                while (rs.next()){
                        id=Integer.parseInt(rs.getString(1));
                        nume=rs.getString(2);
                        prenume=rs.getString(3);
                        utilizator=rs.getString(4);
                        parola=rs.getString(5);
                        cofetarie.getAngajati().add(cofetarie.new Angajat(id,nume,prenume,utilizator,parola));
                }
        }
        public static void inserareAngajat(Cofetarie cofetarie) {
                Angajat a = detaliiAngajat(cofetarie);
                Operatiuni.verificareUtilizatorExistent(a.getUtilizator(),cofetarie);
                try {
                        Statement st = con.createStatement();
                        st.execute("insert into Angajati(Nume,Prenume,Utilizator,Parola)values(" +
                                "'" + a.getNume() + "','" + a.getPrenume() + "','" +
                                a.getUtilizator() + "','" + a.getParola() + "');");
                        adaugareId(a,cofetarie);     //dupa ce se adauga id-ul il adauga in arraylist angajati
                } catch (SQLException ex) {
                        System.out.println(ex);
                }
        }
        public static Cofetarie.Cofetarie.Angajat detaliiAngajat(Cofetarie cofetarie){
                String nume, prenume, utilizator, parola;
                System.out.print("Nume:");
                nume = sc.next();
                System.out.print("Prenume:");
                prenume = sc.next();
                System.out.print("Utilizator:");
                utilizator = sc.next();
                System.out.print("Parola:");
                parola = sc.next();
                return cofetarie.new Angajat(0,nume, prenume, utilizator, parola);
        }
        public static void adaugareId(Angajat a,Cofetarie cofetarie) throws SQLException {
                int idAngajat;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select idAngajat from angajati where utilizator='" +
                        a.getUtilizator() + "';");
                rs.next();
                idAngajat = Integer.parseInt(rs.getString(1));
                a.setIdAngajat(idAngajat);
                cofetarie.getAngajati().add(a);
                System.out.println("Angajat a fost adaugat");
        }

        public static void stergereAngajat(Cofetarie cofetarie) {
                System.out.print("Id angajat:");
                int idAngajat = sc.nextInt();
                Cofetarie.Angajat a = Operatiuni.cautareAngajat(idAngajat,cofetarie);
                if(a!=null){
                        stergere(cofetarie,a);
                        return;
                }
                System.out.println("Angajatul nu exista");
        }
        public static void stergere(Cofetarie cofetarie,Angajat a){
                try {
                        Statement st = con.createStatement();
                        st.execute("delete from Angajati where IDAngajat=" + a.getIdAngajat() + ";");
                        System.out.println("Angajatul a fost sters");
                        cofetarie.getAngajati().remove(a);
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }

        //Operatiuni produse
        public static void citireDateProduse(Cofetarie cofetarie) {                //adaugare produse din baza de date in cofetarie

                try {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from produse");
                        citireProduse(cofetarie,rs);
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }
        public static void citireProduse(Cofetarie cofetarie,ResultSet rs) throws SQLException {
                String denumire,tip;
                int pret;
                while (rs.next()){
                        denumire=rs.getString(1);
                        tip=rs.getString(3);
                        try{
                                pret=Integer.parseInt(rs.getString(2));
                                if(pret != 0){
                                        cofetarie.getMeniuCofetarie().put(tip, new Produs(denumire,pret,tip));
                                        System.out.println("Produsul a fost adaugat");
                                }
                        }catch (NumberFormatException ex){
                                System.out.println(ex);
                        }
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
        public static void adaugareComanda(String numarTelefon, Comanda comanda){
                try {
                        Statement st = con.createStatement();
                        st.execute("insert into `istoric comenzi`(`Nr. bon`,`Telefon client`,produse,`suma totala`,`data plasarii`)" +
                                "values(" + comanda.getNrComanda() + "," + numarTelefon + ",'" + comanda.getBon() + "'," +
                                comanda.getSumaTotala() + ",DATE('now'));");
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }

}