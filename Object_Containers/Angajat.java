package Object_Containers;

public class Angajat extends Persoana{
        public Angajat(String nume,int varsta) {
                super(nume, varsta);
        }

        @Override
        public String toString() {
                return "Angajat: " + super.toString();
        }
}
