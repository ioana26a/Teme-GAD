package Object_Containers;

import java.util.ArrayList;
import java.util.Objects;

public class Persoana {
        private String nume;
        private int varsta;

        public Persoana (String name, int varsta){
                this.nume = name;
                this.varsta = varsta;
        }
        public String getNume() {
                return nume;
        }

        public int getVarsta() {
                return varsta;
        }

        @Override
        public String toString() {
                return nume + " " + varsta;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Persoana person = (Persoana) o;
                return nume.equals(person.nume) && varsta == person.varsta;
        }

        @Override
        public int hashCode() {
                return Objects.hash(nume,varsta);
        }
}
