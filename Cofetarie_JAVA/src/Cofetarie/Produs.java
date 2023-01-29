package Cofetarie;

public class Produs {
        private String denumire,tip;
        private int pret;
        public Produs(String denumire, int pret, String tip){
                this.denumire=denumire;
                this.pret=pret;
                this.tip=tip;
        }

        public String getDenumire() {
                return denumire;
        }

        public String getTip() {
                return tip;
        }

        public void setDenumire(String denumire) {
                this.denumire = denumire;
        }


        public void setPret(int pret) {
                this.pret = pret;
        }

        @Override
        public String toString() {
                return denumire + " costa " + pret + " lei.";
        }
}