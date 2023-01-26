package IOHomework;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
                /*String fileName = "Athlete.csv";
                InputStream is = null;
                try {
                        is = new FileInputStream(fileName);
                        //TennisPlayerCSVParser parser = new TennisPlayerCSVParser();
                        //List<TennisPlayer> players = parser.parsePlayers(is);
                        AthleteCSVReader reader = new AthleteCSVReader();
                        List<Athlete> athletes = reader.readPlayers(new FileReader(fileName));
                        *//*String content = "Roger Federer,3900,37,ATP\n" +
                               "Simona Halep,2900,26,WTA";*//*
                        //List<Athlete> athletes = reader.readPlayers(new StringReader(content));
                        System.out.println(athletes);

                        //Athlete simo = athletes.get(1);
                        //System.out.println(simo);

                        *//*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("simo.obj"));
                        oos.writeObject(simo);
                        oos.flush();
                        oos.close();*//*

                       *//* ObjectInputStream ois = new ObjectInputStream(new FileInputStream("simo.obj"));
                        Object o = ois.readObject();
                        Athlete simo2 = (Athlete) o;
                        System.out.println(simo2);*//*

                } finally {
                        if (is != null) {
                                is.close();
                        }
                }*/


        }
}
