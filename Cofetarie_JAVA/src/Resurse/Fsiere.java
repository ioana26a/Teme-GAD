package Resurse;

import Cofetarie.Cofetarie;
import Cofetarie.Comanda;
import Cofetarie.Client;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fsiere {
        public static void citirePrajituri(Cofetarie cof){
                String denumire,descriere,tip,nextLine;
                int pret;
                Scanner input;
                File file = new File("src\\Produse.txt");
                try {
                        input = new Scanner(file);
                        while (input.hasNextLine()) {
                                nextLine=input.nextLine();
                                String arr[]=nextLine.split(",");
                                denumire=arr[0];
                                descriere=arr[1];
                                tip=arr[3];
                                if(denumire.equals("") || descriere.equals("") || tip.equals("")){
                                        System.out.println("Produsul nu are toate campurile completate.Nu se poate adauga");
                                        continue;
                                }
                                try{
                                        pret = Integer.parseInt(arr[2]);
                                        if(pret < 1){
                                                System.out.println("Produsul nu poate avea pretul negativ sau egal cu 0.Nu se poate adauga");
                                                continue;
                                        }
                                        BazaDeDate.adaugareProdus(cof,denumire,pret,tip);
                                }catch (NumberFormatException ex){
                                        System.out.println(ex);
                                }
                        }
                        input.close();
                } catch (IOException ex) {
                        System.out.println(ex);
                }
        }
        public static void citireClienti(Cofetarie cof){
                String nume,adresa,telefon,nextLine;
                try {
                        Scanner input ;
                        File file = new File("src\\Clienti.txt");
                        input = new Scanner(file);

                        while (input.hasNextLine()) {
                                nextLine=input.nextLine();
                                String arr[]=nextLine.split(",");
                                nume=arr[0];
                                adresa=arr[1];
                                telefon=arr[2];
                                if(nume.equals("") || adresa.equals("") || telefon.equals("")){
                                        System.out.println("Clientul nu are toate campurile completate.Nu se poate adauga");
                                        continue;
                                }
                                cof.getClienti().add(new Client(nume,adresa,telefon));
                        }
                        input.close();
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }
        public static void scriereComanda(Comanda comanda){
                try {
                        FileWriter myWriter = new FileWriter("src\\Istoric_comenzi_cofetarie.txt");
                        myWriter.write(comanda.toString());
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}
