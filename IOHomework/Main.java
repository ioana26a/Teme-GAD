package IOHomework;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
               /* String fileName = "tennisplayers.csv";
                InputStream is = null;
                try {
                        is = new FileInputStream(fileName);
                        //TennisPlayerCSVParser parser = new TennisPlayerCSVParser();
                        //List<TennisPlayer> players = parser.parsePlayers(is);
                        TennisPlayerCSVReader reader = new TennisPlayerCSVReader();
                        //List<TennisPlayer> players = reader.readPlayers(new FileReader(fileName));
                        String content = "Roger Federer,3900,37,ATP\n" +
                                "Simona Halep,2900,26,WTA";
                        List<TennisPlayer> players = reader.readPlayers(new StringReader(content));
                        System.out.println(players);

                        TennisPlayer simo = players.get(1);
                        System.out.println(simo);

                        *//*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("simo.obj"));
                        oos.writeObject(simo);
                        oos.flush();
                        oos.close();*//*

                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("simo.obj"));
                        Object o = ois.readObject();
                        TennisPlayer simo2 = (TennisPlayer) o;
                        System.out.println(simo2);

                } finally {
                        if (is != null) {
                                is.close();
                        }
                }*/

                LocalTime time = LocalTime.of(0,43,40);
                System.out.println(time);

                time = time.plusSeconds(60);
                System.out.println(time);
        }
}
