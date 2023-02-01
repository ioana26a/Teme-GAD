package Cofetarie;
import java.util.HashMap;

public class Comanda {
        private int nrComanda,sumaTotala;
        private static int contorComenzi=1;
        private Client client;
        private HashMap<Produs,Integer> bon;
        public Comanda(Client client, int sumaTotala, HashMap<Produs,Integer> bon){
                this.nrComanda=contorComenzi;
                this.sumaTotala=sumaTotala;
                this.client=client;
                this.bon=bon;
                contorComenzi++;
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

        @Override
        public String toString() {
                return "Detalii client\n"+client.toString() + "\nNumar comanda:"+nrComanda + "\nSuma totala:"+sumaTotala;
        }
}
