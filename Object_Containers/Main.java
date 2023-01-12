package Object_Containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
        public static void main(String[] args) {
                TreeSet<Persoana> persoane = new TreeSet<>(new PersoanaNumeComparator());
                Persoana p1=new Angajat("Bob",23);
                Persoana p2=new Somer("Andrew",19);
                Persoana p3=new Angajat("Tamara",32);
                Persoana p4=new Student("Mary",17);
                Persoana p5=new Student("Luke",25);

                persoane.add(p1);
                persoane.add(p2);
                persoane.add(p3);
                persoane.add(p4);
                persoane.add(p5);
                System.out.println("Persoane ordonate dupa nume");
                for(Persoana p:persoane){
                        System.out.println(p);
                }

                TreeSet<Persoana> persoane1 = new TreeSet<>(new PersoanaVarstaComparator());
                persoane1.add(p1);
                persoane1.add(p2);
                persoane1.add(p3);
                persoane1.add(p4);
                persoane1.add(p5);

                System.out.println("\nPersoane ordonate dupa varsta");
                for(Persoana p:persoane1){
                        System.out.println(p);
                }

                //Hobby info

                Tara t1=new Tara("Romania");
                Tara t2=new Tara("Italia");
                Tara t3=new Tara("Spania");

                Adresa adresa1=new Adresa("Targu Mures","Brasovului",23,t1);
                Adresa adresa2=new Adresa("Bucuresti","Iuliu Maniu",35,t1);
                Adresa adresa3=new Adresa("Milano","G. Leopardi",2,t2);
                Adresa adresa4=new Adresa("Genova","Giovanni Torti",17,t2);
                Adresa adresa5=new Adresa("Madrid","C. Mariblanca",11,t3);
                Adresa adresa6=new Adresa("Valencia","d'Elvissa",15,t3);

                ArrayList<Adresa>adresa_dans=new ArrayList<>();
                adresa_dans.add(adresa1);
                adresa_dans.add(adresa3);
                ArrayList<Adresa>adresa_pictura=new ArrayList<>();
                adresa_pictura.add(adresa1);
                adresa_pictura.add(adresa5);
                ArrayList<Adresa>adresa_ciclism=new ArrayList<>();
                adresa_ciclism.add(adresa6);
                adresa_ciclism.add(adresa3);
                ArrayList<Adresa>adresa_golf=new ArrayList<>();
                adresa_golf.add(adresa3);
                adresa_golf.add(adresa5);
                ArrayList<Adresa>adresa_lectura=new ArrayList<>();
                adresa_lectura.add(adresa2);
                adresa_lectura.add(adresa3);

                Hobby hobbyPers1_1=new Hobby("dans",2,adresa_dans);
                Hobby hobbyPers1_2=new Hobby("golf",4,adresa_golf);

                Hobby hobbyPers2_1=new Hobby("lectura",2,adresa_lectura);
                Hobby hobbyPers2_2=new Hobby("pictura",4,adresa_pictura);

                Hobby hobbyPers3_1=new Hobby("ciclism",2,adresa_ciclism);
                Hobby hobbyPers3_2=new Hobby("pictura",4,adresa_pictura);


                ArrayList<Hobby> hobbiesPersoana1=new ArrayList<>();                    //Bob
                hobbiesPersoana1.add(hobbyPers1_1);
                hobbiesPersoana1.add(hobbyPers1_2);

                ArrayList<Hobby> hobbiesPersoana2=new ArrayList<>();                    //Andrew
                hobbiesPersoana2.add(hobbyPers2_1);
                hobbiesPersoana2.add(hobbyPers2_2);

                ArrayList<Hobby> hobbiesPersoana3=new ArrayList<>();                    //Tamara
                hobbiesPersoana3.add(hobbyPers3_1);
                hobbiesPersoana3.add(hobbyPers3_2);


                HashMap<Persoana, ArrayList<Hobby>> hobbyPersoane =new HashMap<>();
                hobbyPersoane.put(p1,hobbiesPersoana1);
                hobbyPersoane.put(p2,hobbiesPersoana2);
                hobbyPersoane.put(p3,hobbiesPersoana3);

                System.out.println("\nAfisare hobby-uri Bob");
                for(HashMap.Entry<Persoana,ArrayList<Hobby>> m : hobbyPersoane.entrySet()){
                        if(m.getKey().equals(p1)){
                                System.out.println(m.getKey());
                                for (Hobby h:m.getValue()) {
                                        System.out.println(h.printInfo());
                                }
                        }
                }
        }
}
