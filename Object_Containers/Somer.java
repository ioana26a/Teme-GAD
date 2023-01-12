package Object_Containers;

public class Somer extends Persoana{
        public Somer(String nume,int varsta) {
                super(nume, varsta);
        }

        @Override
        public String toString() {
                return "Somer: " + super.toString();
        }
}
