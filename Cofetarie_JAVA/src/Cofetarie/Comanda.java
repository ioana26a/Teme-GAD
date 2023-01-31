package Cofetarie;
import java.util.HashMap;

public class Comanda {
        private int nrComanda,sumaTotala;
        private Client client;
        private HashMap<Produs,Integer> bon;
        public Comanda(int nrComanda, int sumaTotala, Client client, HashMap<Produs,Integer> bon){
                this.nrComanda=nrComanda;
                this.sumaTotala=sumaTotala;
                this.client=client;
                this.bon=bon;
        }

        public int getSumaTotala() {
                return sumaTotala;
        }

        public int getNrComanda() {
                return nrComanda;
        }

        public StringBuilder getBon() {
                StringBuilder st=new StringBuilder();
                for (Produs p : bon.keySet()) {
                        st.append(p.getDenumire() + "x" + bon.get(p).toString() + ",");
                }
                st.setCharAt(st.lastIndexOf(","),' ');
                return st;
        }
}
