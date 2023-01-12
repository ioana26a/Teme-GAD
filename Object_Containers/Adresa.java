package Object_Containers;

public class Adresa {
        private String numeStrada,numeOras;
        private int nrStrada;
        private Tara tara;

        public Adresa(String numeOras,String numeStrada, int nrStrada,Tara tara) {
                this.numeStrada = numeStrada;
                this.nrStrada = nrStrada;
                this.tara=tara;
        }

        public Tara getTara() {
                return tara;
        }
}
