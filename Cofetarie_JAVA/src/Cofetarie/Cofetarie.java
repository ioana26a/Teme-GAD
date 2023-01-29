package Cofetarie;
import Resurse.MultiMap;

import java.util.ArrayList;

public class Cofetarie {
        private String nume;
        private int oraInchidere, oraDeschidere;
        private ArrayList<Angajat> angajati = new ArrayList<>();
        private ArrayList<Client> clienti = new ArrayList<>();
        private MultiMap<String,Produs> meniuCofetarie= new MultiMap<>();
        public Cofetarie(String nume, int oraDeschidere, int oraInchidere) {
                this.nume = nume;
                this.oraDeschidere = oraDeschidere;
                this.oraInchidere = oraInchidere;
        }
        public MultiMap<String, Produs> getMeniuCofetarie() {
                return meniuCofetarie;
        }

        public ArrayList<Client> getClienti() {
                return clienti;
        }
        public ArrayList<Angajat> getAngajati() {
                return angajati;
        }

        @Override
        public String toString() {
                return "Cofetaria " + nume + " este deschisa in intervalul orar " + oraDeschidere + ":00-" + oraInchidere + ":00.";
        }

        public boolean verificareProgram(int n) {
                return (n >= oraDeschidere && n <= oraInchidere);
        }

        public void vizualizareMeniu() {
                System.out.println("\t--- Meniu " + nume + " ---\n");
                for (String tip : meniuCofetarie.keySet()) {
                        System.out.println(tip);
                        for (Produs p : meniuCofetarie.get(tip)) {
                                System.out.println(p);
                        }
                }
        }
        public void plasareComanda(){

        }
        public class Angajat {
                private String nume, prenume, utilizator, parola;
                private int idAngajat;

                public Angajat(int idAngajat, String nume, String prenume, String utilizator, String parola) {
                        this.idAngajat = idAngajat;
                        this.nume = nume;
                        this.prenume = prenume;
                        this.utilizator = utilizator;
                        this.parola = parola;
                }
                public String getUtilizator() {
                        return utilizator;
                }

                public String getParola() {
                        return parola;
                }

                public int getIdAngajat() {
                        return idAngajat;
                }

                @Override
                public String toString() {
                        return idAngajat + "  " + nume + "  " + prenume;
                }
        }
}
