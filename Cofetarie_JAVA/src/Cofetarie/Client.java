package Cofetarie;

public class Client {
        private String nume,adresa,nrTelefon;
        public Client(String nume, String adresa, String nrTelefon){
                this.nume=nume;
                this.adresa=adresa;
                this.nrTelefon=nrTelefon;
        }

        public String getNrTelefon() {
                return nrTelefon;
        }

        public String getNume() {
                return nume;
        }

        public String getAdresa() {
                return adresa;
        }

        @Override
        public String toString() {
                return "Nume:"+nume+"\nAdresa:"+adresa+"\nNumar telefon:"+nrTelefon;
        }
}