package Object_Containers;

import java.util.ArrayList;
public class Hobby {
        private String nume;
        private int frequency;
        private ArrayList<Adresa> adrese=new ArrayList<>();
        Hobby(String nume,int frequency,ArrayList<Adresa> adrese){
                this.nume=nume;
                this.frequency=frequency;
                this.adrese=adrese;
        }
        public String printInfo(){
                StringBuilder tara = new StringBuilder();
                for(Adresa a:adrese){
                        tara.append(a.getTara().getNume() + "  ");
                }
               return nume + " - " + tara;
        }
}

