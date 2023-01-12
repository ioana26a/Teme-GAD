package Object_Containers;

public class Student extends Persoana{
        public Student (String nume,int varsta) {
                super(nume, varsta);
        }

        @Override
        public String toString() {
                return "Student: " + super.toString();
        }
}
